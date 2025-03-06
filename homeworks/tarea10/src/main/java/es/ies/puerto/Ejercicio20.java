package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(barajarLista(lista));
    }

    /**
     * Metodo para barajar una lista
     * @param lista
     * @return lista barajada
     */
    public static List<Integer> barajarLista(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista; 
        }
        Collections.shuffle(lista); 
        return lista;
    }
}