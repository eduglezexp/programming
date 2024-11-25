package es.ies.puerto.ejercicio32;

/**
 * 32. Clase Hospital con Pacientes
 * Crea una clase Hospital que almacene una lista (array) (array) de pacientes (clase Paciente).
 * Implementa métodos para agregar, eliminar y listar pacientes. 
 * Usa toString() para describir el hospital.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Hospital {
    private int numeroPacientes;
    private String nombre;
    private Paciente[] pacientes;

    /**
     * Constructor por defecto
     */
    public Hospital() {
        this.numeroPacientes = 0;
        this.pacientes = new Paciente[10];
    }

    /**
     * Constructor con las propiedad nombre
     * @param nombre
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.numeroPacientes = 0;
        this.pacientes = new Paciente[10];
    }

    /**
     * Metodo para agregar un paciente a la lista
     * @param paciente 
     * @return true/false
     */
    public boolean addPaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }
        if (numeroPacientes >= pacientes.length) {
            return false;
        }
        pacientes[numeroPacientes] = paciente;
        numeroPacientes++;  
        return true;
    }

    /**
     * Metodo para eliminar un paciente
     * @param paciente
     * @return true/false
     */
    public boolean deletePaciente(Paciente paciente) {
        if (paciente == null) {
            return false;
        }
        if (numeroPacientes == 0) {
            return false;
        }
        for (int i = 0; i < pacientes.length; i++) {
            if (paciente.equals(pacientes[i])) {
                pacientes[i] = null;
                numeroPacientes--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar una cancion
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                pacientes[index++] = pacientes[i];
            }
        }
        while (index < pacientes.length) {
            pacientes[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroPacientes; i++) {
            mensaje += pacientes[i];
        }
        return mensaje;
    }
}