package es.ies.puerto.ejercicio23;

import es.ies.puerto.ejercicio2.Producto;

/**
 * 23. Clase Pedido con Detalles de Productos
 * Crea una clase Pedido que tenga una lista (array) de productos y la cantidad de cada uno. 
 * Implementa métodos para agregar productos, calcular el total y usar toString() para mostrar 
 * el pedido.
 * Utiliza un array la clase Producto del ejercicio 2.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Pedido {
    private Producto[] productos;
    private int[] cantidades;
    private int contador; 

    public Pedido() {
    }

    public Pedido(int capacidad) {
        productos = new Producto[capacidad];
        cantidades = new int[capacidad];
        contador = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (contador < productos.length) {
            productos[contador] = producto;
            cantidades[contador] = cantidad;
            contador++;
        } else {
            System.out.println("No se pueden agregar más productos al pedido.");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido:\n");
        for (int i = 0; i < contador; i++) {
            sb.append(productos[i].toString())
              .append(" x ")
              .append(cantidades[i])
              .append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
}