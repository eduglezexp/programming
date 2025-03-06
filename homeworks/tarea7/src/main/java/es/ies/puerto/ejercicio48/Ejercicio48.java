package es.ies.puerto.ejercicio48;

/**
 * 48. Clase Parque con Atracciones
 * Crea una clase Parque con una lista (array) de atracciones (clase Atraccion, 
 * con las propiedades:precio, nombre). Implementa métodos para agregar y eliminar 
 * atracciones, y usa toString() para describir el parque.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio48 {
    public static void main(String[] args) {
        Atraccion atraccion1 = new Atraccion("Montaña Rusa", 10.0f);
        Atraccion atraccion2 = new Atraccion("Rueda de la Fortuna", 5.0f);
        Atraccion atraccion3 = new Atraccion("Carros chocones", 7.5f);
        Parque parque = new Parque("Parque1");
        parque.addAtraccion(atraccion1);
        parque.addAtraccion(atraccion2);
        parque.addAtraccion(atraccion3);
        System.out.println(parque);
        parque.deleteAtraccion(atraccion2);
        System.out.println("\nDespues de eliminar una atraccion:");
        System.out.println(parque);
    }
}
