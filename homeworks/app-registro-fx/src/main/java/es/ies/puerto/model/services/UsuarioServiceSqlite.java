package es.ies.puerto.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.model.abstractas.Conexion;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioServiceSqlite extends Conexion{

    /**
     * Constructor por defecto
     */
    public UsuarioServiceSqlite() {

    }

    /**
     * Contructor con la ruta del archivo de la bbdd
     * @param unaRutaArchivoBD path de la bbdd
     * @throws SQLException error controlado
     */
    public UsuarioServiceSqlite(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    /**
     * Metodo que obtiene un usuario por su email o nombre de usuario
     * @param input email o nombre de usuario
     * @return usuario encontrado o null si no existe
     */
    public UsuarioEntitySqlite obtenerUsuarioPorEmailOUser(String input) {
        String sql = "SELECT * FROM usuarios " + "WHERE email='"+input+"' OR user='"+input+"'";
        try {
            ArrayList<UsuarioEntitySqlite> usuarios = obtenerUsuario(sql);
            if (usuarios.isEmpty()) {
                return null;
            }
            return usuarios.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     * @return lista de usuarios
     * @throws SQLException error controlado
     */
    public ArrayList<UsuarioEntitySqlite> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuarios";
        return obtenerUsuario(sql);
    }

    /**
     * Metodo que ejecuta una consulta SQL para obtener usuarios
     * @param sql consulta SQL a ejecutar
     * @return lista de usuarios obtenidos
     * @throws SQLException error controlado
     */
    public ArrayList<UsuarioEntitySqlite> obtenerUsuario(String sql) throws SQLException{
        ArrayList<UsuarioEntitySqlite> usuarios = new ArrayList<UsuarioEntitySqlite>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                int usuarioId = resultado.getInt("id");
                String usuarioStr = resultado.getString("user");
                String emailStr = resultado.getString("email");
                String nombreStr = resultado.getString("name");
                String contraseniaStr = resultado.getString("password");
                UsuarioEntitySqlite usuarioEntityModel = new UsuarioEntitySqlite(usuarioId, usuarioStr, emailStr, nombreStr, contraseniaStr);
                usuarios.add(usuarioEntityModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }

    /**
     * Metodo para insertar un usuario
     * @throws SQLException error controlado
     */
    public boolean insertarUsuario(UsuarioEntitySqlite usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (user, email, name, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, usuario.getUser());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getName());
            sentencia.setString(4, usuario.getPassword());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }
}