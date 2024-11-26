package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Samuel");
        nombres.add("Daniel");
        nombres.add("Eduardo");
        nombres.add("Alberto");
        nombres.add("Antonio");
        System.out.println("¿Contiene la lista el nombre de Ana?: " 
        +nombres.contains("Ana"));
    }
}