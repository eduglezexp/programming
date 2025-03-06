package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 * posible examen
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        List<String> lista1 = new ArrayList<>(Arrays.asList("Ana", "Juan", "Pedro", "Lucía", "María"));
        List<String> lista2 = new ArrayList<>(Arrays.asList("Pedro", "Lucía", "Carlos", "Ana"));
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        List<String> listaModificada = obtenerDiferencia(lista1, lista2);
        System.out.println("Lista modificada: " +listaModificada);
    }

    /**
     * Metodo que obtiene una lista con los nombres de la primera lista que no estan en la segunda lista
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