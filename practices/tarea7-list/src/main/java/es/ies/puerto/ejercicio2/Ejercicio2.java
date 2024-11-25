package es.ies.puerto.ejercicio2;

/**
 * 2. Clase Producto con Métodos y equals()
 * Crea una clase Producto con los atributos id, nombre y precio, y cantidad. 
 * Implementa el método equals() para comparar dos productos según su nombre y precio, 
 * y también toString() para mostrar su información.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("id1", "producto1", 
        10, 2);
        Producto producto2 = new Producto("id2", "proucto2", 
        20, 1);
        System.out.println("Producto 1: " +producto1);
        System.out.println("Producto 2: " +producto2);
        System.out.println("¿Son iguales? " +producto1.equals(producto2));
    }
}