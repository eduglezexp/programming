package es.ies.puerto;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList("España", "Alemania", 
        "Francia", "Inglaterra", "Suecia"));
        String pais = "España";
        System.out.println(verificarPresenciaElemento(vector, pais));
    }

    public static boolean verificarPresenciaElemento(Vector<String> vector, String pais) {
        return vector.contains(pais);
    }
}