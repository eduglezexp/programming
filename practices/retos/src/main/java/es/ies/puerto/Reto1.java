package es.ies.puerto;

/**
 * Reto 1: Verificar el acceso a una aplicación
 * Escribe un programa que solicite al usuario un nombre de usuario y una contraseña. 
 * Si el nombre de usuario es "admin" y la contraseña es "1234", imprime 
 * "Acceso concedido". Si no, imprime "Acceso denegado". El programa debe permitir 
 * 3 intentos de inicio de sesión antes de bloquear el acceso.
 * @author eduglezexp
 * @version 1.0.0
 */

import java.util.Scanner;

public class Reto1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int contador = 0;
        do {
            System.out.println("Introduce el nombre de usuario: ");
            String usuario =  scanner.nextLine();
            System.out.println("Introduce la contraseña: ");
            String contrasenia = scanner.nextLine();
            if (usuario.equals("admin") && contrasenia.equals("1234")) {
                System.out.println("Acceso concedido");
                break;
            } else {
                System.out.println("Acceso denegado");
            }
            contador++;
        } while (contador != 3);
    }
}