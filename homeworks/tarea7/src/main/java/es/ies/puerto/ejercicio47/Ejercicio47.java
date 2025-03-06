package es.ies.puerto.ejercicio47;

import es.ies.puerto.ejercicio2.Producto;

/**
 * 47. Clase Supermercado con Carrito de Compras
 * Crea una clase Supermercado con una lista (array) de productos en un carrito de compras. 
 * Implementa métodos para agregar y eliminar productos, y usa toString() para describir el 
 * contenido del carrito. Utiliza un array la clase Producto del ejercicio 2.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio47 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("01", "Leche", 1.50f, 2);
        Producto producto2 = new Producto("02", "Pan", 0.80f, 5);
        Producto producto3 = new Producto("03", "Huevos", 2.00f, 12);
        Supermercado supermercado = new Supermercado("Supermercado1");
        supermercado.addProducto(producto1);
        supermercado.addProducto(producto2);
        supermercado.addProducto(producto3);
        System.out.println(supermercado);
        supermercado.deleteProducto(producto2);
        System.out.println("\nDespues de eliminar uun producto:");
        System.out.println(supermercado);
    }
}
