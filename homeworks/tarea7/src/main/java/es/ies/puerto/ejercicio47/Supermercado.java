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

 public class Supermercado {
    private int numeroProductos; 
    private String nombre;
    private Producto[] productos; 

    /**
     * Constructor por defecto
     */
    public Supermercado() {
        this.numeroProductos = 0;
        this.productos = new Producto[10]; 
    }

    /*
     * Constructor con la propiedad nombre
     */
    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.numeroProductos = 0;
        this.productos = new Producto[10]; 
    }

    /**
     * Metodo para agregar un producto al carrito
     * @param producto
     * @return true/false
     */
    public boolean addProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        if (numeroProductos >= productos.length) {
            return false; 
        }
        productos[numeroProductos] = producto;
        numeroProductos++;
        return true;
    }

    /**
     * Metodo para eliminar un producto del carrito
     * @param producto
     * @return true/false
     */
    public boolean deleteProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        if (numeroProductos == 0) {
            return false; 
        }
        for (int i = 0; i < productos.length; i++) {
            if (producto.equals(productos[i])) {
                productos[i] = null;
                numeroProductos--;
                ordenarLista();
                return true;
            }
        }
        return false; 
    }

    /**
     * Metodo para ordenar la lista de productos despues de una eliminacion
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                productos[index++] = productos[i];
            }
        }
        while (index < productos.length) {
            productos[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " + nombre;
        for (int i = 0; i < numeroProductos; i++) {
            mensaje += productos[i];
        }
        return mensaje;
    }
}