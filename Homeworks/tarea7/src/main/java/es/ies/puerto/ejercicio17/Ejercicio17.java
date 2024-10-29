package es.ies.puerto.ejercicio17;

/**
 * 17. Clase Libro con Comparación de Páginas
 * Crea una clase Libro con atributos titulo, autor, y paginas. Sobrescribe equals() 
 * para comparar libros por su número de páginas y toString() para mostrar 
 * los detalles del libro.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El principito", 
        "Antoine de Saint-Exupéry", 417);
        Libro libro2 = new Libro("Cien años de soledad", 
        "Gabriel García Márquez", 417);
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println("El libro1 tiene las mismas paginas que el libro2? " 
        +libro1.equals(libro2));
    }
}
