package es.ies.puerto.ejercicio49;

/**
 * 49. Clase Escuela con Profesores
 * Crea una clase Escuela que almacene una lista (array) de profesores. 
 * Implementa métodos para agregar y eliminar profesores, y usa toString() 
 * para describir la escuela.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Profesor {
    private String nombre;   
    private String materia;  
    private int anioExperiencia; 

    /**
     * Constructor por defecto
     */
    public Profesor() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param materia
     * @param experiencia
     */
    public Profesor(String nombre, String materia, int experiencia) {
        this.nombre = nombre;
        this.materia = materia;
        this.anioExperiencia = experiencia;
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getAnioExperiencia() {
        return anioExperiencia;
    }

    public void setAnioExperiencia(int experiencia) {
        this.anioExperiencia = experiencia;
    }

    @Override
    public String toString() {
        return "\nProfesor{" +
                "nombre='" + nombre + '\'' +
                ", materia='" + materia + '\'' +
                ", experiencia=" + anioExperiencia +
                '}';
    }
}