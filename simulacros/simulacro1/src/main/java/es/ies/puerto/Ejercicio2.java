package es.ies.puerto;

/**
 * Escribe un programa que reciba un array de números enteros y cuente cuántas veces 
 * aparece cada número.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(contarNumerosRepetidos(numeros));
    }

    public static String contarNumerosRepetidos(int[] numeros) {
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    contador++;
                    return numeros[i]+ " aparece " +contador+ " veces";
                }
            }
        }
        return "";
    }
}