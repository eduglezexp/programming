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
    private String nombre;
    private int edad;

    public Persona() {

    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}