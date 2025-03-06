package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        Vector<Integer> numeros = new Vector<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        System.out.println(numeros.get(2));
        int posicion = 3;
        int nuevoElemento = 10;
        System.out.println(modificarElementoVector(numeros, posicion, nuevoElemento));
    }

    /**
     * Metodo para modificar un elemento del vector, dada su posicion y un elemento nuevo
     * @param vector
     * @param posicion
     * @param nuevoElemento
     * @return vector modificado
     */
    public static Vector<Integer> modificarElementoVector(Vector<Integer> vector, int posicion, int nuevoElemento) {
        int indice = posicion-1;
        vector.set(indice, nuevoElemento);
        return vector;
    }
}