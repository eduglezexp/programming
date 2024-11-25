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
        Vehiculo vehiculo = new Vehiculo("Renault", "Logan", "una");
        Vehiculo vehiculo2 = new Vehiculo("Renault", "Logan", "dos");
        Vehiculo vehiculo3 = new Vehiculo("Renault", "Logan", "una");
        renault.agregar(vehiculo);
        renault.agregar(vehiculo2);
        System.out.println(renault);
        renault.eliminar(vehiculo3);
        System.out.println(renault);
    }
}