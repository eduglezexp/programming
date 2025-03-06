package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int indice1 = 0;
        int indice2 = 2;
        System.out.println(intercambiar(enteros, indice1, indice2));
    }

    /**
     * Metodo para intercambiar los valores de posicion
     * @param lista
     * @param indice1
     * @param indice2
     * @return lista con los valores intercambiados
     */
    public static List<Integer> intercambiar(List<Integer> lista, int indice1, int indice2) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        if (indice1 < 0 || indice2 < 0) {
            return lista;
        } 
        int posicion1 = lista.get(indice1);
        int posicion2 = lista.get(indice2);
        lista.set(indice1, posicion2);
        lista.set(indice2, posicion1);
        return lista;
    }
}