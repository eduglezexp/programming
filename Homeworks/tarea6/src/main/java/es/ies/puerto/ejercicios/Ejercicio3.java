package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Coche;

/**
 * Crea un objeto de la clase Coche con marca "Toyota", modelo "Corolla", y año 2022. 
 * Muestra los atributos del coche (marca, modelo, año) usando getters.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    static Coche coche;
    public static void main(String[] args) {
        coche = new Coche("Toyota", "Corolla", 2022);
        System.out.printf("Marca: "+coche.getMarca()+ "\nModelo: " +coche.getModelo()+ 
        "\nAño: " +coche.getAnio());
    }
}
