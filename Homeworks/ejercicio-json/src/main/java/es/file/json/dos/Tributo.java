package es.file.json.dos;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

    public LocalDate getFechaAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fechaSeleccion, formatter);
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