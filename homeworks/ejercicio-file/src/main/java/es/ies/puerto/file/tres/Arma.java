package es.ies.puerto.file.tres;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */
public class Arma {
    private String id;
    private String nombre;
    private String descripcion;
    private String origen;
    private int fuerza;

    /**
     * Constructor por defecto
     */
    public Arma() {
    }

    /**
     * Constructor con la propiedad id
     * @param id del arma
     */
    public Arma(String id) {
        this.id = id;
    }

    /**
     * Constructor con todas las propiedades
     * @param id del arma
     * @param nombre del arma
     * @param descripcion del arma
     * @param origen del arma
     * @param fuerza del arma
     */
    public Arma(String id, String nombre, String descripcion, String origen, int fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.origen = origen;
        this.fuerza = fuerza;
    }

    /**
     * Getters and Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + descripcion + "," + origen + "," + fuerza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arma)) return false;
        Arma arma = (Arma) o;
        return Objects.equals(id, arma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}