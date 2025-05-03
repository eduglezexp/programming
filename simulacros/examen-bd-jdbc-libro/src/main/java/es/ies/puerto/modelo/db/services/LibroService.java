package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Libro;
import es.ies.puerto.modelo.db.services.abstractas.AbstractService;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class LibroService extends AbstractService<Libro> {

    /**
     * Metodo para mapear las filas del libro
     * @param resultado que contiene el executeQuery()
     * @return un libro con sus propiedades
     */
    @Override
    protected Libro mapRow(ResultSet resultado) throws SQLException {
        String idLibro = resultado.getString("id_libro");
        String titulo = resultado.getString("titulo");
        String autorDni = resultado.getString("autor_dni");
        Date fechaPublicacion = resultado.getDate("fecha_publicacion");
        String genero = resultado.getString("genero");
        return new Libro(idLibro, titulo, autorDni, fechaPublicacion, genero);
    }

    /**
     * Metodo para crear un libro
     * @param libro a crear
     * @return true/false
     */
    public boolean crearLibro(Libro libro) {
        String sql = "INSERT INTO libros (id_libro, titulo, autor_dni, fecha_publicacion, genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); 
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, libro.getIdLibro());
            sentencia.setString(2, libro.getTitulo());
            sentencia.setString(3, libro.getAutorDni());
            sentencia.setString(4, libro.getFechaPublicacion());
            sentencia.setString(5, libro.getGenero());
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
     * Metodo para obtener todos los libros
     * @return lista de libros
     */
    public List<Libro> obtenerTodosLibros() {
        String sql = "SELECT * FROM libros";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener un libro dado su id
     * @param idLibro del libro a buscar
     * @return libro solicitado
     */
    public Libro obtenerLibroPorId(String idLibro) {
        String sql = "SELECT * FROM libros WHERE id_libro = ?";
        List<Libro> libros = executeQuery(sql, idLibro);
        if (libros.isEmpty()) {
            return null;
        }
        return libros.iterator().next();
    }

    /**
     * Metodo para actualizar a un libro
     * @param libro a actualizar
     * @return true/false
     */
    public boolean actualizarLibro(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autor_dni = ?, fecha_publicacion = ?, genero = ? WHERE id_libro = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, libro.getTitulo());
            sentencia.setString(2, libro.getAutorDni());
            sentencia.setString(3, libro.getFechaPublicacion());
            sentencia.setString(4, libro.getGenero());
            sentencia.setString(5, libro.getIdLibro());
            sentencia.executeUpdate();
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
     * Metodo para eliminar a un libro
     * @param idLibro del libro a eliminar
     * @return true/false
     */
    public boolean eliminarLibro(String idLibro) {
        String sql = "DELETE FROM libros WHERE id_libro = ?";
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, idLibro);
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
