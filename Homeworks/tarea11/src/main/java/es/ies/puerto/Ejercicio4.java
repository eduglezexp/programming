package es.ies.puerto;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(copiarElementosPares(vector));
    }
 
    public static Vector<Integer> copiarElementosPares(Vector<Integer> vector) {
        Vector<Integer> vectorCopiado = new Vector<>();
        for (Integer numero : vector) {
            if (numero % 2 == 0) {
                vectorCopiado.add(numero);
            }
        }
        return vectorCopiado;
    }
}