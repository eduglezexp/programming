package es.ies.puerto;

import java.util.Scanner;

/**
 * Reto 9: Determinar si un número es positivo, negativo o cero
 * Escribe un programa que reciba un número y determine si es positivo, negativo 
 * o igual a cero.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto9 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce un numero: ");
        int numero = scanner.nextInt();
        System.out.println(averiguarSimbolo(numero));
    }

    public static String averiguarSimbolo(int numero) {
        if (numero < 0) {
            return "Es negativo";
        } else if (numero == 0) {
            return "Es cero";
        } else {
            return "Es positivo";
        }
    }
}
