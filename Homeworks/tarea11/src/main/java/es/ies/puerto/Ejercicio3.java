package es.ies.puerto;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList("Azul", "Amarillo",
        "Verde", "Anaranjado"));
        String valor = "A";
        System.out.println(eliminarPorCondicion(vector, valor));
    }

    public static Vector<String> eliminarPorCondicion(Vector<String> vector, String valor) {
        vector.removeIf(color -> color.startsWith(valor));
        return vector;
    }
}