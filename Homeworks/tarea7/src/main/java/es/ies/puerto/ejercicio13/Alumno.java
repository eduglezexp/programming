package es.ies.puerto.ejercicio13;
import java.util.Objects;
/**
 * 13. Clase Alumno con Métodos para Notas
 * Crea una clase Alumno con los atributos nombre, notaMatematicas, notaCiencias y 
 * notaProgramacion. Implementa un método promedio() y usa equals() para comparar alumnos 
 * por sus notas.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Alumno {
    private String nombre;
    private int notaMatematicas;
    private int notaCiencias;
    private int notaProgramacion;

    
    /**
     * Constructor por defecto
     */
    public Alumno() {
    }

    /**
     * Constructor con todas las propiedades 
     * @param nombre
     * @param notaMatematicas
     * @param notaCiencias
     * @param notaProgramacion
     */
    public Alumno(String nombre, int notaMatematicas, int notaCiencias, int notaProgramacion) {
        this.nombre = nombre;
        this.notaMatematicas = notaMatematicas;
        this.notaCiencias = notaCiencias;
        this.notaProgramacion = notaProgramacion;
    }

    /**
     * Metodo para calcular el promedio de las notas
     * @return un float del promedio de las notas
     */
    public float promedio() {
        return (notaMatematicas + notaCiencias + notaProgramacion) / 3; 
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", notaMatematicas=" + notaMatematicas + ", notaCiencias=" + notaCiencias
                + ", notaProgramacion=" + notaProgramacion + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return notaMatematicas == alumno.notaMatematicas && notaCiencias == alumno.notaCiencias && notaProgramacion == alumno.notaProgramacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(notaMatematicas, notaCiencias, notaProgramacion);
    }
}