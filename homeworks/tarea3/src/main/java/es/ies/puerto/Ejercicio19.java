package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Si tienes más de 500 minerales y más de 300 gas, puedes construir un coloso. 
 * Si no tienes suficientes recursos, construyes un marine. 
 * Crea un programa que determine qué unidad puedes construir en StarCraft según 
 * los recursos.
 * @author eduglezexp
 */

public class Ejercicio19 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el numero de minerales que tienes: ");
            int minerales = scanner.nextInt();
            System.out.println("Introduce el numero de gas que tienes: ");
            int gas = scanner.nextInt();

            if (minerales > 500 && gas > 300) {
                System.out.println("Puedes construir un coloso");
            } else {
                System.out.println("¡No tines suficientes materiales para un coloso!, por " +
                "lo que se construira un marine.");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un cantidad de minerales y gas en numeros enteros");
        } finally {
            scanner.close();
        }
    }
}
