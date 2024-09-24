package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Eres un guerrero de nivel 5. Si obtienes más de 50 puntos de experiencia, 
 * subes a nivel 6. Si no, te quedas en nivel 5.
 * Escribe un programa que reciba los puntos de experiencia y determine 
 * si subes de nivel o no.
 * @author eduglezexp
 */

public class Ejercicio2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce los puntos de experiencia ganados: ");
            int puntoExperiencia = scanner.nextInt();

            if (puntoExperiencia > 50) {
                System.out.println("Subes a nivel 6");
            } else {
                System.out.println("sigues en el nivel 5");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido para" + 
            "los puntos de experiencia");
        } finally {
            scanner.close();
        }
    }
}
