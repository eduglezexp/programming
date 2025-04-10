package es.ies.puerto.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
     * @throws SQLException error controlado
     */
    public List<UsuarioEntitySqlite> obtenerUsuarioPorEmailOUser(String input) throws SQLException {
        String sql = "SELECT * FROM usuarios " + "WHERE email=? OR user=?";
        return obtenerUsuario(sql, input, input);
    }

    /**
     * Metodo que obtiene un usuario dado su email, user, name o id
     * @param input email o nombre de usuario
     * @return usuario encontrado o null si no existe
     * @throws SQLException error controlado
     */
    public List<UsuarioEntitySqlite> obtenerUsuarioPorInput(String input) throws SQLException {
        String sql = "SELECT * FROM usuarios " + "WHERE email=? OR user=? OR name=? OR id=?";
        return obtenerUsuario(sql, input, input, input, input);
    }
    
    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     * @return lista de usuarios
     * @throws SQLException error controlado
     */
    public List<UsuarioEntitySqlite> obtenerUsuarios() throws SQLException{
        String sql = "SELECT * FROM usuarios";
        return obtenerUsuario(sql);
    }

    /**
     * Metodo que ejecuta una consulta SQL para obtener usuarios
     * @param sql consulta SQL a ejecutar
     * @return lista de usuarios obtenidos
     * @throws SQLException error controlado
     */
    private List<UsuarioEntitySqlite> obtenerUsuario(String sql, String... parametros) throws SQLException{
        List<UsuarioEntitySqlite> usuarios = new ArrayList<UsuarioEntitySqlite>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setString(i + 1, parametros[i]);
            }
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                int usuarioId = resultado.getInt("id");
                String usuarioStr = resultado.getString("user");
                String emailStr = resultado.getString("email");
                String nombreStr = resultado.getString("name");
                String contraseniaStr = resultado.getString("password");
                int puntosStr = resultado.getInt("puntos");
                int victoriasStr = resultado.getInt("victorias");
                int derrotasStr = resultado.getInt("derrotas");
                int idNivel = resultado.getInt("id_nivel");
                UsuarioEntitySqlite usuarioEntityModel = new UsuarioEntitySqlite(usuarioId, usuarioStr, 
                emailStr, nombreStr, contraseniaStr, puntosStr, victoriasStr, derrotasStr, idNivel);
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
        String sql = "INSERT INTO usuarios (user, email, name, password, id_nivel) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, usuario.getUser());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getName());
            sentencia.setString(4, usuario.getPassword());
            sentencia.setInt(5, usuario.getIdNivel());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }

    /**
     * Metodo para actualizar un usuario
     * @throws SQLException error controlado
     */
    public boolean actualizarUsuario(UsuarioEntitySqlite usuario) throws SQLException {
        String sql = "UPDATE usuarios SET user = ?, email = ?, name = ?, password = ? WHERE id = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, usuario.getUser());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getName());
            sentencia.setString(4, usuario.getPassword());
            sentencia.setInt(5, usuario.getId());
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }

    /**
     * Metodo para actualizar los puntos y victorias de un usuario
     * @throws SQLException error controlado
     */
    public boolean actualizarPuntosVictorias(int puntos, int victorias, String email) throws SQLException {
        String sql = "UPDATE usuarios SET puntos = ?, victorias = ? WHERE email = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setInt(1, puntos);
            sentencia.setInt(2, victorias);
            sentencia.setString(3, email);
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }
    
    /**
     * Metodo para actualizar los puntos y derrotas de un usuario
     * @throws SQLException error controlado
     */
    public boolean actualizarPuntosDerrotas(int puntos, int derrotas, String email) throws SQLException {
        String sql = "UPDATE usuarios SET puntos = ?, derrotas = ? WHERE email = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setInt(1, puntos);
            sentencia.setInt(2, derrotas);
            sentencia.setString(3, email);
            sentencia.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return false;
    }

    /**
     * Metodo para actualizar el nivel de un usuario
     * @throws SQLException error controlado
     */
    public boolean actualizarNivel(int nivel, String email) throws SQLException {
        String sql = "UPDATE usuarios SET id_nivel = ? WHERE email = ?";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setInt(1, nivel);
            sentencia.setString(2, email);
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