package es.ies.puerto.ejercicio35;

import java.util.Objects;

/**
 * 35. Clase Bebida con Precio y Tamaño
 * Crea una clase Bebida con atributos nombre, precio y tamaño. Implementa métodos para 
 * comparar bebidas por su tamaño con equals() y usar toString() para mostrar detalles.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Bebida {
    private String nombre;
    private float precio;
    private String tamanio;

    /**
     * Constructor por defecto
     */
    public Bebida() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param precio
     * @param tamanio
     */
    public Bebida(String nombre, float precio, String tamanio) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamanio = tamanio;
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

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Bebida)) {
            return false;
        }
        Bebida bebida = (Bebida) o;
        return Objects.equals(tamanio, bebida.tamanio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tamanio);
    }

    @Override
    public String toString() {
        return "Bebida [nombre=" + nombre + ", precio=" + precio + ", tamanio=" + tamanio + "]";
    }
}