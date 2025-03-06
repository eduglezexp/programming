package es.ies.puerto;

import java.util.Scanner;

/**
 * Cada día de la semana en tu nave espacial hay una actividad diferente. 
 * Los lunes entrenas combate, los miércoles pilotaje, y los viernes reparaciones. 
 * El resto de días descansas.
 * Crea un programa que pida el día de la semana y te diga cuál es la actividad programada.
 * @author eduglezexp
 */

public class Ejercicio3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca el dia de la semana: ");
        String diaSemana = scanner.nextLine();
        diaSemana = diaSemana.toLowerCase();

        switch (diaSemana) {
            case "lunes":
                System.out.println("Hoy entrenas combate.");
                break;
            case "miercoles": 
                System.out.println("Hoy entrenas pilotaje.");
                break;
            case "viernes":
                System.out.println("Hoy entrenas reparaciones.");
                break;
            case "martes":
            case "jueves":
            case "sábado":
            case "sabado":
            case "domingo":
                System.out.println("Hoy descansas.");
                break;
            default:
                System.out.println("Día no válido. Por favor, introduce un día de la semana.");
                break;
        }
        scanner.close();
    }
}
