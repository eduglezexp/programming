package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Producto;

/**
 * Crea un objeto de la clase Producto con nombre "Cámara", precio 300, y stock 20. 
 * Realiza una venta de 5 unidades y muestra el stock restante y el total de la venta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio16 {
    static Producto producto;
    public static void main(String[] args) {
        producto = new Producto("Camara", 300, 20);
        String ventaProducto = producto.ventaProductos(producto, 5);
        System.out.println(ventaProducto);
    }
}
