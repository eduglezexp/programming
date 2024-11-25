package es.ies.puerto.ejercicio1;

/**
 * 1. Clase Persona con Métodos Simples
 * Crea una clase Persona con atributos nombre, edad, y genero. Sobrescribe toString()
 * para devolver su información como cadena.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Persona {
    private String nombre;   
    private int edad;       
    private String genero;

    /**
     * Constructor por defecto
     */
    public Persona() {}

    /**
     * Constructor general
     * @param nombre de la persona
     * @param edad de la persona
     * @param genero de la persona
     */
    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    /**
     * Muestra la informacion de la persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", Género='" + genero + '\'' +
                '}';
    }
}