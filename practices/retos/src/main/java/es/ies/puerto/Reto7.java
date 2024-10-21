package es.ies.puerto;

import java.util.Scanner;

/**
 * Reto 7: Clasificación de notas
 * Escribe un programa que solicite una calificación y la clasifique en "Aprobado" 
 * o "Reprobado". Si la calificación es mayor o igual a 60, está aprobada; si es 
 * menor, está reprobada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto7 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("Introduce una calificacion: ");
            int calificacion = scanner.nextInt();
            System.out.println(calificarNotas(calificacion));
        } catch (Exception exception) {
            System.out.println("Introduce un tipo de dato numerico");
        } finally {
            scanner.close();
        }
    }

    public static String calificarNotas(int calificacion) {
        if (calificacion >= 60) {
            return "Aprobado";
        } else {
            return "Suspendido";
        }
    }
}
