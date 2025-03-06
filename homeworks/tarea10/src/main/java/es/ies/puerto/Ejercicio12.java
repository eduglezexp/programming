package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int limite = 25;
        System.out.println(contarMayores(enteros, limite));
    }

    /**
     * Metodo para contar los elementos mayores a un limite dado en una lista
     * @param lista
     * @param limite
     * @return contador con los elementos mayores al limite dado
     */
    public static int contarMayores(List<Integer> lista, int limite) {
        int contador = 0; 
        for (int numero : lista) {
            if (numero > limite) {
                contador++; 
            }
        }
        return contador;
    }
}