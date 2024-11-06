package es.ies.puerto.ejercicio49;

/**
 * 49. Clase Escuela con Profesores
 * Crea una clase Escuela que almacene una lista (array) de profesores. 
 * Implementa métodos para agregar y eliminar profesores, y usa toString() 
 * para describir la escuela.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Escuela {
    private int numeroProfesores; 
    private String nombre;
    private Profesor[] profesores; 

    /**
     * Constructor por defecto
     */
    public Escuela() {
        this.numeroProfesores = 0;
        this.profesores = new Profesor[10];
    }

    /**
     * Constructor con la propiedad nombre
     */
    public Escuela(String nombre) {
        this.nombre = nombre;
        this.numeroProfesores = 0;
        this.profesores = new Profesor[10]; 
    }

    /**
     * Metodo para agregar una profesor a la escuela
     * @param profesor
     * @return true/false
     */
    public boolean addProfesor(Profesor profesor) {
        if (profesor == null) {
            return false; 
        }
        if (numeroProfesores >= profesores.length) {
            return false; 
        }
        profesores[numeroProfesores] = profesor;
        numeroProfesores++;
        return true;
    }

    /**
     * Metodo para eliminar una profesor de la escuela
     * @param profesor
     * @return true/false
     */
    public boolean deleteProfesor(Profesor profesor) {
        if (profesor == null) {
            return false;
        }
        if (numeroProfesores == 0) {
            return false; 
        }
        for (int i = 0; i < profesores.length; i++) {
            if (profesor.equals(profesores[i])) {
                profesores[i] = null;
                numeroProfesores--;
                ordenarLista();
                return true;
            }
        }
        return false; 
    }

    /**
     * Metodo para ordenar la lista de profesores despues de una eliminacion
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < profesores.length; i++) {
            if (profesores[i] != null) {
                profesores[index++] = profesores[i];
            }
        }
        while (index < profesores.length) {
            profesores[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " + nombre;
        for (int i = 0; i < numeroProfesores; i++) {
            mensaje += profesores[i];
        }
        return mensaje;
    }
}