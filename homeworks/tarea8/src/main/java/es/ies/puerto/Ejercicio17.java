package es.ies.puerto;

import java.util.ArrayList;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        nombres.replaceAll(nombre -> "Sin nombre");
        System.out.println(nombres);
    }
}