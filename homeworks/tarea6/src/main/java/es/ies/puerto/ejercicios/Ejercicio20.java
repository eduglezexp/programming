package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Circulo;

/**
 * Crea un objeto de la clase Circulo con radio -3. Asegúrate de que el radio sea un 
 * valor positivo mayor a 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    static Circulo circulo;
    public static void main(String[] args) {
        Circulo circulo = new Circulo(-3);
        System.out.println(circulo);
    }
}
