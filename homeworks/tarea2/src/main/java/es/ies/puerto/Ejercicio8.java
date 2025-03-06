package es.ies.puerto;

/**
 * Crea un programa que convierta una distancia en millas a kilómetros.
 * - Fórmula: 1 milla = 1.60934 km.
 * - Pide al usuario que introduzca la distancia en millas.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio8 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce una distancia en millas para pasarla a kilometros: ");
            double millas = scanner.nextDouble();

            if (millas >= 0) {
                double kilometros = millas * 1.60934;
                System.out.println(millas+ " millas son: " +kilometros+ " kilometros");
            } else {
                System.out.println("No pueden haber millas negativas");
            }

        } catch(InputMismatchException exception) {
            System.out.println("Introduce un valor valido en millas");
        } finally {
            scanner.close();
        }
    }
}
