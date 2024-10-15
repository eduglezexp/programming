package es.ies.puerto;

/**
 * Ejercicio 13
 * Crea una clase Alumno con los atributos nombre y nota. 
 * Implementa un método que determine si el alumno ha aprobado (nota >= 6).
 * Instancia y uso de la clase
 * Crea un objeto de la clase Alumno con nombre "Lucía" y nota 7. 
 * Determina si el alumno ha aprobado.
 * Ejercicio 14
 * Modifica la clase Alumno para que la nota no pueda ser mayor a 10 
 * ni menor a 0 en el setter.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Alumno con nombre "Jorge" y nota 11. 
 * Asegúrate de que la nota no pueda ser mayor que 10 ni menor que 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Alumno {
    private String nombre;
    private float nota;
    
    public Alumno() {
    }

    public Alumno(String nombre, float nota) {
        this.nombre = nombre;
        setNota(nota);
    }

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

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Lucia", 7);
        String aprobar = alumno1.aprobar();
        System.out.println(aprobar);     
        Alumno alumno2 = new Alumno("Jorge", 11);
        System.out.println(alumno2);  
    }
}