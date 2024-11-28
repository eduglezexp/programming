package es.ies.puerto;

import java.util.ArrayList;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio24 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> nombres2 = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        nombres2.add("Pedro");
        nombres2.add("Adriana");
        nombres2.add("Eduardo");
        nombres2.add("Alberto");
        nombres2.add("Mayra");
        nombres.retainAll(nombres2);
        System.out.println(nombres);
    }
}