package es.ies.puerto;

import java.util.ArrayList;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio21 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        System.out.println(nombres);
        nombres.clear();
        System.out.println(nombres);
    }
}