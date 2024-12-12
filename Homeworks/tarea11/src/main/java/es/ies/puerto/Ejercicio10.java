package es.ies.puerto;

import java.util.Vector;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        Vector<Float> calificaciones = new Vector<>();
        calificaciones.add(80.0f);
        calificaciones.add(90.0f);
        calificaciones.add(70.0f);
        calcularPromedio(calificaciones);
        System.out.println("Calificaciones: " + calificaciones);
        float promedio = calcularPromedio(calificaciones);
        System.out.println("Promedio: " + promedio);
    }

    /**
     * Metodo para calcular el promedio dado un vector
     * @param calificaciones
     * @return promedio del vector
     */
    public static float calcularPromedio(Vector<Float> calificaciones) {
        float suma = 0;
        for (int i = 0; i < calificaciones.size(); i++) {
            suma += calificaciones.get(i);
        }
        return suma / calificaciones.size();
    }
}