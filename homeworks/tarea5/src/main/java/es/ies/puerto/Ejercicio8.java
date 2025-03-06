package es.ies.puerto;

/**
 * Escribe un programa que reciba una entrada del usuario y convierta la primera letra 
 * de cada palabra en mayúscula (como si fuera el diario del Capitán Kirk).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        String frase = "en un universo alterno";
        String[] palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            palabras[i] = palabras[i].substring(0, 1).toUpperCase() 
            + palabras[i].substring(1).toLowerCase();
            System.out.print(palabras[i]+ " ");
        }
    }
}