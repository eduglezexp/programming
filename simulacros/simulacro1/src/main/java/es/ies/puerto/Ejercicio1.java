package es.ies.puerto;

import java.util.Scanner;

/**
 * Crea un programa que solicite un año al usuario y determine si es bisiesto 
 * (divisible por 4, pero no por 100, excepto si es divisible por 400). 
 * Pruebas
 * 2024: Cumple la regla de ser divisible por 4 y no por 100, por lo que es bisiesto.
 * 1900: Aunque es divisible por 4 y 100, al no ser divisible por 400, no es bisiesto.
 * 2000: Al ser divisible por 4, 100 y 400, es bisiesto.
 * 2023: No es divisible por 4, por lo que no es bisiesto.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduzca un año: ");
        int anio = scanner.nextInt();
        System.out.println(findAnioBisiesto(anio));
    }

    public static String findAnioBisiesto(int anio) {
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            return "El año " +anio+ " es bisisesto";
        }
        return "El año " +anio+ " no es bisisesto";
    }
}