package es.ies.puerto;

/**
 * Crea un programa que pida al usuario las horas trabajadas 
 * y el salario por hora, y luego calcule su salario semanal.
 * @author eduglezexp
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio7 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Introduce las horas trabajadas en la semana: ");
            float horasTrabajdas = scanner.nextFloat();

            System.out.println("Introduce el salario por hora: ");
            float salarioHora = scanner.nextFloat();
            if (horasTrabajdas < 0 || salarioHora < 0) {
                System.out.println("¡No puedes trabajar en horas negativas y/o tener un " + 
                "salario negativo!");
            } else if (horasTrabajdas <= 168) {
                float salarioSemanal = horasTrabajdas * salarioHora;
                System.out.println("El salario semanal es de " +salarioSemanal+ " euros");
            } else {
                System.out.println("¡Imposible trabajar " +horasTrabajdas+ " a las semana!");
            }

        } catch(InputMismatchException exception) {
            System.out.println("Introduce correctamente las horas trabajadas " +
            "a la semana y el salario por hora");
        } finally {
            scanner.close();
        }
    }
}
