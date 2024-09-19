package es.ies.puerto;

public class Ejercicio20 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Antes del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("Después del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}