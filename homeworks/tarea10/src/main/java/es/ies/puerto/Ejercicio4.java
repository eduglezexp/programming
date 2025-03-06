package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 5, 2));
        int valor = 2;
        System.out.println(eliminarElemento(valores, valor));
        System.out.println(valores);
    }

    /**
     * Metodo para eliminar un elemento de la lista dado un valor
     * @param lista
     * @param valor
     * @return true/false
     */
    public static boolean eliminarElemento(List<Integer> lista, int valor) {
        if (lista == null || lista.isEmpty()) {
            return false;
        }
        return lista.remove((Integer) valor);
    }
}