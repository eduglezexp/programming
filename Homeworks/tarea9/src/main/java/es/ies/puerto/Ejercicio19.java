package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Integer> lista = inicializarLista();
        System.out.println("Lista original: " + lista);
        int k = 3; 
        rotarLista(lista, k);
        System.out.println("Lista después de rotar " + k + " posiciones hacia la izquierda: " + lista);
    }

    /**
     * Inicializa la lista con números del 1 al 10
     * @return La lista de números.
     */
    public static List<Integer> inicializarLista() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(i); 
        }
        return lista;
    }

    /**
     * Rota la lista k posiciones hacia la izquierda
     * @param lista 
     * @param k 
     */
    public static void rotarLista(List<Integer> lista, int k) {
        int size = lista.size();
        if (size == 0) return;
        k = k % size;
        if (k == 0) return; 
        List<Integer> parte1 = lista.subList(0, k);
        List<Integer> parte2 = lista.subList(k, size); 
        lista.clear();
        lista.addAll(parte2); 
        lista.addAll(parte1); 
    }
}