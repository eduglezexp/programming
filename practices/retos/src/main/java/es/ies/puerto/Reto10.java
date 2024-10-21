package es.ies.puerto;

import java.util.Scanner;

/**
 * Reto 10: Clasificación de categorías de edad
 * Solicita la edad del usuario e imprime su categoría: "Niño" (0-12 años), 
 * "Adolescente" (13-17 años), "Adulto" (18-64 años), o "Adulto mayor" (65+ años).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto10 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce una edad: ");
            int edad = scanner.nextInt();
        } catch (Exception exception) {
           System.out.println("Introduce un numero entero para la edad");
        } finally {
            scanner.close();
        }
    }
}
