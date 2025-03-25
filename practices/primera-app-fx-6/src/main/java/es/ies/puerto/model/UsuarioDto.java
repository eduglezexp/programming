package es.ies.puerto.model;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.model.abstractas.Conexion;

public class UsuarioDto extends Conexion{

    public UsuarioDto() {

    }

    public UsuarioDto(String unaRutaArchivoBD) throws SQLException, FileNotFoundException {
        super(unaRutaArchivoBD);
    }

    public UsuarioModel obtenerUsuarioPorEmail(String email) throws SQLException{
        String sql = "SELECT * FROM usuario " + "WHERE email='"+email+"'";
        ArrayList<UsuarioModel> usuarios = obtenerUsuario(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return  usuarios.get(0);
    }

    public ArrayList<UsuarioModel> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuario";
        return obtenerUsuario(sql);
    }

    public ArrayList<UsuarioModel> obtenerUsuario(String sql) throws SQLException{
        ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                String nombreStr = resultado.getString("nombre");
                String contraseniaStr = resultado.getString("contrasenia");
                String emailStr = resultado.getString("email");
                UsuarioModel usuarioModel = new UsuarioModel(emailStr, nombreStr, contraseniaStr);
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