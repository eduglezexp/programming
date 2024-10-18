package es.ies.puerto;

/**
 * Reto 4: Determinar si un número es par o impar
 * Escribe un programa que solicite un número entero al usuario y determine si es par o impar 
 * usando una estructura if/else.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto4 {
    public static void main(String[] args) {
        int numero = 2;
        System.out.println(parEImpar(numero));
    }

    public static String parEImpar(int numero) {
        if (numero % 2 == 0) {
            return "El numero " +numero+ " es par";
        }
        return "El numero " +numero+ " es impar";
    }
}
