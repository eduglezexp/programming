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

public class Ejercicio50 {
    public static void main(String[] args) {
        Medico medico1 = new Medico("Dr. Pérez", "Cardiología", 15);
        Medico medico2 = new Medico("Dra. López", "Neurología", 10);
        Paciente paciente1 = new Paciente("Juan García", 65, "01");
        Paciente paciente2 = new Paciente("Marta Rivera", 45, "02");
        Hospital hospital = new Hospital("Hospital 1");
        hospital.addMedico(medico1);
        hospital.addMedico(medico2);
        hospital.addPaciente(paciente1);
        hospital.addPaciente(paciente2);
        System.out.println(hospital);
        hospital.deleteMedico(medico2);
        hospital.deletePaciente(paciente1);
        System.out.println("\nDespues de eliminar un medico y un paciente:");
        System.out.println(hospital);
    }
}