package es.ies.puerto.ejercicio6;

/**
 * 6. Clase Estudiante con Getters y Setters
 * Crea una clase Estudiante con atributos privados nombre, matricula y calificacion. 
 * Proporciona getters y setters para acceder a estos valores y un método toString() 
 * para mostrar la información.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Estudiante {
    private String nombre;
    private String matricula;
    private int calificacion;

    /**
     * Constructor por defecto
     */
    public Estudiante() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre del estuadiante
     * @param matricula del estuadiante
     * @param calificacion del estuadiante
     */
    public Estudiante(String nombre, String matricula, int calificacion) {
        this.nombre = nombre;
        this.matricula = matricula;
        setCalificacion(calificacion);
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        }
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", matricula=" + matricula + ", calificacion=" + calificacion + "]";
    }
}
