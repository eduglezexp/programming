package es.ies.puerto;

/**
 * Dada una lista de personajes en una batalla (separados por comas), imprime cuántos 
 * personajes hay en la batalla usando split().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        String saiyajins = "Goku, Vegeta, Broly, Freezer";
        String[] personajes = saiyajins.split(", ");
        int contadorPersonaje = personajes.length;
        System.out.println(contadorPersonaje);
    }
}