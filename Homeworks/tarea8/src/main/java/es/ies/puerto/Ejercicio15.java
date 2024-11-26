package es.ies.puerto;

import java.util.ArrayList;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        ArrayList nombres2 = (ArrayList) nombres.clone();
        System.out.println(nombres2);
    }
}