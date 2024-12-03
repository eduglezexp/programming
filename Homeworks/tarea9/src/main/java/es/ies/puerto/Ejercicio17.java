package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        List<Integer> lista1 = inicializarLista(10);
        List<Integer> lista2 = inicializarLista(15);
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        List<Integer> numerosComunes = obtenerNumerosComunes(lista1, lista2);
        System.out.println("Números comunes: " + numerosComunes);
        List<Integer> numerosUnicos = obtenerNumerosUnicos(lista1, lista2);
        System.out.println("Números únicos: " + numerosUnicos);
    }

    /**
     * Metodo para inicializar una lista con numeros dada una cantidad
     * @param cantidad
     * @return una lista de numeros
     */
    public static ArrayList<Integer> inicializarLista(int cantidad) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            numeros.add(i);
        }
        return numeros;
    }

    /**
     * Metodo para obtener una lista con los numeros comunes entre dos listas
     * @param lista1 
     * @param lista2 
     * @return Una lista con los numeros comunes
     */
    public static List<Integer> obtenerNumerosComunes(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> comunes = new ArrayList<>(lista1);
        comunes.retainAll(lista2);
        return comunes;
    }

    /**
     * Metodo para obtener una lista con los numeros unicos de cada lista
     * @param lista1 
     * @param lista2 
     * @return Una lista con los numeros unicos
     */
    public static List<Integer> obtenerNumerosUnicos(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> unicos = new ArrayList<>(lista1);
        unicos.addAll(lista2); 
        List<Integer> comunes = obtenerNumerosComunes(lista1, lista2); 
        unicos.removeAll(comunes);
        return unicos;
    }
}