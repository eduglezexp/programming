package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Alumno;

/**
 * Crea un objeto de la clase Alumno con nombre "Lucía" y nota 7. 
 * Determina si el alumno ha aprobado.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio13 {
    static Alumno alumno;
    public static void main(String[] args) {
        alumno = new Alumno("Lucia", 7);
        String aprobar = alumno.aprobar();
        System.out.println(aprobar);     
    }
}
