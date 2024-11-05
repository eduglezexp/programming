package es.ies.puerto.ejercicio32;

/**
 * 32. Clase Hospital con Pacientes
 * Crea una clase Hospital que almacene una lista (array) (array) de pacientes (clase Paciente).
 * Implementa métodos para agregar, eliminar y listar pacientes. 
 * Usa toString() para describir el hospital.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio32 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Hospital General");
        Paciente paciente1 = new Paciente("Juan Pérez", 30, "P001");
        Paciente paciente2 = new Paciente("María Gómez", 25, "P002");
        Paciente paciente3 = new Paciente("Carlos Sánchez", 40, "P003");
        hospital.addPaciente(paciente1);
        hospital.addPaciente(paciente2);
        hospital.addPaciente(paciente3);
        System.out.println("Antes de eliminar:");
        System.out.println(hospital);
        hospital.deletePaciente(paciente2);
        System.out.println("Despues de eliminar:");
        System.out.println(hospital);
    }
}
