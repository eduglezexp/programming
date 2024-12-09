package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(sumarElementos(enteros));
    }

    /**
     * Metodo para sumar los elementos de una lista
     * @param lista
     * @return la suma de los elementos
     */
    public static int sumarElementos(List<Integer> lista) {
        int suma = 0;
        for (int numero : lista) {
            suma += numero;  
        }
        return suma;
    }
}