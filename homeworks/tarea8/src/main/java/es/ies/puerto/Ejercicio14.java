package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        List<String> nombres2 = new ArrayList<>(Arrays.asList("Bernarda", "Sara", 
        "Pedro", "Felipe", "Manolo"));
        nombres.addAll(nombres2);
        System.out.println(nombres);
    }
}