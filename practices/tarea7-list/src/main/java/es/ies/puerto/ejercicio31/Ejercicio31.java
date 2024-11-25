package es.ies.puerto.ejercicio31;

/**
 * 31. Clase Película con Atributos y Métodos
 * Crea una clase Pelicula con atributos titulo, director, y duracion. 
 * Implementa métodos para comparar películas por duración con equals() 
 * y usar toString() para mostrar detalles.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio31 {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Inception", "Christopher Nolan", 148);
        Pelicula pelicula2 = new Pelicula("Interstellar", "Christopher Nolan", 169);
        Pelicula pelicula3 = new Pelicula("El Origen", "Christopher Nolan", 148);
        System.out.println(pelicula1);
        System.out.println(pelicula2);
        System.out.println(pelicula3);
        System.out.println("¿La duracion de 'Inception' es igual a 'El Origen'? " + pelicula1.equals(pelicula3));
        System.out.println("¿La duracion de 'Inception' es igual a 'Interstellar'? " + pelicula1.equals(pelicula2));
    }
}
