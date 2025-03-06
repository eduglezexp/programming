package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> subLista = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println(esSublista(lista, subLista));
    }

    /**
     * Metodo para buscar un sublista dentro de una lista
     * @param lista
     * @param sublista
     * @return true/false
     */
    public static boolean esSublista(List<Integer> lista, List<Integer> sublista) {
        if (sublista == null || sublista.isEmpty()) {
            return true; 
        }
        if (lista == null || lista.size() < sublista.size()) {
            return false; 
        }
        for (int i = 0; i <= lista.size() - sublista.size(); i++) {
            boolean coincide = true;
            for (int j = 0; j < sublista.size(); j++) {
                if (!lista.get(i + j).equals(sublista.get(j))) {
                    coincide = false;
                    break;
                }
            }
            if (coincide) {
                return true; 
            }
        }
        return false;
    }
}