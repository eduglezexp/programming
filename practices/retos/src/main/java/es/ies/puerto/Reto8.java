package es.ies.puerto;

import java.util.Scanner;

/**
 * Reto 8: Verificar si un año es bisiesto
 * Crea un programa que solicite un año al usuario y determine si es bisiesto 
 * (divisible por 4, pero no por 100, excepto si es divisible por 400).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto8 {
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
