package es.ies.puerto;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        crearVectorDinamico();
    }

    public static void crearVectorDinamico() {
        Vector<Integer> numeros = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números para agregar al vector (ingrese '0' para terminar):");

        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == 0) {
                break;
            }
            numeros.add(entrada);
        }
        System.out.println("Vector: " + numeros.toString());
        scanner.close();
    }
}