package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        List<String> lista1 = inicializarLista1();
        List<String> lista2 = inicializarLista2();
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        List<String> listaModificada = obtenerDiferencia(lista1, lista2);
        System.out.println("Lista modificada: " +listaModificada);
    }

    /**
     * Metodo para inicializar la primera lista con nombres
     * @return Una lista de nombres
     */
    public static List<String> inicializarLista1() {
        List<String> lista = new ArrayList<>();
        lista.add("Ana");
        lista.add("Juan");
        lista.add("Pedro");
        lista.add("Lucía");
        lista.add("María");
        return lista;
    }

    /**
     * Metodo para inicializar la segunda lista con nombres
     * @return Una lista de nombres
     */
    public static List<String> inicializarLista2() {
        List<String> lista = new ArrayList<>();
        lista.add("Pedro");
        lista.add("Lucía");
        lista.add("Carlos");
        lista.add("Ana");
        return lista;
    }

    /**
     * Obtiene una lista con los nombres de la primera lista que no estan en la segunda lista
     * @param lista1 
     * @param lista2
     * @return Una lista con los nombres de la primera lista que no están en la segunda
     */
    public static List<String> obtenerDiferencia(List<String> lista1, List<String> lista2) {
        List<String> listaModificada = new ArrayList<>(lista1);
        listaModificada.removeAll(lista2);
        return listaModificada;
    }
}