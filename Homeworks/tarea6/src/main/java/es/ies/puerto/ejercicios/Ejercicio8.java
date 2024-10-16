package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Empleado;

/**
 * Crea un objeto de la clase Empleado con nombre "Ana", puesto "Gerente", y salario 5000. 
 * Asegúrate de que el salario no sea negativo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    static Empleado empleado;
    public static void main(String[] args) {
        empleado = new Empleado("Ana", "Gerente", 5000);
        System.out.println(empleado);
    }
}
