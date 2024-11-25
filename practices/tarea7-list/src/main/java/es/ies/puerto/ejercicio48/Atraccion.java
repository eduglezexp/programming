package es.ies.puerto.ejercicio48;

/**
 * 48. Clase Parque con Atracciones
 * Crea una clase Parque con una lista (array) de atracciones (clase Atraccion, 
 * con las propiedades:precio, nombre). Implementa métodos para agregar y eliminar 
 * atracciones, y usa toString() para describir el parque.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Atraccion {
    private String nombre;
    private float precio;   

    /**
     * Constructor por defecto
     */
    public Atraccion() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param precio
     */
    public Atraccion(String nombre, float precio) {
        this.nombre = nombre;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\nAtraccion{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}