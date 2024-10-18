package es.ies.puerto;

/**
 * Reto 3: Clasificación de edad avanzada
 * Modifica el ejercicio de clasificación de edad para incluir una nueva categoría. 
 * Si el usuario tiene más de 65 años, imprime "Eres un adulto mayor".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto3 {
    public static void main(String[] args) {
        int edad = 65;
        System.out.println(clasificarEdad(edad));
    }

    public static String clasificarEdad(int edad) {
        if (edad < 65) {
            return "Eres un aldulto o un niño";
        }
        return "Eres un adulto mayor";
    }
}
