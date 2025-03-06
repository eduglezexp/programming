package es.ies.puerto.ejercicio13;

/**
 * 13. Clase Alumno con Métodos para Notas
 * Crea una clase Alumno con los atributos nombre, notaMatematicas, notaCiencias y 
 * notaProgramacion. Implementa un método promedio() y usa equals() para comparar alumnos 
 * por sus notas.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Juan", 85, 90, 80);
        Alumno alumno2 = new Alumno("Ana", 85, 90, 80);
        Alumno alumno3 = new Alumno("Luis", 70, 75, 80);

        System.out.println("Alumno 1: " + alumno1);
        System.out.println("Alumno 2: " + alumno2);
        System.out.println("Alumno 3: " + alumno3);

        System.out.println("¿Alumno 1 y Alumno 2 tienen las mismas notas? " + alumno1.equals(alumno2));
        System.out.println("¿Alumno 1 y Alumno 3 tienen las mismas notas? " + alumno1.equals(alumno3));
    }
}