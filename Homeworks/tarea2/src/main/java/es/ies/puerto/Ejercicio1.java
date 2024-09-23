package es.ies.puerto;

/**
 * Crea un programa que pida al usuario su año de nacimiento, 
 * luego calcule su edad y la muestre en la consola.
 * @author eduglezexp
 */

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int anioActual = LocalDate.now().getYear();

        try {
            System.out.print("Introduce tu año de nacimiento: ");
            int anioNacimiento = scanner.nextInt();

            if (anioNacimiento < 1900 || anioNacimiento > anioActual) {
                System.out.println("Introduce un año de nacimiento correcto");
            } else {
                int edad = anioActual - anioNacimiento;
                System.out.println("Tienes " + edad + " años.");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Introduce un año de nacimiento válido");
        } finally {
            scanner.close();
        }
    }
}