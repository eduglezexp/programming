package es.ies.puerto;

/**
 * Escribe un programa que pida dos números enteros al usuario 
 * y determine cuál de ellos es mayor, o si son iguales.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio9 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce dos numeros enteros: ");
            int numero1 = scanner.nextInt();
            int numero2 = scanner.nextInt();

            if (numero1 == numero2) {
                System.out.println("El numero " +numero1+ " es igual al numero " +numero2);
            }
            else if (numero1 > numero2) {
                System.out.println("El numero " +numero1+ " es mayor que el numero " +numero2);
            } else {
                System.out.println("El numero " +numero2+ " es mayor que el numero " +numero1);
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce dos numeros enteros validos");
        } finally {
            scanner.close();
        }
    }
}
