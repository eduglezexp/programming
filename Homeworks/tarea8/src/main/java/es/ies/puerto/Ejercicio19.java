package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Samuel", 19, "4345126789E"));
        personas.add(new Persona("Daniel", 19, "4345326789T"));
        personas.add(new Persona("Eduardo", 20, "4345126789Y"));
        personas.add(new Persona("Alberto", 19, "4345126789G"));
        personas.add(new Persona("Antonio", 20, "4345126789D"));
        String dni = "4345126789Y";
        for (Persona persona : personas) {
            System.out.println(persona);
            if (persona.getDni().equals(dni)) {
                System.out.println(persona);
            }
        }
    }
}