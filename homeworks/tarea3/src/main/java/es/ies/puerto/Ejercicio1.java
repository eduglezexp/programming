package es.ies.puerto;

/**
 * Eres un héroe en una mazmorra con dos puertas. Si eliges la puerta correcta, 
 * obtienes una espada mágica. Si eliges la incorrecta, caerás en una trampa.
 * Crea un programa que pregunte al usuario qué puerta elige (1 o 2) y le diga 
 * si ha obtenido la espada o ha caído en la trampa.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        try {
            int puertaCorrecta = random.nextInt(2) + 1;

            System.out.println("Elige una puerta (1 o 2): ");
            int eleccionUsuario = scanner.nextInt();

            if (eleccionUsuario == puertaCorrecta) {
                System.out.println("¡Has obtenido la espada mágica!");
            } else if (eleccionUsuario == 1 || eleccionUsuario == 2) {
                System.out.println("¡Has caído en la trampa!");
            } else {
                System.out.println("Opción no válida. Elige 1 o 2.");
            }
        } catch(InputMismatchException exception) {
            System.out.println("Debes introducir el numero 1 o 2");
        } finally {
            scanner.close();
        }
    }
}