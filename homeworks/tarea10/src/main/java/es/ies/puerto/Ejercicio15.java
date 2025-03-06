package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int posiciones = 1;
        System.out.println(rotarLista(enteros, posiciones));
    }

    /**
     * Metodo para rotar la lista un determinado numero de veces
     * @param lista
     * @param posiciones
     * @return lista despues de ser rotada
     */
    public static List<Integer> rotarLista(List<Integer> lista, int posiciones) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        if (posiciones < 1) {
            return lista;
        } 
        List<Integer> parte1 = lista.subList(lista.size() - posiciones, lista.size());
        List<Integer> parte2 = lista.subList(0, lista.size() - posiciones); 
        parte1.addAll(parte2);
        return parte1;
    }
}