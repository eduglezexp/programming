package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Prestamo;
import es.ies.puerto.modelo.db.services.abstractas.AbstractService;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class PrestamoService extends AbstractService<Prestamo> {

    /**
     * Metodo para mapear las filas del prestamo
     * @param resultado que contiene el executeQuery()
     * @return un prestamo con sus propiedades
     */

    @Override
    protected Prestamo mapRow(ResultSet resultado) throws SQLException {
        String idPrestamo = resultado.getString("id_prestamo");
        String libroId = resultado.getString("libro_id");
        String usuarioId = resultado.getString("usuario_id");
        Date fechaPrestamo = resultado.getDate("fecha_prestamo");
        Date fechaDevolucion = resultado.getDate("fecha_devolucion");
        return new Prestamo(idPrestamo, libroId, usuarioId, fechaPrestamo, fechaDevolucion);
    }

    /**
     * Metodo para crear un prestamo
     * @param prestamo a crear
     * @return true/false
     */
    public boolean crearPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (id_prestamo, libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, prestamo.getIdPrestamo());
            sentencia.setString(2, prestamo.getLibroId());
            sentencia.setString(3, prestamo.getUsuarioId());
            sentencia.setString(4, prestamo.getFechaPrestamo());
            sentencia.setString(5, prestamo.getFechaDevolucion());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para obtener todos los prestamos
     * @return lista de prestamos
     */
    public List<Prestamo> obtenerTodosPrestamos() {
        String sql = "SELECT * FROM prestamos";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener un prestamo dado su id
     * @param id del prestamo a buscar
     * @return prestamo solicitado
     */
    public Prestamo obtenerPrestamoPorId(String id) {
        String sql = "SELECT * FROM prestamos WHERE id_prestamo = ?";
        List<Prestamo> prestamos = executeQuery(sql, id);
        if (prestamos.isEmpty()) {
            return null;
        }
        return prestamos.iterator().next();
    }

    /**
     * Metodo para actualizar a un prestamo
     * @param autor a actualizar
     * @return true/false
     */
    public boolean actualizarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE prestamos SET libro_id = ?, usuario_id = ?, fecha_prestamo = ?, fecha_devolucion = ? WHERE id_prestamo = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, prestamo.getLibroId());
            sentencia.setString(2, prestamo.getUsuarioId());
            sentencia.setString(3, prestamo.getFechaPrestamo());
            sentencia.setString(4, prestamo.getFechaDevolucion());
            sentencia.setString(5, prestamo.getIdPrestamo());
            sentencia.executeUpdate();
            int filas = sentencia.executeUpdate();
            return filas == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para eliminar a un prestamo
     * @param id del prestamo a eliminar
     * @return true/false
     */
    public boolean eliminarPrestamo(String id) {
        String sql = "DELETE FROM prestamos WHERE id_prestamo = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, id);
            int filas = sentencia.executeUpdate();
            return filas == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para obtener los prestamos vencidos
     * @param fechaLimite del prestamo
     * @return lista con los prestamos vencidos
     */
    public List<Prestamo> obtenerPrestamosVencidos(Date fechaLimite) {
        String sql = "SELECT * FROM prestamos WHERE fecha_devolucion < ?";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaLimiteStr = simpleDateFormat.format(fechaLimite);
        return executeQuery(sql, fechaLimiteStr);
    }

    /**
     * Metodo para obtener los prestamos de un usuario
     * @param idUsuario del usuario
     * @return lista con los prestamos del usuario
     */
    public List<Prestamo> obtenerPrestamosPorUsuario(String idUsuario) {
        String sql = "SELECT * FROM prestamos WHERE usuario_id = ?";
        return executeQuery(sql, idUsuario);
    }

    /**
     * Metodo para obtener los prestamos activos
     * @return lista con los prestamos activos
     */
    public List<Prestamo> obtenerPrestamosActivos() {
        String sql = "SELECT * FROM prestamos WHERE fecha_devolucion IS NULL OR fecha_devolucion > CURRENT_DATE";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los prestamos no devueltos
     * @return lista con los prestamos no devueltos
     */
    public List<Prestamo> obtenerPrestamosNoDevueltos() {
        String sql = "SELECT * FROM prestamos WHERE fecha_devolucion IS NULL";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los detalles de los prestamos dado un id
     * @param idPrestamo a buscar el prestamo con los detalles
     * @return lista de prestamos con detalles
     */
    public List<Prestamo> obtenerPrestamosConDetalles(String idPrestamo) {
        String sql = "SELECT p.id_prestamo, " +
                     "l.titulo AS libro, " +
                     "a.nombre AS autor, " + 
                     "u.nombre AS usuario, " + 
                     "p.fecha_prestamo, " + 
                     "p.fecha_devolucion " + 
                     "FROM prestamos p " + 
                     "JOIN libros l " + 
                     "ON p.libro_id = l.id_libro " + 
                     "JOIN autores a " + 
                     "ON l.autor_dni = a.dni " + 
                     "JOIN usuarios u " + 
                     "ON p.usuario_id = u.id_usuario " + 
                     "WHERE id_prestamo = ?";
        return executeQuery(sql, idPrestamo);
    }

    /**
     * Metodo para obtener los prestamos dado un mes y un anio
     * @param mes del prestamo
     * @param anio del prestamo
     * @return lista de prestamos de un mes y un anio concreto
     */
    public List<Prestamo> obtenerPrestamosMesAnio(String mes, String anio) {
        String sql = "SELECT * FROM prestamos WHERE fecha_prestamo " +
                     "BETWEEN '" + anio + "-" + mes + "-01' AND '" + anio + "-" + mes + "-30'";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener la duracion de los prestamos devueltos
     * @return lista de la duracion de los prestamos devueltos
     */
    public List<Prestamo> obtenerDuracionPrestamosDevueltos() {
        String sql = "SELECT id_prestamo, " + 
                     "fecha_prestamo, " +
                     "fecha_devolucion, " + 
                     "DATEDIFF(fecha_devolucion, fecha_prestamo) AS duracion_dias " +
                     "FROM prestamos " + 
                     "WHERE fecha_devolucion IS NOT NULL";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener todos los prestamos con retraso suponiendo x dias de prestamos
     * @param dias de prestamo
     * @return una lista con todos los prestamos con retraso suponiendo x dias de prestamos
     */
    public List<Prestamo> obtenerPrestamosConRetrasoPorDias(int dias) {
        String sql = "SELECT * " + 
                     "FROM prestamos " + 
                     "WHERE (fecha_devolucion IS NOT NULL " +
                     "AND DATEDIFF(fecha_devolucion, fecha_prestamo) > " + dias + ") " + 
                     "OR (fecha_devolucion IS NULL " + 
                     "AND DATEDIFF(CURDATE(), fecha_prestamo) > " + dias + ")";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los prestamos con devolución pendiente y dias transcurridos
     * @return lista de prestamos
     */
    public List<Prestamo> obtenerPrestamosSinDelvolverMasDias() {
        String sql = "SELECT p.*, " +
                     "DATEDIFF(CURDATE(), p.fecha_prestamo) AS dias_transcurridos " +
                     "FROM prestamos p " +
                     "WHERE p.fecha_devolucion IS NULL";
        return executeQuery(sql);
    }

    /**
     * Metodo que devuelve los prestamos que han sido devueltos rapidamente (menos de 10 dias)
     * @return lista de prestamos
     */
    public List<Prestamo> obtenerPrestamosDevueltosRapidamente() {
        String sql = "SELECT * FROM prestamos " + 
                     "WHERE fecha_devolucion IS NOT NULL " +
                     "AND DATEDIFF(fecha_devolucion, fecha_prestamo) < 10";
        return executeQuery(sql);
    }
}