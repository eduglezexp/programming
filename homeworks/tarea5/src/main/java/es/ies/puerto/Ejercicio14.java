package es.ies.puerto;

/**
 * Calcula la potencia de Superman en función de un poder inicial de 5 elevado 
 * a la fuerza de un enemigo (usa el método Math.pow()).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        int poder = 5;
        int enemigo = 3;
        double potencia = Math.pow(poder, enemigo);
        System.out.println(potencia);
    }
}