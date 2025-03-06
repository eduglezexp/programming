package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Si la velocidad de la Millennium Falcon es mayor de 1000, se activan 
 * los motores hiperespaciales. Si es mayor de 500 pero menor o igual a 1000, 
 * la nave está a máxima velocidad. Si es menor o igual a 500, la nave está 
 * en velocidad normal.
 * Escribe un programa que reciba la velocidad de la Millennium Falcon y 
 * determine el estado de los motores.
 * @author eduglezexp
 */

public class Ejercicio11 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce la velocidad a la que va la Millennium Falcon: ");
            int velocidad = scanner.nextInt();

            if (velocidad > 1000) {
                System.out.println("Se activan los motores hiperespaciales.");
            } else if (velocidad > 500) {
                System.out.println("La nave está a máxima velocidad.");
            } else {
                System.out.println("La nave está en velocidad normal.");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido para la velocidad de " +
            "la nave");
        }
    }
}
