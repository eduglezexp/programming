package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        System.out.println(llenarLista(30));

    }

    /**
     * Metodo para llenar una lista con numeros dada una cantidad
     * @return Lista con los numeros 
     */
    public static List<Integer> llenarLista(int cantidad) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            lista.add(i);
            lista.subList(i, i);
        }
        return lista;
    }
}