package es.ies.puerto.modelo.db.entidades;

import java.util.Date;
import java.util.Objects;

import es.ies.puerto.modelo.db.entidades.abstractas.AbstractEntity;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Autor extends AbstractEntity{
    private String dni;
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    
    /**
     * Constructor por defecto
     */
    public Autor() {}

    /*
     * Constructor con la propiedad dni
     */
    public Autor(String dni) {
        this.dni = dni;
    }

    public Autor(String dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Constructor con todas las propiedades
     */
    public Autor(String dni, String nombre, String nacionalidad, Date fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getters and Setters
     */
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getFechaNacimiento() { 
        return getFecha(fechaNacimiento);
    }

    public void setFechaNacimiento(Date fechaNacimiento) { 
        this.fechaNacimiento = fechaNacimiento; 
    }

    @Override
    public String toString() {
        return "Autor [dni=" + dni + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", fechaNacimiento="
        + fechaNacimiento + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Autor)) {
            return false;
        }
        Autor autor = (Autor) o;
        return Objects.equals(dni, autor.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}