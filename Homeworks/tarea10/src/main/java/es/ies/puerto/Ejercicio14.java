package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
        System.out.println(encontrarDuplicados(enteros));
    }

    /**
     * Metodo para encontrar duplicados en una lista
     * @param lista
     * @return lista con los elementos que aparecen mas de una vez
     */
    public static List<Integer> encontrarDuplicados(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        List<Integer> elementosVistos = new ArrayList<>();  
        List<Integer> elementosDuplicados = new ArrayList<>();  
        for (int numero : lista) {
            if (elementosVistos.contains(numero) && !elementosDuplicados.contains(numero)) {
                elementosDuplicados.add(numero);
            } else {
                elementosVistos.add(numero);
            }
        }
        return elementosDuplicados;  
    }
}