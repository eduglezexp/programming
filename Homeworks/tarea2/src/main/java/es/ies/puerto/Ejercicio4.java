package es.ies.puerto;

/**
 * Crea un programa que solicite al usuario dos números enteros. 
 * El programa debe sumar y restar ambos números, y mostrar los resultados.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduce dos numeros para realizar una suma y una resta: ");
            int numero1 = scanner.nextInt();
            int numero2 = scanner.nextInt();
            int suma = numero1 + numero2;
            int resta = numero1 - numero2;
            System.out.println("La suma de los numeros es: " +suma);
            System.out.println("La resta de los numeros es: " +resta);
        } catch(InputMismatchException exception) {
            System.out.println("Introduce dos numeros enteros para relizar las operaciones");
        } finally {
            scanner.close();
        }
    }
}
