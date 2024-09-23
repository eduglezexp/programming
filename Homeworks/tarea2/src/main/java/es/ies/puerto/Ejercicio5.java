package es.ies.puerto;

/**
 * Escribe un programa que pida al usuario tres números de tipo float 
 * y calcule el promedio de los tres.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio5 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce tres numeros: ");
            float numero1 = scanner.nextInt();
            float numero2 = scanner.nextInt();
            float numero3 = scanner.nextInt();

            float suma = numero1 + numero2 + numero3;
            float promedio = suma / 3;
            System.out.println("El promedio de los tres numeros es: " +promedio);
        } catch(InputMismatchException exception) {
            System.out.println("Introduce tres numeros validos");
        } finally {
            scanner.close();
        }
    }
}
