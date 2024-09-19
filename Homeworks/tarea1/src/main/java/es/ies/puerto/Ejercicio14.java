package es.ies.puerto;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¿Tiene licencia?");
        boolean licencia = scanner.nextBoolean();

        System.out.println("¿Tiene vehiculo?");
        boolean vehiculo = scanner.nextBoolean();

        if (vehiculo) {
            System.out.println("Tiene vehiculo");
        } else {
            System.out.println("No tiene Vehiculo");
        }

        if (licencia) {
            System.out.println("Tiene licencia");
        } else {
            System.out.println("No tiene licencia");
        }

        scanner.close();
    }
}