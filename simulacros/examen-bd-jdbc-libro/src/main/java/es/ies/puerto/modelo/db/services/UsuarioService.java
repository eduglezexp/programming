package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.modelo.abstractas.Conexion;
import es.ies.puerto.modelo.db.entidades.Usuario;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioService extends Conexion{

    /**
     * Metodo para ejecutar la querry
     * @param sql  ejecutar
     * @param parametros del usuario
     * @return lista de usuarios
     */
    private List<Usuario> executeQuerry(String sql, String... parametros){
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setString(i + 1, parametros[i]);
            }
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                    String dni = resultado.getString("id_usuario");
                    String nombreStr = resultado.getString("nombre");
                    String emailStr = resultado.getString("email");
                    String telefonoStr = resultado.getString("telefono");
                    Date fechaRegistro = resultado.getDate("fecha_registro");
                    Usuario usuario = new Usuario(dni, nombreStr, emailStr, telefonoStr, fechaRegistro);
                    usuarios.add(usuario);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    /**
     * Metodo para crear un usuario
     * @param usuario a crear
     */
    public boolean crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id_usuario, nombre, email, telefono, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, usuario.getIdUsuario());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getEmail());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setDate(5, null);
            boolean resultado = sentencia.executeUpdate() > 0;
            return resultado;
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
        return executeQuerry(sql);
    }
    
    /**
     * Metodo para obtener un usuario dado su id
     * @return lista de usuarios
     */
    public Usuario obtenerUsuarioPorId(String idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ? ";
        List<Usuario> usuarios = executeQuerry(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.iterator().next();
    }

    /**
     * Metodo para actualizar el usuario
     * @return true/false
     */
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id_usuario = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getEmail());
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
     * Metodo para eliminar un usuario
     * @param idUsuario a eliminar
     * @return true/false
     */
    public boolean eliminarUsuario(String idUsuario) {
        String sql = "DELETE FROM usuarios WHERE dni = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, idUsuario);
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
}
