package es.ies.puerto.set;

import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.Libro;

public class LibroSet {
    Set<Libro> libros;

    /**
     * Constructor por defecto
     */
    public LibroSet() {
        this.libros = new HashSet<>();
    }

    /**
     * Funcion para agregar a un libro a la lista
     * @param libro
     * @return true/false
     */
    public boolean agregar(Libro libro) {
        if (!libros.contains(libro)) {
            return libros.add(libro);
        } 
        return false;
    }

    /**
     * Funcion para listar los libros
     * @return hashSet con la lista de libros
     */
    public Set<Libro> listar() {
        return new HashSet(libros);
    }

    /**
     * Funcion para buscar un libro
     * @param isbn
     * @return libro buscado
     */
    public Libro buscar(String isbn) {
        return libros.stream().filter(p -> p.getIsbn().equals(isbn)).findFirst().orElse(null);       
    }

    /**
     * Funcion para actualizar un libro
     * @param isbn
     * @param nuevoLibro
     * @return true/false
     */
    public boolean actualizar(String isbn, Libro nuevoLibro) {
        Libro libroBuscar = new Libro(isbn);
        for (Libro libro : libros) {
            if (libro.equals(libroBuscar)) {
                libro = nuevoLibro;
                return true; 
            }
        }
        return false;
    }

    /**
     * Funcion para eliminar un libro
     * @param isbn
     * @return true/false
     */
    public boolean eliminar(String isbn) {
        Libro libroBuscar = new Libro(isbn);
        return libros.remove(libroBuscar);
    }
}