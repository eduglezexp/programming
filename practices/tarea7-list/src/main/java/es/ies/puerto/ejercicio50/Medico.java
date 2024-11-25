package es.ies.puerto.ejercicio50;

/**
 * 50. Clase Hospital con Médicos y Pacientes
 * Crea una clase Hospital que tenga listas de médicos y pacientes. 
 * Implementa métodos para agregar, eliminar y listar médicos y pacientes, 
 * y usa toString() para mostrar los detalles del hospital.
 * Crea dos array para gestionar los médicos y pacientes.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Medico {
    private String nombre;
    private String especialidad;
    private int aniosExperiencia;

    /**
     * Constructor por defecto
     */
    public Medico() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param especialidad
     * @param aniosExperiencia
     */
    public Medico(String nombre, String especialidad, int aniosExperiencia) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "\nMedico{nombre='" + nombre + "', especialidad='" + especialidad + "', años de experiencia=" + aniosExperiencia + "}";
    }
}