package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int limite = 25;
        System.out.println(eliminarSi(enteros, limite));
    }

    /**
     * Metodo para eliminar los elementos de la lista si son mayores a un limite dado
     * @param lista
     * @param limite
     * @return lista con elementos menores al limite dado
     */
    public static List<Integer> eliminarSi(List<Integer> lista, int limite) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        lista.removeIf(numero -> numero > limite);
        return lista;
    }
}