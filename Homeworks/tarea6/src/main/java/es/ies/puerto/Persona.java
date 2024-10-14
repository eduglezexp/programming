package es.ies.puerto;

/**
 * Ejercicio 1
 * Crea una clase llamada Persona con los atributos nombre y edad. 
 * Define un constructor que inicialice estos valores.
 * Ejercicio 2
 * Modifica la clase Persona para que tenga métodos getter y setter 
 * para el atributo edad.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Persona {
    private String dni;
    private String nombre;
    private int edad;

    /**
     * Constructor por defecto
     */
    public Persona() {

    }

    /**
     * Constructor con la propiedad del dni
     * @param dni de la persona
     */
    public Persona(String dni) {
        this.dni = dni;
    }

    /**
     * Constructor de las propiedades nombre y edad
     * @param nombre por defecto de la persona
     * @param edad de la persona
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Constructor de todas las propiedades
     * @param dni de la persona
     * @param nombre por defecto de la persona
     * @param edad de la persona
     */
    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Getters and Setters
     */

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
}