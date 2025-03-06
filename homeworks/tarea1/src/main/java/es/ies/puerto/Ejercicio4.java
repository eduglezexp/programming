package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Declara una variable de tipo boolean que indique si una persona 
 * es mayor de edad (true o false). Asigna un valor y muéstralo por pantalla.
 * @author eduglezexp
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mayorEdad = true;
        try {
            System.out.println("¿Eres mayor de edad? (true or false)");
            mayorEdad = scanner.nextBoolean();
        } catch(InputMismatchException e){
            System.out.println("Error: Debes ingresar true o false.");
        } finally {
            scanner.close();
        }

        if (mayorEdad) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    }
}