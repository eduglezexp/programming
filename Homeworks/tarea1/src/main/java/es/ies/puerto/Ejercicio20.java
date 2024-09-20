package es.ies.puerto;

/**
 * Crea un programa que intercambie los valores de dos variables enteras. 
 * Por ejemplo, si la variable a vale 5 y b vale 10, después del intercambio 
 * a debería valer 10 y b 5.
 * @author eduglezexp 
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Antes del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temporal = a;
        a = b;
        b = temporal;

        System.out.println("Después del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}