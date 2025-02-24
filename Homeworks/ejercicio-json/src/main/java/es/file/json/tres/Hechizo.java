package es.file.json.tres;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hechizo {
    private int id;
    private String nombre;
    private String tipo;
    private boolean esOscuro;
    private String fechaCreacion;

    /**
     * Constructor por defecto
     */
    public Hechizo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param id del hechizo
     * @param nombre del hechizo
     * @param tipo del hechizo
     * @param esOscuro del hechizo
     * @param fechaCreacion del hechizo
     */
    @JsonCreator
    public Hechizo(@JsonProperty("id") int id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("tipo") String tipo,
                   @JsonProperty("esOscuro") boolean esOscuro,
                   @JsonProperty("fechaCreacion") String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.esOscuro = esOscuro;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Constructor con la propiedad id 
     * @param id
     */
    public Hechizo(@JsonProperty("id") int id) {
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

    public String getTipo() {
        return this.tipo;
    }

    public boolean getEsOscuro() {
        return this.esOscuro;
    }

    public boolean isEsOscuro() {
        return this.esOscuro;
    }

    public String getFechaCreacion() {
        return this.fechaCreacion;
    }

    @Override
    public String toString() {
        return "Hechizo [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", esOscuro=" + esOscuro
                + ", fechaCreacion=" + fechaCreacion + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Hechizo)) {
            return false;
        }
        Hechizo hechizo = (Hechizo) o;
        return Objects.equals(id, hechizo.id);
    }
}