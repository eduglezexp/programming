package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Integer> lista = inicializarLista(4);
        System.out.println("Lista original: " +lista);
        int k = 2; 
        System.out.println("Lista despues de rotar " +k+ " posiciones hacia la izquierda: " +rotarLista(lista, k));
    }

    /**
     * Metodo para inicializar una lista con numeros dada una cantidad
     * @param cantidad
     * @return una lista de numeros
     */
    public static List<Integer> inicializarLista(int cantidad) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            numeros.add(i);
        }
        return numeros;
    }

    /**
     * Rota la lista k posiciones hacia la izquierda
     * @param lista 
     * @param k 
     */
    public static List<Integer> rotarLista(List<Integer> lista, int k) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        if (k < 1) {
            return lista;
        } 
        List<Integer> parte1 = lista.subList(0, k);
        List<Integer> parte2 = lista.subList(k, lista.size()); 
        parte2.addAll(parte1);
        return parte2;
    }
}