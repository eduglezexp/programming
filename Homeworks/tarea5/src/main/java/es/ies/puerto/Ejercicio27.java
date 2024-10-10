package es.ies.puerto;

/**
 * Dado el conteo de Midiclorianos de un Jedi, como 12500, convierte 
 * este número a hexadecimal y binario usando métodos de Integer.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio27 {
    public static void main(String[] args) {
        int midiclorianos = 12500;
        String midiclorianosHexadecimal = Integer.toHexString(midiclorianos);
        String midiclorianosBinario = Integer.toBinaryString(midiclorianos);
        System.out.println(midiclorianosHexadecimal);
        System.out.println(midiclorianosBinario);
    }
}