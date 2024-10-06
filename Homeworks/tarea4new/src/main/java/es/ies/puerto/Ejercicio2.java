package es.ies.puerto;

/**
 * Los héroes de un equipo de aventureros tienen diferentes cantidades de puntos 
 * de vida. Escribe un programa que calcule la suma total de puntos de vida de 
 * todos los aventureros en un array.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] puntosDeVida = {100, 200, 150, 180, 90}; 
        int suma = 0;
        for (int i = 0; i < puntosDeVida.length; i++) {
            suma += puntosDeVida[i];
        }
        System.out.println("Puntos de vida total: " +suma);
    }
}
