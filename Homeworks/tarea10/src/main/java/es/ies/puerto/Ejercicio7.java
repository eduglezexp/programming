package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        String valor = "Java";
        System.out.println(indiceDe(lista, valor));
    }

    /**
     * Metodo para encontrar el indice de la primera aparicion de un valor dado
     * @param lista
     * @param valor
     * @return la primera aparicion del indice del valor dado
     */
    public static int indiceDe(List<String> lista, String valor) {
        return lista.indexOf(valor);
    }
}