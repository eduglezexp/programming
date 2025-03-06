package es.ies.puerto;

/**
 * Crea un programa que pida al usuario el radio de un círculo 
 * y calcule su área.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        try {
            System.out.println("Introduce un radio: ");
            double radio = scanner.nextDouble();

            double area = Math.PI * Math.pow(radio, 2);
            System.out.println("El area del circulo con radio " +radio+ 
            ", es: " +area);
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero valido para el radio");
        } finally {
            scanner.close();
        }
    }
}
