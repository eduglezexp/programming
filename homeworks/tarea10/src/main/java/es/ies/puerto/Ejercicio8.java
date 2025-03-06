package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(invertirLista(enteros));
    }

    /**
     * Metodo para invertir los elementos de una lista 
     * @param lista
     * @return lista ordenada
     */
    public static List<Integer> invertirLista(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        Collections.reverse(lista);;
        return lista;
    }
}