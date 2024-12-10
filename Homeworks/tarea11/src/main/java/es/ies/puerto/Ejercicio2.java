package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    static Vector<Integer> vector;
    public static void main(String[] args) {
        vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println(vector.get(2));
        vector.set(2, 10);
        System.out.println(vector);
    }
}