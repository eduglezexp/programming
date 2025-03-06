package es.ies.puerto;

/**
 * En un juego de Mario, calcula cuántas vidas extra tiene el jugador si 
 * obtiene 250 monedas (usa Math.floor() para las divisiones entre 100).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        int monedas = 250;
        int vidas = (int) Math.floor(monedas / 100);
        System.out.println(vidas);
    }
}