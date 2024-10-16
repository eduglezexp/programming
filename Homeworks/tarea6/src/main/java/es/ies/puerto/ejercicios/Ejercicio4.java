package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Coche;

/**
 * Crea un objeto de la clase Coche con marca "Ford", modelo "Mustang", y año 2020. 
 * Intenta asignar un año menor a 1886 y muestra el resultado de la validación.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    static Coche coche;
    public static void main(String[] args) {
        Coche coche = new Coche("Ford", "Mustang", 2020);
        coche.setAnio(1882);
        System.out.println(coche);
    }
}
