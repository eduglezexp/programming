package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println(Arrays.toString(obtenerExtremos(enteros)));
    }

    /**
     * Metodo para obtener el minimo y el maximo de una lista
     * @param lista
     * @return lista con el elemento minimo y maximo
     */
    public static int[] obtenerExtremos(List<Integer> lista) {
        int[] minimoMaximo = new int[2];
        if (lista == null || lista.isEmpty()) {
            return minimoMaximo;
        }
        Collections.sort(lista);
        int minimo = lista.get(0);
        int maximo = lista.get(lista.size()-1);
        minimoMaximo[0] = minimo;
        minimoMaximo[1] = maximo;
        return minimoMaximo;
    }
}