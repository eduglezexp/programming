package es.ies.puerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        Collections.sort(nombres);
        System.out.println(nombres);
    }
}