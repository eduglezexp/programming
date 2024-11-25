package es.ies.puerto.ejercicio41;

import es.ies.puerto.ejercicio6.Estudiante;

/**
 * 41. Clase Colegio con Estudiantes
 * Crea una clase Colegio que almacene una lista (array) de estudiantes. 
 * Implementa métodos para agregar y eliminar estudiantes, y usa toString() 
 * para mostrar los detalles del colegio.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Colegio {
    private int numeroEstudiantes;
    private String nombre;
    private Estudiante[] estudiantes;

    /**
     * Constructor por defecto
     */
    public Colegio() {
        this.numeroEstudiantes = 0;
        this.estudiantes = new Estudiante[10];
    }

    /**
     * Constructor con el nombre del colegio
     * @param nombre
     */
    public Colegio(String nombre) {
        this.nombre = nombre;
        this.numeroEstudiantes = 0;
        this.estudiantes = new Estudiante[10];
    }

    /**
     * Método para agregar un estudiante al colegio
     * @param estudiante
     * @return true/false
     */
    public boolean addEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            return false;
        }
        if (numeroEstudiantes >= estudiantes.length) {
            return false;
        }
        estudiantes[numeroEstudiantes] = estudiante;
        numeroEstudiantes++;
        return true;
    }

    /**
     * Metodo para eliminar un estudiante del colegio
     * @param estudiante
     * @return true/false
     */
    public boolean deleteEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            return false;
        }
        if (numeroEstudiantes == 0) {
            return false;
        }
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiante.equals(estudiantes[i])) {
                estudiantes[i] = null;
                numeroEstudiantes--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un estudiante
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null) {
                estudiantes[index++] = estudiantes[i];
            }
        }
        while (index < estudiantes.length) {
            estudiantes[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroEstudiantes; i++) {
            mensaje += estudiantes[i];
        }
        return mensaje;
    }
}