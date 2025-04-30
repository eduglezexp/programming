package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.modelo.abstractas.Conexion;
import es.ies.puerto.modelo.db.entidades.Autor;

/**
 * Servicio para operaciones CRUD de Autor
 * Corrige uso de conexión y mapeo de fechas para que los datos de prueba se carguen correctamente.
 */
public class AutorService extends Conexion {

    /**
     * Metodo para ejecutar una query de autor
     * @param sql a ejectar
     * @param params a añadir
     * @return lista de autores
     * @throws SQLException error controlado
     */
    public List<Autor> executeQuery(String sql, String... params) {
        List<Autor> autores = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                sentencia.setString(i + 1, params[i]);
            }
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    String dni = resultado.getString("dni");
                    String nombre = resultado.getString("nombre");
                    String nacionalidad = resultado.getString("nacionalidad");
                    Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                    Autor autor = new Autor(dni, nombre, nacionalidad, fechaNacimiento);
                    autores.add(autor);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return autores;
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
        }
    }

    /**
     * Metodo para obtener todos los usuarios
     * @return lista de autores
     */
    public List<Autor> obtenerTodosAutores() {
        String sql = "SELECT dni, nombre, nacionalidad, fecha_nacimiento FROM autores";
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
            if (sentencia.executeUpdate() == 1) {
                return true;
            }
            return false;
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
