package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Libro;

/**
 * Crea un objeto de la clase Libro con título "El Quijote", autor "Cervantes", y 500 páginas. 
 * Asegúrate de que el número de páginas sea positivo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio12 {
    static Libro libro;
    public static void main(String[] args) {
        libro = new Libro("El Quijote", "Cervantes", 500);
        System.out.println(libro);
    }
}
