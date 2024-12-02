package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Integer> numeros = llenarLista(20);
        System.out.println("Tamaño inicial de la lista: " + numeros.size());
        System.out.println("Lista inicial: " + numeros);
        eliminarMultiplosDeTres(numeros);
        System.out.println("Tamaño de la lista despues de eliminar multiplos de 3: " 
        +numeros.size());
        System.out.println("Lista despues de la operacion: " + numeros);
    }

    /**
     * Metodo para llenar una lista con numeros dada una cantidad
     * @return Lista con los numeros 
     */
    public static List<Integer> llenarLista(int cantidad) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            lista.add(i);
        }
        return lista;
    }

    /**
     * Metodo para eliminar de una lista todos los multiplos de 3
     * @param numeros Lista de numeros.
     */
    public static void eliminarMultiplosDeTres(List<Integer> numeros) {
        numeros.removeIf(num -> num % 3 == 0);
    }
}