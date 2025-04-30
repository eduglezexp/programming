package es.ies.puerto.modelo.db.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.modelo.abstractas.Conexion;
import es.ies.puerto.modelo.db.entidades.Libro;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class LibroService extends Conexion{

    /**
     * Metodo que ejecuta una consulta SQL para obtener libros
     * @param sql consulta SQL a ejecutar
     * @return lista de libros obtenidos
     * @throws SQLException error controlado
     */
    private List<Libro> executeQuerry(String sql, String... parametros){
        List<Libro> libros = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement sentencia = connection.prepareStatement(sql); 
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setString(i + 1, parametros[i]);
            }
            ResultSet resultado = sentencia.executeQuery();
                while(resultado.next()) {
                    String idLibro = resultado.getString("id_libro");
                    String titulo = resultado.getString("titulo");
                    String autorDni = resultado.getString("autor_dni");
                    Date fechaPublicacion = resultado.getDate("fecha_publicacion");
                    String genero = resultado.getString("genero");
                    Libro libro = new Libro(idLibro, titulo, autorDni, fechaPublicacion, genero);
                    libros.add(libro);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return libros;
    }

    /**
     * Metodo para crear un libro
     * @param libro a crear
     */
    public boolean crearLibro(Libro libro) {
        String sql = "INSERT INTO libros (id_libro, titulo, autor_dni, fecha_publicacion, genero) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, libro.getIdLibro());
            sentencia.setString(2, libro.getTitulo());
            sentencia.setString(3, libro.getAutorDni());
            sentencia.setDate(4, null);
            sentencia.setString(5, libro.getGenero());
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

    public List<Libro> obtenerTodosLibros() {
        String sql = "SELECT * FROM libros";
        return executeQuerry(sql);
    }

    public Libro obtenerLibroPorId(String idLibro) {
        
        return null;
    }

    public boolean actualizarLibro(Libro libro) {
        return false;
    }

    public boolean eliminarLibro(String idLibro) {
        return false;
    }
}
