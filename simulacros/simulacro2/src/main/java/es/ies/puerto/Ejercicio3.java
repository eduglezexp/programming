package es.ies.puerto;

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

public class Ejercicio3 {
    public static void main(String[] args) {
        Persona persona = new Persona("nombre", 29, "0000000E");
        System.out.println(persona);
        Persona otraPersona = new Persona("nombre", 29, "0000000E");
        System.out.println("¿otraPersona es igual a la persona? " +otraPersona.equals(persona));
    }
}
