package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(duplicarElementos(enteros));
    }

    /**
     * Metodo para duplicar elementos de una lista
     * @param lista
     * @return lista con los elementos duplicados
     */
    public static List<Integer> duplicarElementos(List<Integer> lista) {
        if (lista == null || lista.isEmpty()) {
            return lista;
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, lista.get(i)*2);
        }
        return lista;
    }
}