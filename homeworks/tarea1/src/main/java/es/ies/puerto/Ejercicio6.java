package es.ies.puerto;

/**
 * Declara tres variables enteras, asigna valores a cada 
 * una y calcula su promedio.
 * @author eduglezexp
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        int numero1 = 5;
        int numero2 = 4;
        int numero3 = 7;
        int suma = numero1 + numero2 + numero3;
        float promedio = (float) suma / 3;
        System.out.println("El promedio es: " +promedio);
    }
}