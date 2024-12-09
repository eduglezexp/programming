package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println(crearListaConsecutiva(-1, 5));
    }

    /**
     * Metodo para crear una lista consecutiva de numeros enteros
     * @param inicio
     * @param cantidad
     * @return lista
     */
    public static List<Integer> crearListaConsecutiva(int inicio, int cantidad) {
        List<Integer> lista = new ArrayList<>();
        for (int i = inicio; i < (cantidad+inicio); i++) {
            lista.add(i);
        }
        return lista;
    }
}