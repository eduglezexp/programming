package es.ies.puerto;

/**
 * Crea un programa que pida al usuario su peso (en kg) y su altura (en metros), 
 * y luego calcule su Índice de Masa Corporal (IMC).
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio10 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce tu peso en kg: ");
            float peso = scanner.nextFloat();

            System.out.println("Introduce tu altura en metros: ");
            float altura = scanner.nextFloat();

            if (peso > 0 && altura > 0) {
                float imc = peso / (altura * altura);
                System.out.println("El IMC es: " +imc);
            } else {
                System.out.println("El peso y/o altura no puede ser cero ni negativo");
            }

        } catch (InputMismatchException exception) {
            System.out.println("Error: debes introducir un peso en kg y una altura en metros");
        } finally {
            scanner.close();
        }
    }
}
