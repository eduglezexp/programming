package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Crea un array que represente la salud de 5 dragones. Cada vez que el usuario 
 * introduzca un número, resta esa cantidad de salud a un dragón al azar. 
 * El juego termina cuando la salud de todos los dragones es cero o menos.
 * @author eduglezexp
 */

public class Ejercicio8 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        int[] saludDragones = {45, 23, 42, 67, 102};
        try {
        //do {
            System.out.println("Introduce un daño: ");
            int danio = scanner.nextInt();
            int i = random.nextInt(saludDragones.length - 1);
            saludDragones[i] = saludDragones[i] - danio;
            
        //} while ();
        } catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido");
        } finally {
            scanner.close();
        }
    }
}
