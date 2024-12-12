package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        calcularPromedio();
    }

    public static void calcularPromedio() {
        Vector<Double> calificaciones = new Vector<>();
        calificaciones.add(80.0);
        calificaciones.add(90.0);
        calificaciones.add(70.0);
        double suma = 0;
        for (int i = 0; i < calificaciones.size(); i++) {
            suma += calificaciones.get(i);
        }
        double promedio = suma / calificaciones.size();
        System.out.println("Calificaciones: " + calificaciones);
        System.out.println("Promedio: " + promedio);
    }
}