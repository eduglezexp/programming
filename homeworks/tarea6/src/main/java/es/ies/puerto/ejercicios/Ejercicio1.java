package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Persona;

/**
 * Crea un objeto de la clase Persona con nombre "Juan" y edad 30. 
 * Muestra la información de la persona.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    static Persona persona;
    public static void main(String[] args) {
        persona = new Persona("45612457Y", "Juan", 30);
        System.out.println(persona);
    }
}
