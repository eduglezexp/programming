package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList("Hola", "Mundo", "Java"));
        int indice = 2;
        System.out.println(obtenerElemento(lista, indice));
    }

    /**
     * Metodo para obtener un elemento en una lista dado su indice
     * @param lista
     * @param indice
     * @return elemento de la lista 
     */
    public static String obtenerElemento(List<String> lista, int indice) {
        String vacio = "";
        if (lista == null || lista.isEmpty()) {
            return vacio;
        }
        if (indice < 0 || indice >= lista.size()) {
            return vacio;
        }
        return lista.get(indice);
    }
}