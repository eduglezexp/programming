package es.ies.puerto;

/**
 * Para hacer la fusión, los guerreros deben tener la misma cantidad de ki. 
 * Si los valores de ki no coinciden, la fusión falla. 
 * Escribe un programa que reciba los valores de ki de dos guerreros y 
 * determine si la fusión es exitosa o falla.
 * @author eduglezexp
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce el valor del ki del gerrero 1: ");
            int ki1 = scanner.nextInt();

            System.out.println("Introduce el valor del ki del gerrero 2: ");
            int ki2 = scanner.nextInt();

            if (ki1 == ki2) {
                System.out.println("¡La fusion fue exitosa!");
            } else {
                System.out.println("La fusion ha fallado");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido");
        } finally {
            scanner.close();
        }
    }
}
