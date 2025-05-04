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

    /**
     * Metodo para obtener los libros publicados despues de un anio dado
     * @param anio anio a partir del cual se buscan libros
     * @return lista de libros publicados despues de ese anio
     */
    public List<Libro> obtenerLibrosPublicadosDespuesDe(int anio) {
        String sql = "SELECT * FROM libros WHERE fecha_publicacion > '" + anio + "-12-31'";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los autores de los libros
     * @return lista de los autores y sus propiedades
     */
    public List<Libro> obtenerLibrosAutores() {
        String sql = "SELECT l.*, a.nombre AS autor, a.nacionalidad, a.fecha_nacimiento " + 
                     "FROM libros l JOIN autores a ON l.autor_dni = a.dni";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener la cantidad de libros por genero
     * @return lista con la cantidad de libros por genero
     */
    public List<Libro> obtenerLibrosPorGeneros() {
        String sql = "SELECT genero, COUNT(*) AS total_libros FROM libros GROUP BY genero";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los libros nunca prestados
     * @return libros nunca prestados
     */
    public List<Libro> obtenerLibrosNuncaPrestados() {
        String sql = "SELECT l.* " + 
                     "FROM libros l " + 
                     "LEFT JOIN prestamos p " + 
                     "ON l.id_libro = p.libro_id " + 
                     "WHERE p.libro_id IS NULL";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los libros publicados antes de un anio y genero dado
     * @param genero del libro
     * @param anio anio a partir del cual se buscan libros
     * @return lista de libros publicados despues de ese anio
     */
    public List<Libro> obtenerLibrosPublicadosAntesDe(String genero, String anio) {
        String sql = "SELECT * FROM libros WHERE genero = '" + genero + "' " +
                     "AND fecha_publicacion > '" + anio + "-01-01'";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener libros con su autor y nacionalidad
     * @return lista de libros 
     */
    public List<Libro> obtenerLibrosConAutorYNacionalidad() {
        String sql = "SELECT l.titulo, a.nombre AS autor, a.nacionalidad " +
                     "FROM libros l  JOIN autores a ON l.autor_dni = a.dni";
        return executeQuery(sql);
    }

    /**
     * Metodo que obtiene la cantidad de prestamos por libro
     * @return lista de libros
     */
    public List<Libro> obtenerLibrosCantidadPrestamos() {
        String sql = "SELECT l.id_libro, l.titulo, COUNT(p.id_prestamo) AS total_prestamos " +
                     "FROM libros l LEFT JOIN prestamos p ON l.id_libro = p.libro_id " +
                     "GROUP BY l.id_libro, l.titulo";
        return executeQuery(sql);
    }

    /**
     * Metodo para obtener los autores y libros ordenados por publicacion 
     * @return lista de libros
     */
    public List<Libro> obtenerActoresYLibrosOrdenadosPorPublicacion() {
        String sql = "SELECT a.nombre AS autor, l.titulo, l.fecha_publicacion " +
                     "FROM autores a JOIN libros l ON a.dni = l.autor_dni " +
                     "ORDER BY l.fecha_publicacion DESC";
        return executeQuery(sql);
    }

    public List<Libro> obtenerLibrosMasPrestados() {
        String sql = "SELECT l.id_libro, l.titulo, " + 
                     "COUNT(p.id_prestamo) AS total_prestamos " + 
                     "FROM libros l LEFT JOIN prestamos p " + 
                     "ON l.id_libro = p.libro_id " + 
                     "GROUP BY l.id_libro, l.titulo " + 
                     "ORDER BY total_prestamos DESC LIMIT 1";
        return executeQuery(sql);
    }
}
