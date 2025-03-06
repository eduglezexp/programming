package es.ies.puerto.ejercicio35;

/**
 * 35. Clase Bebida con Precio y Tamaño
 * Crea una clase Bebida con atributos nombre, precio y tamaño. Implementa métodos para 
 * comparar bebidas por su tamaño con equals() y usar toString() para mostrar detalles.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio35 {
    public static void main(String[] args) {
        Bebida bebida1 = new Bebida("Coca Cola", 1.50f, "Mediano");
        Bebida bebida2 = new Bebida("Fanta", 1.30f, "Mediano");
        Bebida bebida3 = new Bebida("Agua", 0.80f, "Grande");
        System.out.println(bebida1);
        System.out.println(bebida2);
        System.out.println(bebida3);
        System.out.println("¿La bebida1 es igual a la bebida2 por tamaño? " + bebida1.equals(bebida2));
        System.out.println("¿La bebida1 es igual a la bebida3 por tamaño? " + bebida1.equals(bebida3));
    }
}
