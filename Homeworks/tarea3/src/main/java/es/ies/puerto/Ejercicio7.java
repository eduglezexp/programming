package es.ies.puerto;

/**
 * Frodo está viajando a Mordor. Si la distancia es mayor a 1000 kilómetros, 
 * necesitará descansar. Si es menor, podrá continuar. 
 * Escribe un programa que reciba la distancia a Mordor y diga si Frodo 
 * necesita descansar o no.
 * @author eduglezexp
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce la distancia en kilometros restantes para " +
            "llegar a Mordor: ");
            int distancia = scanner.nextInt();

            if (distancia > 1000) {
                System.out.println("Frodo necesita descansar");
            } else {
                System.out.println("Frodo debe continuar");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un valor entero para determinar la distancia en " + 
            "kilometros restantes a Mordor");
        }
    }
}
