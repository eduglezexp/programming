package es.ies.puerto;

/**
 * En un juego de Mario, calcula cuántas vidas extra tiene si ha recolectado 
 * 1270 monedas, sabiendo que cada 100 monedas obtiene 1 vida extra.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio25 {
    public static void main(String[] args) {
        int monedas = 1270;
        int vidas = (int) Math.floor(monedas / 100);
        System.out.println(vidas+ " vidas extra");
    }
}