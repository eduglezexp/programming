package es.ies.puerto;

/**
 * Dada la transformación Saiyan en nivel 9000, convierte este número a hexadecimal y 
 * binario usando métodos de Integer.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        int nivel = 9000;
        String nivelBinario = Integer.toBinaryString(nivel);
        String nivelHexadecimal = Integer.toHexString(nivel);
        System.out.println(nivelBinario);
        System.out.println(nivelHexadecimal);
    }
}