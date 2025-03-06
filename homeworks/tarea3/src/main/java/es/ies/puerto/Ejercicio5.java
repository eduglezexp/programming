package es.ies.puerto;

/**
 * Goku está en una batalla. Si su nivel de poder es mayor de 9000, 
 * está en "Modo Super Saiyan". Si no, está en "Modo normal".
 * Escribe un programa que reciba el nivel de poder de Goku y 
 * determine en qué modo está.
 * @author eduglezexp
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce cuanto es el nivel de poder de Goku actualmente: ");
            int poder = scanner.nextInt();

            if (poder > 9000) {
                System.out.println("Modo Super Saiyan activado");
            } else {
                System.out.println("Modo normal");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Debes introducir un numero entero para saber en que forma esta Goku");
        } finally {
            scanner.close();
        }
    }
}
