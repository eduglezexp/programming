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
        System.out.println("Introduce el tipo de pokemon del jugador 1: (Agua, Fuego, Planta)");
        String tipo1 = scanner.nextLine().toLowerCase(); // Convertir a minúsculas para evitar errores
        System.out.println("Introduce el tipo de pokemon del jugador 2: (Agua, Fuego, Planta)");
        String tipo2 = scanner.nextLine().toLowerCase();

        // Switch para determinar el resultado según el tipo del jugador 1
        switch (tipo1) {
            case "agua":
                switch (tipo2) {
                    case "fuego":
                        System.out.println("Gano el jugador 1");
                        break;
                    case "planta":
                        System.out.println("Gano el jugador 2");
                        break;
                    case "agua":
                        System.out.println("Empatasteis");
                        break;
                    default:
                        System.out.println("El tipo de pokemon del jugador 2 es invalido");
                        break;
                }
                break;

            case "fuego":
                switch (tipo2) {
                    case "planta":
                        System.out.println("Gano el jugador 1");
                        break;
                    case "agua":
                        System.out.println("Gano el jugador 2");
                        break;
                    case "fuego":
                        System.out.println("Empatasteis");
                        break;
                    default:
                        System.out.println("El tipo de pokemon del jugador 2 es invalido");
                        break;
                }
                break;

            case "planta":
                switch (tipo2) {
                    case "agua":
                        System.out.println("Gano el jugador 1");
                        break;
                    case "fuego":
                        System.out.println("Gano el jugador 2");
                        break;
                    case "planta":
                        System.out.println("Empatasteis");
                        break;
                    default:
                        System.out.println("El tipo de pokemon del jugador 2 es invalido");
                        break;
                }
                break;

            default:
                System.out.println("El tipo de pokemon del jugador 1 es invalido");
                break;
        }

        scanner.close();
    }
}
