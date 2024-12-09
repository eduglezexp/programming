package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        System.out.println(interseccionListas(lista1, lista2));
    }

    /**
     * Metodo para obtener los numeros comunes en ambas listas
     * @param lista1
     * @param lista2
     * @return lista con los numeros comunes
     */
    public static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
        if (lista1 == null || lista1.isEmpty()) {
            return lista1;
        }
        if (lista2 == null || lista2.isEmpty()) {
            return lista2;
        }
        List<Integer> resultado = new ArrayList<>(); 
        for (int elemento : lista1) {
            if (lista2.contains(elemento) && !resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }
}