package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Vector<String> frutas = crearVectorFrutas();
        System.out.println(frutas);
    }

    /**
     * Metodo para crear un vector con frutas
     * @return vector con frutas
     */
    public static Vector<String> crearVectorFrutas() {
        Vector<String> frutas = new Vector<>();
        frutas = new Vector<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Cereza");
        frutas.add("Mango");
        frutas.add("Uva");
        return frutas;
    }
}