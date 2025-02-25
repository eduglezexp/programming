package es.file.json.dos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Tributo {
    private int id;
    private String nombre;
    private int distrito;
    private boolean voluntario;
    private String fechaSeleccion;
    
    /**
     * Constructor por defecto
     */
    public Tributo() {
    }

    /**
     * Constructor con todas las propiedades 
     * @param id del atributo 
     * @param nombre del atributo
     * @param distrito del atributo
     * @param voluntario del atributo
     * @param fechaSeleccion del atributo
     */
    @JsonCreator
    public Tributo(@JsonProperty("id") int id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("distrito") int distrito,
                   @JsonProperty("voluntario") boolean voluntario,
                   @JsonProperty("fechaSeleccion") String fechaSeleccion) {
        this.id = id;
        this.nombre = nombre;
        this.distrito = distrito;
        this.voluntario = voluntario;
        this.fechaSeleccion = fechaSeleccion;
    }

    /**
     * Constructor con la propiedad id 
     * @param id
     */
    public Tributo(@JsonProperty("id") int id) {
        this.id = id;
    }

    /**
     * Constructor por defecto
     */
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getDistrito() {
        return this.distrito;
    }

    public boolean getVoluntario() {
        return this.voluntario;
    }

    public boolean isVoluntario() {
        return this.voluntario;
    }

    public String getFechaSeleccion() {
        return this.fechaSeleccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public void setVoluntario(boolean voluntario) {
        this.voluntario = voluntario;
    }

    public void setFechaSeleccion(String fechaSeleccion) {
        this.fechaSeleccion = fechaSeleccion;
    }

    @Override
    public String toString() {
        return "Tributo [id=" + id + ", nombre=" + nombre + ", distrito=" + distrito + ", voluntario=" + voluntario
                + ", fechaSeleccion=" + fechaSeleccion + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tributo)) {
            return false;
        }
        Tributo tributo = (Tributo) o;
        return Objects.equals(id, tributo.id);
    }
}