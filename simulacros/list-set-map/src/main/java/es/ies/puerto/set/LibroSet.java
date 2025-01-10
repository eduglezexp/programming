package es.ies.puerto.set;

import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.Libro;

public class LibroSet {
    Set<Libro> libros;

    public LibroSet() {
        this.libros = new HashSet<>();
    }

    public boolean agregar(Libro libro) {
        if (!libros.contains(libro)) {
            return libros.add(libro);
        } 
        return false;
    }

    public Set<Libro> listar() {
        return new HashSet(libros);
    }

    public Libro buscar(String isbn) {
        return libros.stream().filter(p -> p.getIsbn().equals(isbn)).findFirst().orElse(null);       
    }

    public boolean actualizar(String isbn, Libro libro) {
        return false;
    }

    public boolean eliminar(String isbn) {
        return false;
    }

}
