package es.ies.puerto.ejercicio34;

/**
 * 34. Clase Restaurante con Menú
 * Crea una clase Restaurante con una lista (array) de platos (clase Plato). 
 * Implementa métodos para agregar y eliminar platos del menú y usar toString() 
 * para mostrar los detalles del restaurante.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Plato {
    private String nombre;
    private String descripcion;
    private float precio;

    /**
     * Constructor por defecto
     */
    public Plato() {

    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param descripcion
     * @param precio
     */
    public Plato(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\nPlato [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
    }
}