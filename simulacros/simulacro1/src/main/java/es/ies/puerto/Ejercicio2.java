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
        int[] numeros2 = {1, 2, 2, 3, 3, 3, 4};
        System.out.println(contarNumerosRepetidos(numeros2));
        int[] numeros3 = {7, 8, 9, 7, 8, 9, 7, 9};
        System.out.println(contarNumerosRepetidos(numeros3));
    }

    public static String contarNumerosRepetidos(int[] numeros) {
        boolean[] contado = new boolean[numeros.length];
        String resultado = "";
        for (int i = 0; i < numeros.length; i++) {
            if (!contado[i]) {
                int contador = 1;
                for (int j = i + 1; j < numeros.length; j++) {
                    if (numeros[i] == numeros[j]) {
                        contador++;
                        contado[j] = true;
                    }
                } 
                resultado += numeros[i]+ " aparece " +contador+ " veces\n";   
            }
        }
        return resultado;
    }
}