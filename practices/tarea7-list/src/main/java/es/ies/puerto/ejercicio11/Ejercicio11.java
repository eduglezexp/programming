package es.ies.puerto.ejercicio11;

/**
 * 11. Clase Vehículo
 * Define una clase base Vehiculo con atributos marca y modelo. 
 * Usa toString() para describir el vehículo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio11 {
    static Concesionario renault;
    public static void main(String[] args) {
        renault = new Concesionario("Renault");
        Vehiculo vehiculo = new Vehiculo("Renault", "Logan");
        renault.agregar(vehiculo);
        System.out.println(renault);
    }
}