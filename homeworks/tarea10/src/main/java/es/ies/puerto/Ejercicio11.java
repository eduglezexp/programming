package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> listaDuplicada = copiarLista(lista);
        System.out.println(listaDuplicada);
    }

    /**
     * Metodo para copiar una lista 
     * @param lista
     * @return lista copiada
     */
    public static List<Integer> copiarLista(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        List<Integer> listaCopiada = new ArrayList<>(lista);
        return listaCopiada;
    }
}