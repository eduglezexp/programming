package es.file.json.uno;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Caballero {
    private int id;
    private String nombre;
    private String constelacion;
    private int nivel;
    private String fechaIngreso;

    /**
     * Constructor por defecto
     */
    public Caballero() {
    }
    
    /**
     * Constructor con todas las propiedades
     * @param id del caballero
     * @param nombre del caballero
     * @param constelacion del caballero
     * @param nivel del caballero
     * @param fechaIngreso del caballero
     */
    @JsonCreator
    public Caballero(@JsonProperty("id") int id,
                     @JsonProperty("nombre") String nombre,
                     @JsonProperty("constelacion") String constelacion,
                     @JsonProperty("nivel") int nivel,
                     @JsonProperty("fechaIngreso") String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.constelacion = constelacion;
        this.nivel = nivel;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Constructor con la propiedad id 
     * @param id
     */
    public Caballero(@JsonProperty("id") int id) {
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

    public String getConstelacion() {
        return this.constelacion;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Override
    public String toString() {
        return "Caballero [id=" + id + ", nombre=" + nombre + ", constelacion=" + constelacion + ", nivel=" + nivel
                + ", fechaIngreso=" + fechaIngreso + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caballero)) {
            return false;
        }
        Caballero caballero = (Caballero) o;
        return Objects.equals(id, caballero.id);
    }
}