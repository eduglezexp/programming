package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Vehiculo;

/**
 * Crea un objeto de la clase Vehiculo con marca "Ford", modelo "Fiesta", 
 * y combustible 15 litros. Intenta asignar un valor negativo al combustible 
 * y muestra el resultado de la validación.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio18 {
    static Vehiculo vehiculo;
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("Ford", "Fiesta", -15);
        System.out.println(vehiculo);
    }
}
