package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dos luchadores están en el combate final de Mortal Kombat. Si la salud de un luchador 
 * es 0, pierde. Si ambos tienen salud, se evalúa quién tiene más ataque. Si ambos tienen 
 * el mismo ataque, el combate es un empate.
 * Escribe un programa que reciba la salud y ataque de ambos luchadores y determine el 
 * resultado del combate.
 * @author eduglezexp
 */

public class Ejercicio20 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce la salud del luchador 1: ");
            int saludLuchador1 = scanner.nextInt();
            System.out.println("Introduce el numero de ataques del luchador 1: ");
            int ataqueLuchador1 = scanner.nextInt();
            System.out.println("Introduce la salud del luchador 2: ");
            int saludLuchador2 = scanner.nextInt();
            System.out.println("Introduce el numero de ataques del luchador 2: ");
            int ataqueLuchador2 = scanner.nextInt();
            if (saludLuchador1 <= 0 && saludLuchador2 <= 0) {
                System.out.println("¡Ambos luchadores han sido derrotados! Empate");
            } else if (saludLuchador1 <= 0) {
                System.out.println("El luchador 1 ha sido derrotado. Luchador 2 gana");
            } else if (saludLuchador2 <= 0) {
                System.out.println("El luchador 2 ha sido derrotado. Luchador 1 gana");
            } else {
                if (ataqueLuchador1 > ataqueLuchador2) {
                    System.out.println("Luchador 1 gana por tener más ataque");
                } else if (ataqueLuchador2 > ataqueLuchador1) {
                    System.out.println("Luchador 2 gana por tener más ataque");
                } else {
                    System.out.println("¡Ambos luchadores tienen el mismo ataque! Empate.");
                }
            } 
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero para la salud y ataques de " +
            "ambos jugadores");
        } finally {
            scanner.close();
        }
    }
}