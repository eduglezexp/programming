package es.ies.puerto.modelo.db.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Autor;
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

    public boolean actualizarPrestamo(Prestamo prestamo) {
        String sql = "UPDATE autores SET nombre = ?, fecha_prestamo = ?, fecha_devolucion = ? " +
        "WHERE id_prestamo = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            //sentencia.setString(1, prestamo);
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

    public boolean eliminarPrestamo(String id) {
        String sql = "DELETE FROM prestamos WHERE id_prestamo = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, id);
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


    public List<Prestamo> obtenerPrestamosVencidos(Date fechaLimite) {
        List<Prestamo> resultado = new ArrayList<>();
        
        return resultado;
    }

    public List<Prestamo> obtenerPrestamosPorUsuario(String idUsuario) {
        List<Prestamo> resultado = new ArrayList<>();
        

        return resultado;
    }

    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> resultado = new ArrayList<>();
        

        return resultado;
    }
}
