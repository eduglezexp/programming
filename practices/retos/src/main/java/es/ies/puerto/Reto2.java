package es.ies.puerto;

import java.util.Scanner;

/**
 * Reto 2: Calculadora de impuestos
 * Crea un programa que calcule el impuesto basado en los ingresos anuales ingresados 
 * por el usuario. Si el ingreso es menor a 30,000, no hay impuesto. Si es entre 
 * 30,000 y 100,000, el impuesto es del 10%. Si es mayor a 100,000, el impuesto es 
 * del 20%.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Reto2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce los ingresos anuales: ");
        float ingresosAnuales = scanner.nextFloat();
        float impuestos = 0;
        if (ingresosAnuales < 30000) {
            System.out.println("no hay impuesto");
        } else if (ingresosAnuales < 100000) {
            impuestos = (float) (ingresosAnuales * 0.10);
            System.out.println("Impuestos del 10%, total: " + impuestos);
        } else {
            
        }
    }
}