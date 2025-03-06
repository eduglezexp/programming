package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Vehiculo;

/**
 * Crea un objeto de la clase Vehiculo con marca "Honda", modelo "Civic", 
 * y combustible 40 litros. Agrega 20 litros de combustible al vehículo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    static Vehiculo vehiculo;
    public static void main(String[] args) {
        vehiculo = new Vehiculo("Honda", "Civic", 40);
        String agregarCombustible = vehiculo.agregarCombustible(20);
        System.out.println(agregarCombustible);
    }
}
