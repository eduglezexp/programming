package es.ies.puerto.ejercicio41;

import es.ies.puerto.ejercicio6.Estudiante;

/**
 * 41. Clase Colegio con Estudiantes
 * Crea una clase Colegio que almacene una lista (array) de estudiantes. 
 * Implementa métodos para agregar y eliminar estudiantes, y usa toString() 
 * para mostrar los detalles del colegio.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio41 {
public static void main(String[] args) {
        Colegio colegio = new Colegio("Colegio1");
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "B0690", 10);
        Estudiante estudiante2 = new Estudiante("Ana García", "B0798", 8);
        Estudiante estudiante3 = new Estudiante("Luis López", "B0087", 7);
        colegio.addEstudiante(estudiante1);
        colegio.addEstudiante(estudiante2);
        colegio.addEstudiante(estudiante3);
        System.out.println(colegio);
        colegio.deleteEstudiante(estudiante2);
        System.out.println("\nContenido del colegio despues de eliminar un estudiante:");
        System.out.println(colegio);
    }
}
