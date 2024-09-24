package es.ies.puerto;

import java.util.Scanner;

/**
 * Si tu pokémon es de tipo Agua y el rival es de tipo Fuego, ganas. 
 * Si es Planta, pierdes. Si el rival es Agua, empatas.
 * Crea un programa que reciba los tipos de los pokémon y determine 
 * el resultado de la batalla.
 * @author eduglezexp
 */

public class Ejercicio14 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce el tipo de pokemon del jugador 1: ");
        String tipo1 = scanner.nextLine();
        tipo1 = tipo1.toLowerCase();
        System.out.println("Introduce el tipo de pokemon del jugador 2: ");
        String tipo2 = scanner.nextLine();
        tipo2 = tipo2.toLowerCase();
        if (tipo1.equals("agua") && tipo2.equals("fuego")) {
            System.out.println("Gana el juegador 1");
        }
    }
}
