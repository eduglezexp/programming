package es.ies.puerto;

/**
 * Si eres un Sith o un Jedi, puedes usar la Fuerza. 
 * Si no, eres un simple mortal.
 * Crea un programa que pregunte al usuario si es 
 * Sith o Jedi y le diga si puede usar la Fuerza o no.
 * @author eduglezexp
 */

import java.util.Scanner;

public class Ejercicio4 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Eres un Sith o un Jedi? Contesta si o no: ");
        String respuesta = scanner.nextLine();
        respuesta = respuesta.toLowerCase();

        switch (respuesta) {
            case "si":
                System.out.println("¡Puedes usar la Fuerza!");
                break;
            case "no":
                System.out.println("Eres un simple mortal");
                break;
            default:
                System.out.println("Respuesta no valida. Debes responder si o no");
                break;
        }
        scanner.close();
    }
}
