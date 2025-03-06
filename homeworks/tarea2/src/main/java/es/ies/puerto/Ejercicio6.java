package es.ies.puerto;

/**
 * Escribe un programa que reciba un número entero y determine si es par o impar.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;
 
public class Ejercicio6 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce un numero entero: ");
            int numero = scanner.nextInt();

            if (numero % 2 == 0) {
                System.out.println("El numero " +numero+ " es par");
            } else {
                System.out.println("El numero " +numero+ " es impar");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido");
        } finally {
            scanner.close();
        }
    }
}