package es.ies.puerto;

/**
 * Dado un texto sobre Wakanda, usa el método substring() para extraer solo 
 * la palabra "Wakanda" de la frase "El vibranium en Wakanda es sagrado".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        String frase = "El vibranium en Wakanda es sagrado";
        String substraer = frase.substring(16, 23);
        System.out.println(substraer);
    }
}