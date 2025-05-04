package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Usuario;
import es.ies.puerto.modelo.db.services.abstractas.AbstractService;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioService extends AbstractService<Usuario> {

    /**
     * Metodo para mapear las filas del usuario
     * @param resultado que contiene el executeQuery()
     * @return un usuario con sus propiedades
     */
    @Override
    protected Usuario mapRow(ResultSet resultado) throws SQLException {
        String dni = resultado.getString("id_usuario");
        String nombreStr = resultado.getString("nombre");
        String emailStr = resultado.getString("email");
        String telefonoStr = resultado.getString("telefono");
        Date fechaRegistro = resultado.getDate("fecha_registro");
        return new Usuario(dni, nombreStr, emailStr, telefonoStr, fechaRegistro);
    }

    /**
     * Metodo para crear un usuario
     * @param usuario a crear
     */
    public boolean crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id_usuario, nombre, email, telefono, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, usuario.getIdUsuario());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getEmail());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getFechaRegistro());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        return false;
    }

    /**
     * Metodo para obtener todos los usuarios
     * @return lista de usuarios
     */
    public List<Usuario> obtenerTodosUsuarios() {
        String sql = "SELECT * FROM usuarios";
        return executeQuery(sql);
    }
    
    /**
     * Metodo para obtener un usuario dado su id
     * @return lista de usuarios
     */
    public Usuario obtenerUsuarioPorId(String idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        List<Usuario> usuarios = executeQuery(sql, idUsuario);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.iterator().next();
    }

    /**
     * Metodo para actualizar el usuario
     * @param usuario a actualizar
     * @return true/false
     */
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, telefono = ?, fecha_registro = ? WHERE id_usuario = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getTelefono());
            sentencia.setString(4, usuario.getFechaRegistro());
            sentencia.setString(5, usuario.getIdUsuario());
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
     * Metodo para eliminar un usuario
     * @param idUsuario a eliminar
     * @return true/false
     */
    public boolean eliminarUsuario(String idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, idUsuario);
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
     * Metodo para obtener los usuarios registrados entre un anio dado
     * @param anio anio a partir del cual se buscan usuarios registrados 
     * en ese anio
     * @return lista de usuarios registrados en ese anio
     */
    public List<Usuario> obtenerUsuariosRegistradosEn(int anio) {
        String sql = "SELECT * FROM usuarios WHERE fecha_registro " +
        "BETWEEN '" + anio + "-01-01' AND '" + anio + "-12-31'";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los usuarios con prestamos activos
     * @return lista con los usuarios con prestamos activos
     */
    public List<Usuario> obtenerUsuariosConPrestamosActivos() {
        String sql = "SELECT DISTINCT u.* " + 
                     "FROM usuarios u " + 
                     "JOIN prestamos p " + 
                     "ON u.id_usuario = p.usuario_id " +
                     "WHERE fecha_devolucion IS NULL OR fecha_devolucion > CURRENT_DATE";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener el conteo de los prestamos por usuario
     * @return lista con el conteo de los prestamos por usuario
     */
    public List<Usuario> obtenerConteoPrestamosPorUsuario() {
        String sql = "SELECT u.id_usuario, " + 
                     "u.nombre, " + 
                     "COUNT(p.id_prestamo) AS total_prestamos " + 
                     "FROM usuarios u " + 
                     "LEFT JOIN prestamos p " + 
                     "ON u.id_usuario = p.usuario_id " + 
                     "GROUP BY u.id_usuario, u.nombre";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los ultimos prestamos de cada usuario
     * @return una lista con los ultimos prestamos de cada usuario
     */
    public List<Usuario> obtenerUsuariosUltimosPrestamos() {
        String sql = "SELECT u.nombre, " + 
                     "p.id_prestamo, " + 
                     "p.fecha_prestamo " + 
                     "FROM usuarios u " + 
                     "JOIN prestamos p " + 
                     "ON u.id_usuario = p.usuario_i " + 
                     "WHERE p.fecha_prestamo = ( " + 
                     "SELECT MAX(fecha_prestamo) " + 
                     "FROM prestamos " +
                     "WHERE usuario_id = u.id_usuario)";
        return executeQuery(sql);
    }

    /**
     * Metodo que obtiene los usuarios con el dominio GMAIL
     * @return lista de usuarios
     */
    public List<Usuario> obtenerUsuariosConGmail() {
        String sql = "SELECT * FROM usuarios WHERE email REGEXP '^[^@]+@gmail\\.com$'";
        return executeQuery(sql);
    }

    /**
     * Metodo que obtiene los prestamos que tiene cada usuario en un mes y anio dado 
     * @param mes del prestamo
     * @param anio del prestamo
     * @return lista de usuarios
     */
    public List<Usuario> obtenerPrestamoMesAnio(String mes, String anio) {
        String sql = "SELECT DISTINCT u.* FROM usuarios u " +
                     "JOIN prestamos p " + 
                     "ON u.id_usuario = p.usuario_id " +
                     "WHERE p.fecha_prestamo " + 
                     "BETWEEN '" + anio + "-" + mes + "-01' AND '" + anio + "-" + mes + "-31'";
        return executeQuery(sql);
    }
}
