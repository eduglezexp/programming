package es.ies.puerto.ejercicio24;

import java.util.Objects;

/**
 * 24. Clase Zoológico con Animales
 * Crea una clase Zoologico que almacene una lista (array) (array) de animales 
 * (clase Animal) con atributos nombre y especie. Implementa métodos para agregar, 
 * eliminar y listar animales. Usa toString() para describir el zoológico.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Animal {
    private String nombre;
    private String especie;

    /**
     * Constructor por defecto
     */
    public Animal() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param especie
     */
    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return " Animal [nombre=" + nombre + ", especie=" + especie + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(nombre, animal.nombre) && Objects.equals(especie, animal.especie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, especie);
    }
}