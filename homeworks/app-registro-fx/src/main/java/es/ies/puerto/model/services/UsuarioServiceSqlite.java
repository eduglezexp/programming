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

    public UsuarioServiceSqlite() {

    }

    public UsuarioServiceSqlite(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public UsuarioEntitySqlite obtenerUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios " + "WHERE email='"+email+"'";
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

    public ArrayList<UsuarioEntitySqlite> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuarios";
        return obtenerUsuario(sql);
    }

    public ArrayList<UsuarioEntitySqlite> obtenerUsuario(String sql) throws SQLException{
        ArrayList<UsuarioEntitySqlite> usuarios = new ArrayList<UsuarioEntitySqlite>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String usuarioStr = resultado.getString("user");
                String contraseniaStr = resultado.getString("password");
                //String nombreStr = resultado.getString("nombre");
                String emailStr = resultado.getString("email");
                UsuarioEntitySqlite usuarioEntityModel = new UsuarioEntitySqlite(usuarioStr, emailStr, contraseniaStr);
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
     */
    public void insertarUsuario() {

    }
}