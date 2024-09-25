package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Batman y Superman están peleando. Si la fuerza de Superman es mayor a 
 * la de Batman, Superman gana. Si es menor, Batman gana. Si tienen la 
 * misma fuerza, es un empate.
 * Escribe un programa que reciba las fuerzas de ambos héroes y determine 
 * quién gana.
 * @author eduglezexp
 */

public class Ejercicio12 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce la fuerza de Superman: ");
            int fuerzaSuperman = scanner.nextInt();
            System.out.println("Introduce la fuerza de Batman: ");
            int fuerzaBatman = scanner.nextInt();   
            if (fuerzaSuperman == fuerzaBatman) {
                System.out.println("Empate");
            } else if (fuerzaSuperman > fuerzaBatman) {
                System.out.println("Superman gana");
            } else if (fuerzaBatman > fuerzaSuperman) {
                System.out.println("Batman gana");
            } else {
                System.out.println("Debes introducir un numero entero valido");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido para la fuerza " +
            "de cada superheroe");
        } finally {
            scanner.close();
        }
    }
}
