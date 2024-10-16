package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Producto;

/**
 * Crea un objeto de la clase Producto con nombre "Laptop", precio 1000, y stock 50. 
 * Asegúrate de que el precio no sea negativo y que el stock no sea menor a 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio15 {
    static Producto producto;
    public static void main(String[] args) {
        producto = new Producto("Laptop", 1000, 50);
        System.out.println(producto);
    }
}
