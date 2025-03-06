package es.ies.puerto;

/**
 * Compara el poder de pelea de Goku (9000) con el de 
 * Vegeta (8500) usando el método Integer.compare().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio26 {
    public static void main(String[] args) {
        int poderGoku = 9000;
        int poderVegetta = 8500;
        int compararPoder = Integer.compare(poderGoku, poderVegetta);
        System.out.println(compararPoder);
    }
}