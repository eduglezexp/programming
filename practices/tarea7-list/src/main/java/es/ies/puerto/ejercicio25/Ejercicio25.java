package es.ies.puerto.ejercicio25;

import es.ies.puerto.ejercicio11.Vehiculo;

/**
 * 25. Clase Concesionaria con lista (array) de Vehículos
 * Crea una clase Concesionaria con una lista (array) (array) de vehículos 
 * (clase Vehiculo). Implementa métodos para agregar vehículos, listar todos 
 * los vehículos y usar toString() para mostrar detalles.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio25 {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Mustang");
        Vehiculo vehiculo2 = new Vehiculo("Opel", "Corsa");
        Concesionario concesionario = new Concesionario("TheCarCompany");
        concesionario.addVehiculo(vehiculo1);
        concesionario.addVehiculo(vehiculo2);
        System.out.println(concesionario);
        concesionario.deleteVehiculo(vehiculo1);
        System.out.println(concesionario);
    }
}








