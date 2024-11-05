package es.ies.puerto.ejercicio39;

import es.ies.puerto.ejercicio22.Articulo;

/**
 * 39. Clase Tienda con Artículos
 * Crea una clase Tienda que almacene una lista (array) de artículos 
 * (clase Articulo ejercicio 22). Implementa métodos para agregar y 
 * eliminar artículos y usar toString() para mostrar los detalles de la tienda.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio39 {
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Tienda1");
        Articulo articulo1 = new Articulo("producto1", 10, 30);
        Articulo articulo2 = new Articulo("producto2", 5, 20);
        Articulo articulo3 = new Articulo("producto3", 30, 15);
        tienda.addProducto(articulo1);
        tienda.addProducto(articulo2);
        tienda.addProducto(articulo3);
        System.out.println(tienda);
        tienda.deleteArticulo(articulo2);
        System.out.println(tienda);
    }
}