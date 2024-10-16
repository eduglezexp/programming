package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Empleado;

/**
 * Crea un objeto de la clase Empleado con nombre "Carlos", puesto "Ingeniero" y salario 3000. 
 * Intenta asignar un puesto vacío y muestra el resultado de la validación.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    static Empleado empleado;
    public static void main(String[] args) {
        empleado = new Empleado("Carlos", null , 3000);
        System.out.println(empleado);
    }
}
