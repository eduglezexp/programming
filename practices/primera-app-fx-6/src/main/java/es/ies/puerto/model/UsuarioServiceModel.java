package es.ies.puerto.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.model.abstractas.Conexion;

public class UsuarioServiceModel extends Conexion{

    public UsuarioServiceModel() {

    }

    public UsuarioServiceModel(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public UsuarioEntity obtenerUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuario " + "WHERE email='"+email+"'";
        try {
            ArrayList<UsuarioEntity> usuarios = obtenerUsuario(sql);
            if (usuarios.isEmpty()) {
                return null;
            }
            return usuarios.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<UsuarioEntity> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuario";
        return obtenerUsuario(sql);
    }

    public ArrayList<UsuarioEntity> obtenerUsuario(String sql) throws SQLException{
        ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String nombreStr = resultado.getString("nombre");
                String contraseniaStr = resultado.getString("contrasenia");
                String emailStr = resultado.getString("email");
                UsuarioEntity usuarioModel = new UsuarioEntity(emailStr, nombreStr, contraseniaStr);
                usuarios.add(usuarioModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return usuarios;
    }
}