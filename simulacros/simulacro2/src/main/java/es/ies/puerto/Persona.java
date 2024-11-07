package es.ies.puerto;

import java.util.Objects;

/**
 * Ejercicio 3: Construcción de Clases - Clase Persona
 * Descripción: Crea una clase Persona con los siguientes atributos:
 *  nombre (String)
 *  edad (int)
 *  dni (String)
 * Define los métodos necesarios:
 *  Constructor que permita inicializar todos los atributos.
 *  Método esMayorDeEdad que devuelva true si la persona es mayor de edad (edad >= 18) 
 *  y false en caso contrario.
 * Ejemplo de uso:
 *  Crear una instancia de Persona, por ejemplo persona y cuando hagamos un sout de 
 *  persona debe de mostrar la información del objeto en memoria, que debería mostrar 
 *  todos los datos ingresados.
 *  Crea una segunda instancia de Persona, llamada otraPersona con los mismos datos y 
 *  verifica que son la misma persona. El resultado debería de ser true.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    /**
     * Constructor por defecto
     */
    public Persona() {
    }

    /**
     * Constuctor con todas las propiedades
     * @param nombre
     * @param edad
     * @param dni
     */
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Metodo para verificar si una persona es mayor de edad
     * @return true/false
     */
    public boolean esMayorDeEdad() {
        if (edad >= 18) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(dni);
    }


    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
    }
}