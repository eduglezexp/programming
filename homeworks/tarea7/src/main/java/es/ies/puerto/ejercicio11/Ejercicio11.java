package es.ies.puerto.ejercicio11;

/**
 * 11. Clase Vehículo
 * Define una clase base Vehiculo con atributos marca y modelo. 
 * Usa toString() para describir el vehículo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("Ford", "Mustang");
        System.out.println(vehiculo);
    }
}