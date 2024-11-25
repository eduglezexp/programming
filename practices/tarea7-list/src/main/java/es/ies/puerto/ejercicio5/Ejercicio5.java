package es.ies.puerto.ejercicio5;

/**
 * 5. Clase Libro con Sobrecarga de Constructores
 * Define una clase Libro con atributos titulo, autor y paginas. Crea varios constructores para 
 * inicializar diferentes combinaciones de estos atributos. Implementa toString() para devolver 
 * una descripción del libro.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        Libro libro1 = new Libro();
        Libro libro2 = new Libro("El Quijote");
        Libro libro3 = new Libro("El principito", "Antoine de Saint-Exupéry");
        Libro libro4 = new Libro("Cien años de soledad", "Gabriel García Márquez",
         417);
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);
    }
}
