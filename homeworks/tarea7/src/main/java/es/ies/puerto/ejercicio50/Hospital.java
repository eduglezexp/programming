package es.ies.puerto.ejercicio50;

import es.ies.puerto.ejercicio32.Paciente;

/**
 * 50. Clase Hospital con Médicos y Pacientes
 * Crea una clase Hospital que tenga listas de médicos y pacientes. 
 * Implementa métodos para agregar, eliminar y listar médicos y pacientes, 
 * y usa toString() para mostrar los detalles del hospital.
 * Crea dos array para gestionar los médicos y pacientes.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Hospital {
    private int numeroMedicos;
    private int numeroPacientes;
    private String nombre;
    private Medico[] medicos;
    private Paciente[] pacientes;

    /**
     * Constructor por defecto
     */
    public Hospital() {
        this.numeroMedicos = 0;
        this.numeroPacientes = 0;
        this.medicos = new Medico[10];
        this.pacientes = new Paciente[10]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.numeroMedicos = 0;
        this.numeroPacientes = 0;
        this.medicos = new Medico[10];
        this.pacientes = new Paciente[10]; 
    }

    /**
     * Metodo para agregar un medico al hospital
     * @param medico
     * @return true/false
     */
    public boolean addMedico(Medico medico) {
        if (medico == null || numeroMedicos >= medicos.length) {
            return false;
        }
        medicos[numeroMedicos++] = medico;
        return true;
    }

    /**
     * Metodo para eliminar un medico del hospital
     * @param medico
     * @return true/false
     */
    public boolean deleteMedico(Medico medico) {
        if (medico == null || numeroMedicos == 0) {
            return false;
        }
        for (int i = 0; i < numeroMedicos; i++) {
            if (medicos[i].equals(medico)) {
                medicos[i] = null;
                numeroMedicos--;
                ordenarMedicos();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para agregar un paciente al hospital
     * @param medico
     * @return true/false
     */
    public boolean addPaciente(Paciente paciente) {
        if (paciente == null || numeroPacientes >= pacientes.length) {
            return false;
        }
        pacientes[numeroPacientes++] = paciente;
        return true;
    }

    /**
     * Metodo para eliminar un paciente del hospital
     * @param medico
     * @return true/false
     */
    public boolean deletePaciente(Paciente paciente) {
        if (paciente == null || numeroPacientes == 0) {
            return false;
        }
        for (int i = 0; i < numeroPacientes; i++) {
            if (pacientes[i].equals(paciente)) {
                pacientes[i] = null;
                numeroPacientes--;
                ordenarPacientes();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista de medicos despues de una eliminacion
     */
    private void ordenarMedicos() {
        int index = 0;
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null) {
                medicos[index++] = medicos[i];
            }
        }
        while (index < medicos.length) {
            medicos[index++] = null;
        }
    }

    /**
     * Metodo para ordenar la lista de pacientes despues de una eliminacion
     */
    private void ordenarPacientes() {
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
        String mensajeMedicos = "Hospital: " + nombre;
        for (int i = 0; i < numeroMedicos; i++) {
            mensajeMedicos += medicos[i];
        }
        String mensajePacientes = "";
        for (int i = 0; i < numeroPacientes; i++) {
            mensajePacientes += pacientes[i];
        }
        return mensajeMedicos + mensajePacientes;
    }
}