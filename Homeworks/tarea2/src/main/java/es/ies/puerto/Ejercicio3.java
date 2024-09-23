package es.ies.puerto;

/**
 * Escribe un programa que convierta una temperatura en 
 * grados Celsius a Fahrenheit.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {   

        try {
            System.out.println("Introduce grados Celsius para" + 
            " convertirlos a Fahrenheit: ");
            float dCelsius = scanner.nextFloat();
            float dFahrenheit;
            dFahrenheit = ((dCelsius * 9 / 5) + 32);
            System.out.println(dCelsius+ "Celsius, son: " 
            +dFahrenheit+ "Fahrenheit");
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un valor numerico para" +
            " calcular los grados Celsius a Fahrenheit");
        } finally {
            scanner.close();
        }
    }
}