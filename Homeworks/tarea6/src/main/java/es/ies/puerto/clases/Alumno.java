package es.ies.puerto.clases;

/**
 * Ejercicio 13
 * Crea una clase Alumno con los atributos nombre y nota. 
 * Implementa un método que determine si el alumno ha aprobado (nota >= 6).
 * Ejercicio 14
 * Modifica la clase Alumno para que la nota no pueda ser mayor a 10 
 * ni menor a 0 en el setter.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Alumno {
    private String nombre;
    private float nota;
    
    /**
     * Constructor por defecto
     */
    public Alumno() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre del alumno
     * @param nota del alumno
     */
    public Alumno(String nombre, float nota) {
        this.nombre = nombre;
        setNota(nota);
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        if (nota < 0 || nota > 10 ) {
            this.nota = 0;
        } else {
            this.nota = nota;
        }
    }

    public String aprobar() {
        if (nota >= 6) {
            return "Aprobado/a, nota: " +nota;
        }
        return "Suspendido/a, nota: " +nota;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", nota=" + nota + "]";
    }
}