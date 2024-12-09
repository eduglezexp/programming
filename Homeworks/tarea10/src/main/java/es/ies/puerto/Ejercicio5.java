package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int valor = 2;
        System.out.println(contieneValor(enteros, valor));
        System.out.println(enteros);
    }

    /**
     * Metodo para comprobar si una lista contiene un valor dado
     * @param lista
     * @param valor
     * @return true/false
     */
    public static boolean contieneValor(List<Integer> lista, int valor) {
        if (lista == null || lista.isEmpty()) {
            return false;
        }
        return lista.contains(valor);
    }
}