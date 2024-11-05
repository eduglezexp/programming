package es.ies.puerto.ejercicio40;

/**
 * 40. Clase Biblioteca Digital con E-books
 * Crea una clase BibliotecaDigital que almacene una lista (array) de e-books 
 * (clase EBook (con las propiedades: nombre isbn, y anio)). Implementa métodos 
 * para agregar, eliminar y buscar libros, y usa toString() para mostrar los detalles 
 * de la biblioteca.
 * @author eduglezexp
 * @version 1.0.0
 */

public class BibliotecaDigital {
    private int numeroEBooks;
    private String nombre;
    private EBook[] eBooks;

    /**
     * Constructor por defecto
     */
    public BibliotecaDigital() {
    }

    /**
     * Constructor con las propiedad nombre
     * @param nombre
     */
    public BibliotecaDigital(String nombre) {
        this.nombre = nombre;
        this.numeroEBooks = 0;
        this.eBooks = new EBook[10];
    }
}