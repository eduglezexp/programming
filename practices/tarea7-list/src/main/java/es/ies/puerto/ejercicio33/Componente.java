package es.ies.puerto.ejercicio33;

/**
 * 33. Clase Computadora con Componentes
 * Crea una clase Computadora con atributos marca, modelo y una lista (array) de componentes 
 * (como Procesador, RAM, etc.). Implementa métodos para agregar componentes y usar toString() 
 * para describir la computadora.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Componente {
    private String nombre;
    private String modelo;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public Componente() {
    }

    /**
     * Copnstructor con todas las propiedades
     * @param nombre
     * @param modelo
     * @param descripcion
     */
    public Componente(String nombre, String modelo, String descripcion) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nComponente [nombre=" + nombre + ", modelo=" + modelo + ", descripcion=" + descripcion + "]";
    }
}