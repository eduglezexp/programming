package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Alumno;

/**
 * Crea un objeto de la clase Alumno con nombre "Jorge" y nota 11. 
 * Asegúrate de que la nota no pueda ser mayor que 10 ni menor que 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    static Alumno alumno;
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Jorge", 11);
        System.out.println(alumno);  
    }
}
