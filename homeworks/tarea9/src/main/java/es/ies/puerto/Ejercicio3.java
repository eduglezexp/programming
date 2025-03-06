package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> numeros = generarNumeros();
        System.out.println(numeros);
        eliminarMayores(numeros);
        System.out.println(numeros);
        boolean contienePares = contieneNumerosPares(numeros);
        if (contienePares) {
            System.out.println("La lista contiene numeros pares.");
        } else {
            System.out.println("La lista no contiene numeros pares.");
        }
    }

    /**
     * Metodo para generar numeros de forma aleatoria en una lista
     * @return lista de numeros aleatorios
     */
    public static List<Integer> generarNumeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int numeroRandom = (int)(Math.random() * 101);
            numeros.add(numeroRandom);
        }
        return numeros;
    }

    /**
     * Metodo para eliminar de la lista todos los números mayores a 50.
     * @param numeros 
     */
    public static void eliminarMayores(List<Integer> numeros) {
        numeros.removeIf(numero -> numero > 50);
    }

    /**
     * Metodo para verificar si la lista contiene numeros pares.
     * @param numeros 
     * @return true/false
     */
    public static boolean contieneNumerosPares(List<Integer> numeros) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}