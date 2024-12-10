package es.ies.puerto;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList("Ana", "Francisco", 
        "María", "Alejandro"));
        System.out.println(contarNombresLargos(vector));
    }

    public static int contarNombresLargos(Vector<String> vector) {
        int contador = 0;
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).length() > 5) {
                contador++;
            }
        }
        return contador;
    }
}