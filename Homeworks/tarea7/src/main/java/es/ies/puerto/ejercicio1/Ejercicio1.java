package es.ies.puerto.ejercicio1;

/**
 * 1. Clase Persona con Métodos Simples
 * Crea una clase Persona con atributos nombre, edad, y genero. Sobrescribe toString()
 * para devolver su información como cadena.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan Pérez", 28, "Masculino");
        System.out.println(persona); 
    }
}
