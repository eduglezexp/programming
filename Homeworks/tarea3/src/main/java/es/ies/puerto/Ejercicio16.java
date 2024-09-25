package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Si tienes un arma de fuego y munición, puedes luchar contra los zombies. 
 * Si tienes un arma cuerpo a cuerpo, puedes defenderte. Si no tienes armas, debes huir.
 * Escribe un programa que determine qué hacer según el tipo de arma y si tienes munición.
 * @author eduglezexp
 */

public class Ejercicio16 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Que tipo de armas tienes? (fuego, cuerpo a cuerpo, ninguna)");
        String arma = scanner.nextLine();
        arma = arma.toLowerCase();
        
        if (arma.equals("fuego")) {
            System.out.println("¿Cuanta municion tienes?");
            int municion = scanner.nextInt();        
        }
    }
}
