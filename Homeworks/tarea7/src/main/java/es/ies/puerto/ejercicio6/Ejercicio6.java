package es.ies.puerto.ejercicio6;

/**
 * 6. Clase Estudiante con Getters y Setters
 * Crea una clase Estudiante con atributos privados nombre, matricula y calificacion. 
 * Proporciona getters y setters para acceder a estos valores y un método toString() 
 * para mostrar la información.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Ana Pérez", "A12345", 8);
        System.out.println(estudiante1);
        estudiante1.setNombre("Carlos García");
        estudiante1.setCalificacion(9);
        System.out.println(estudiante1); 
    }
}
