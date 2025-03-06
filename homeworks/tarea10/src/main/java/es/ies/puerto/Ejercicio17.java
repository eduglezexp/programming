package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
        System.out.println(eliminarDuplicados(enteros));
    }

    /**
     * Metodo para elimar duplicados de una lista
     * @param lista
     * @return lista sin duplicados
     */
    public static List<Integer> eliminarDuplicados(List<Integer> lista) {
        List<Integer> resultado = new ArrayList<>(); 
        for (int numero : lista) {
            if (!resultado.contains(numero)) {
                resultado.add(numero);
            }
        }
        return resultado;
    }
}