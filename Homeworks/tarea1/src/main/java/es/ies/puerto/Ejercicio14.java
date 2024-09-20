package es.ies.puerto;

/**
 * Declara dos variables de tipo boolean: una que indique si una persona tiene licencia 
 * de conducir y otra si posee un vehículo. Muestra ambas variables.
 * @author eduglezexp
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean licencia = true;
        boolean vehiculo = true;

        try {
            System.out.println("¿Tiene licencia? (true or false)");
            licencia = scanner.nextBoolean();
    
            System.out.println("¿Tiene vehiculo? (true or false)");
            vehiculo = scanner.nextBoolean();
        } catch(InputMismatchException e) {
            System.out.println("Error: Debes ingresar true o false.");
        } finally {
            scanner.close();
        }

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
    }
}