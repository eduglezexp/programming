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

public class Ejercicio40 {
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital("Biblioteca1");
        EBook libro1 = new EBook("Libro1", "12345", 2020);
        EBook libro2 = new EBook("Libro2", "67890", 2019);
        EBook libro3 = new EBook("Libro3", "11223", 2021);
        EBook libro4 = new EBook("Libro4", "33445", 2018);
        biblioteca.addEBook(libro1);
        biblioteca.addEBook(libro2);
        biblioteca.addEBook(libro3);
        biblioteca.addEBook(libro4);
        System.out.println("Contenido de la biblioteca:");
        System.out.println(biblioteca);
        String nombreBusqueda = "Libro2";
        System.out.println("\nLibro a buscar: " +nombreBusqueda);
        System.out.println(biblioteca.buscarEbook(nombreBusqueda));
        biblioteca.deleteEbook(libro2);
        System.out.println("\nContenido de la biblioteca después de eliminar un libro:");
        System.out.println(biblioteca);
    }
}