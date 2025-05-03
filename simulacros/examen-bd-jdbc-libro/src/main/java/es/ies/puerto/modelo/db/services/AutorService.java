package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Autor;
import es.ies.puerto.modelo.db.services.abstractas.AbstractService;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class AutorService extends AbstractService<Autor> {

    /**
     * Metodo para mapear las filas del autor
     * @param resultado que contiene el executeQuery()
     * @return un autor con sus propiedades
     */
    @Override
    protected Autor mapRow(ResultSet resultado) throws SQLException {
        String dni = resultado.getString("dni");
        String nombre = resultado.getString("nombre");
        String nacionalidad = resultado.getString("nacionalidad");
        Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
        return new Autor(dni, nombre, nacionalidad, fechaNacimiento);
    }

    /**
     * Metodo para crear un autor
     * @param autor a crear
     * @return true/false
     */
    public boolean crearAutor(Autor autor) {
        String sql = "INSERT INTO autores (dni, nombre, nacionalidad, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {        
            sentencia.setString(1, autor.getDni());
            sentencia.setString(2, autor.getNombre());
            sentencia.setString(3, autor.getNacionalidad());
            sentencia.setString(4, autor.getFechaNacimiento());
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
     * Metodo para obtener todos los usuarios
     * @return lista de autores
     */
    public List<Autor> obtenerTodosAutores() {
        String sql = "SELECT * FROM autores";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener un autor dado su id
     * @param dni del autor a buscar
     * @return autor solicitado
     */
    public Autor obtenerAutorPorDni(String dni) {
        String sql = "SELECT * FROM autores WHERE dni = ?";
        List<Autor> autores = executeQuery(sql, dni);
        if (autores.isEmpty()) {
            return null;
        }
        return autores.iterator().next();
    }

    /**
     * Metodo para actualizar a un autor 
     * @param autor a actualizar
     * @return true/false
     */
    public boolean actualizarAutor(Autor autor) {
        String sql = "UPDATE autores SET nombre = ?, nacionalidad = ?, fecha_nacimiento = ? WHERE dni = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, autor.getNombre());
            sentencia.setString(2, autor.getNacionalidad());
            sentencia.setString(4, autor.getFechaNacimiento());
            sentencia.setString(4, autor.getDni());
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
     * Metodo para eliminar a un autor
     * @param dni del autor a eliminar
     * @return true/false
     */
    public boolean eliminarAutor(String dni) {
        String sql = "DELETE FROM autores WHERE dni = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, dni);
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
