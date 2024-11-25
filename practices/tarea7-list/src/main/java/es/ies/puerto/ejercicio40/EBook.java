package es.ies.puerto.ejercicio40;

import java.util.Objects;

/**
 * 40. Clase Biblioteca Digital con E-books
 * Crea una clase BibliotecaDigital que almacene una lista (array) de e-books 
 * (clase EBook (con las propiedades: nombre isbn, y anio)). Implementa métodos 
 * para agregar, eliminar y buscar libros, y usa toString() para mostrar los detalles 
 * de la biblioteca.
 * @author eduglezexp
 * @version 1.0.0
 */

public class EBook {
    private String nombre;
    private String isbn;
    private int anio;

    /**
     * Constructor por defecto
     */
    public EBook() {

    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param isbn
     * @param anio
     */
    public EBook(String nombre, String isbn, int anio) {
        this.nombre = nombre;
        this.isbn = isbn;
        this.anio = anio;
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EBook)) {
            return false;
        }
        EBook eBook = (EBook) o;
        return Objects.equals(isbn, eBook.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "\nEBook [nombre=" + nombre + ", isbn=" + isbn + ", anio=" + anio + "]";
    }
}