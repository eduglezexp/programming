package es.ies.puerto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(Arrays.asList(4, 2, 5, 1, 3));
        System.out.println(ordenarVector(vector));
    }

    /**
     * Metodo para ordenar un vector
     * @param vector
     * @return vector ordenado
     */
    public static Vector<Integer> ordenarVector(Vector<Integer> vector) {
        Collections.sort(vector);
        return vector;
    }
}