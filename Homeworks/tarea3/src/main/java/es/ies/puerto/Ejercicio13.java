package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Si la energía del traje de Iron Man es mayor al 70%, puede volar. 
 * Si es mayor al 30% pero menor o igual al 70%, puede caminar. 
 * Si es menor o igual al 30%, está en modo crítico.
 * Crea un programa que determine el estado de Iron Man según su 
 * nivel de energía.
 * @author eduglezexp
 */

public class Ejercicio13 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el nivel de energia de Iron Man: ");
            int nivelEnergia = scanner.nextInt();

            if (nivelEnergia > 70) {
                System.out.println("Iron Man puede volar");
            } else if (nivelEnergia > 30) {
                System.out.println("Iron Man puede caminar");
            } else {
                System.out.println("Iron Man está en modo crítico");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido para el nivel de " +
            "energia de Iron Man");
        } finally {
            scanner.close();
        }
    }
}
