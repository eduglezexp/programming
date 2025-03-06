package es.ies.puerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        Collections.reverse(nombres);
        System.out.println(nombres);
    }
}