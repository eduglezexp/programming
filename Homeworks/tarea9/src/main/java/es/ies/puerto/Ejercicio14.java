package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        List<Integer> numeros = inicializarLista(20);
        System.out.println("Lista original: " + numeros);
        reemplazarConCero(numeros, 5, 10);
        System.out.println("Lista modificada: " + numeros);
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
     * Metodo para reemplazar con 0 los numeros que no estan en una sublista especifica
     * @param numeros 
     * @param inicio 
     * @param fin   
     */
    public static void reemplazarConCero(List<Integer> numeros, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            if (numeros.get(i) % 3 != 0) {
                numeros.set(i, 0);
            }
        }
    }
}