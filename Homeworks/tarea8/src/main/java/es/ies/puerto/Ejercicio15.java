package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

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
        List<String> nombres2 = clonar(nombres);
        System.out.println(nombres2);
    }

    /**
     * Funcion que clona una lista a otra
     * @param list
     * @return lista clonada o vacia
     */
    public static List<String> clonar(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return (ArrayList) list.clone();
    }
}