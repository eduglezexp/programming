package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Si tienes más de 18 años, eres aceptado en la Resistencia. Si tienes menos de 
 * 18 pero eres hábil con armas, también eres aceptado. Si no, debes esperar.
 * Crea un programa que determine si puedes unirte a la Resistencia.
 * @author eduglezexp
 */

public class Ejercicio18 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce tu edad para ver si eres aceptado en la " + 
            "Resistencia: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            if (edad >= 18) {
                System.out.println("Puedes unirte a la Resistencia");
            } else {
                System.out.print("¿Eres habil con las armas? (si/no): ");
                String habilArmas = scanner.next();
                habilArmas = habilArmas.toLowerCase();
    
                if (habilArmas.equals("si")) {
                    System.out.println("Puedes unirte a la Resistencia");
                } else {
                    System.out.println("Debes esperar para unirte a la Resistencia");
                }
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero para tu edad");
        } finally {
            scanner.close();
        }
    }
}
