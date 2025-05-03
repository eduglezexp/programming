package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
