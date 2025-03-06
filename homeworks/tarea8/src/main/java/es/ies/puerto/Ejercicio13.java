package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Edu");
        nombres.add("Alberto");
        nombres.add("Ana");
        nombres.removeIf(nombre -> nombre.length() > 5);
        System.out.println(nombres);
    }
}