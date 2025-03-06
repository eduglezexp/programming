package es.ies.puerto;

import java.time.LocalDate;

/**
 * Declara una variable int que contenga tu año de
 * nacimiento. Calcula y muestra tu edad actual
 * utilizando otra variable para el año actual.
 * 
 * @author eduglezexp
 */

public class Ejercicio9 {
    public static void main(String[] args) {
        int anioNacimiento = 2004;
        int anioActual = LocalDate.now().getYear();
        int edad = anioActual - anioNacimiento;

        System.out.println("La edad es: " +edad);
    }
}