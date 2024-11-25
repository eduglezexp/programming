package es.ies.puerto.ejercicio2;
import java.util.Objects;

/**
 * 2. Clase Producto con Métodos y equals()
 * Crea una clase Producto con los atributos id, nombre y precio, y cantidad. 
 * Implementa el método equals() para comparar dos productos según su nombre y precio, 
 * y también toString() para mostrar su información.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Producto {
    private String id;
    private String nombre;
    private float precio;
    private int cantidad;

    /**
     * Constructor por defecto
     */
    public Producto() {
    
    }

    /**
     * Constructor con todas las propiedades
     * @param id del producto
     * @param nombre del producto
     * @param precio del producto
     * @param cantidad del producto
     */
    public Producto(String id, String nombre, float precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Getters and Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "\nProducto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return this.id.equals(producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, cantidad);
    }
}