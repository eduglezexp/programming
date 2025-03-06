package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        List<Integer> numeros = llenarLista(30);
        System.out.println(numeros);
        List<List<Integer>> sublistas = dividirEnSublistas(numeros, 5);
        System.out.println("Sublistas:");
        for (List<Integer> sublista : sublistas) {
            System.out.println(sublista);
        }
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
     * Divide una lista en sublistas de longitud fija
     * @param lista 
     * @param tamanio 
     * @return Una lista de sublistas
     */
    public static List<List<Integer>> dividirEnSublistas(List<Integer> lista, int tamanio) {
        List<List<Integer>> sublistas = new ArrayList<>();
        for (int i = 0; i < lista.size(); i += tamanio) {
            sublistas.add(lista.subList(i, Math.min(i + tamanio, lista.size())));

        }
        return sublistas;
    }
}