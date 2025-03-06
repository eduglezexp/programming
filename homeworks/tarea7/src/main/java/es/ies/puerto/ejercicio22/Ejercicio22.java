package es.ies.puerto.ejercicio22;

/**
 * 22. Clase Articulo con Stock
 * Crea una clase Articulo con atributos nombre, precio, y stock. Implementa métodos 
 * aumentarStock() y disminuirStock(). Usa equals() para comparar artículos por su nombre 
 * y toString() para mostrar su información.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio22 {
     public static void main(String[] args) {
        Articulo articulo1 = new Articulo("Laptop", 1500.0f, 10); 
        System.out.println(articulo1);
        articulo1.aumentarStock(5);
        System.out.println("Despues de aumentar stock: " + articulo1);
        articulo1.disminuirStock(3);
        System.out.println("Despues de disminuir stock: " + articulo1);
        Articulo articulo2 = new Articulo("laptop", 1600.0f, 8); 
        System.out.println("¿Son iguales los articulos? " + articulo1.equals(articulo2));
     }
}