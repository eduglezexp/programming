package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(4, 1, 3, 2));
        System.out.println(ordenarLista(enteros));
    }

    /**
     * Metodo para ordenar una lista en orden ascendente
     * @param lista
     * @return lista ordenada
     */
    public static List<Integer> ordenarLista(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        Collections.sort(lista);
        return lista;
    }
}