package es.ies.puerto.ejercicio22;

import java.util.Objects;

/**
 * 22. Clase Articulo con Stock
 * Crea una clase Articulo con atributos nombre, precio, y stock. Implementa métodos 
 * aumentarStock() y disminuirStock(). Usa equals() para comparar artículos por su nombre 
 * y toString() para mostrar su información.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Articulo {
    private String nombre;
    private float precio; 
    private int stock;

    /**
     * Constructor por defecto
     */
    public Articulo() {
    }

    /**
     * Constructor para inicializar el artículo con nombre, precio y stock inicial.
     * @param nombre Nombre del artículo
     * @param precio Precio del artículo
     * @param stock Cantidad en stock
     */
    public Articulo(String nombre, float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio; 
    }

    public void setPrecio(float precio) { 
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Método para aumentar el stock en una cantidad especificada.
     * @param cantidad La cantidad a agregar al stock actual.
     */
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
        }
    }

    /**
     * Método para disminuir el stock en una cantidad especificada.
     * @param cantidad La cantidad a restar del stock actual.
     * @return true si la operación fue exitosa, false si la cantidad es mayor que el stock actual.
     */
    public boolean disminuirStock(int cantidad) {
        if (cantidad < 0 && cantidad > stock) {
            return false;
        } 
        stock -= cantidad;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Articulo)) {
            return false;
        }
        Articulo articulo = (Articulo) o;
        return nombre.equalsIgnoreCase(articulo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    

    @Override
    public String toString() {
        return "Artículo: " + nombre + ", Precio: $" + precio + ", Stock: " + stock + " unidades\n";
    }
}

