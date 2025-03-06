package es.ies.puerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * En una batalla de rol, si el atacante tiene más fuerza que el defensor, 
 * le inflige un daño igual a la diferencia de fuerza. Si no, el defensor 
 * bloquea el ataque. 
 * Crea un programa que reciba las fuerzas de ambos personajes y determine 
 * el daño infligido.
 * @author eduglezexp
 */

public class Ejercicio17 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce la fuerza del atacante: ");
            int fuerzaAtacante = scanner.nextInt();
            System.out.println("Introduce la fuerza del defensor: ");
            int fuerzaDefensor = scanner.nextInt();
            if (fuerzaAtacante > fuerzaDefensor) {
                int diferenciaFuerza = fuerzaAtacante - fuerzaDefensor;
                System.out.println("Daño infligido: " + diferenciaFuerza);
            } else {
                System.out.println("El defensor bloqueo el ataque");
            }
        }catch(InputMismatchException exception) {
            System.out.println("Introduce un numero entero valido para " +
            "la fuerza del atacante y defensor");
        } finally {
            scanner.close();
        }
    }
}
