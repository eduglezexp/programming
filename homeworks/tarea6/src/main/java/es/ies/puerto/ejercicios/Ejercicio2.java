package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Persona;

/**
 * Crea un objeto de la clase Persona con nombre "Maria" y edad 25. 
 * Modifica la edad a 26 usando el setter y muestra la edad actualizada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    static Persona persona;
    public static void main(String[] args) {
        persona = new Persona("45312456E", "Juan", 25);
        persona.setEdad(26);
        System.out.println(persona);
    }
}