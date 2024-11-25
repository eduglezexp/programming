package es.ies.puerto.ejercicio32;

import java.util.Objects;

/**
 * 32. Clase Hospital con Pacientes
 * Crea una clase Hospital que almacene una lista (array) (array) de pacientes (clase Paciente).
 * Implementa métodos para agregar, eliminar y listar pacientes. 
 * Usa toString() para describir el hospital.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Paciente {
    private String nombre;
    private int edad;
    private String id;

    /**
     * Constructor por defecto
     */
    public Paciente() {

    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param edad
     * @param id
     */
    public Paciente(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nPaciente [ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Paciente)) {
            return false;
        }
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}