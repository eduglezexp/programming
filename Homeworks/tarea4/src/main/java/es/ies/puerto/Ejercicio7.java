package es.ies.puerto;

/**
 * Crea un array de enteros que represente la durabilidad de las partes de la armadura 
 * de Iron Man. Si un valor es menor a 50, imprímelo con el mensaje "¡Necesita reparación!". 
 * Luego, mejora todos los valores en un 10%.
 * @author eduglezexp
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] durabilidades = {12, 50, 45, 78, 80};
        for (int i = 0; i < durabilidades.length; i++) {
            if (durabilidades[i] < 50) {
                System.out.println("¡Necesita reparación!");
            }
            durabilidades[i] = (int) (durabilidades[i] * 1.1);
        }
        for (int durabilidad : durabilidades) {
            System.out.println(durabilidad);
        }
    }
}
