package es.ies.puerto;

/**
 * Simula el daño crítico de un ataque multiplicando el daño base 
 * por un número aleatorio entre 1.5 y 2.0 usando Math.random().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        int danioBase = 200;
        double numeroRandom = 1.5 + (Math.random() * (2.0 - 1.5));
        double danioCritico = danioBase * numeroRandom;
        System.out.println(danioCritico);
    }
}