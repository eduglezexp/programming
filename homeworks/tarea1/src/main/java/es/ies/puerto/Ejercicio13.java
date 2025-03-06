package es.ies.puerto;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Declara una variable de tipo String para almacenar 
 * una dirección de correo electrónico. Muéstrala en 
 * la consola.
 * @author eduglezexp
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);

        System.out.print("Introduce tú email aquí: ");
        String email = scanner.nextLine();

        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("El email es valido");
        } else {
            System.out.println("El email no es valido");
        }

        scanner.close();
    }
}