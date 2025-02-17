package es.ies.puerto.file.dos;

import java.util.List;
import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */
public class Pokemon {

    private String id;
    private String nombre;
    private List<String> tipos;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public Pokemon() {
    }

    /**
     * Constructor con la propiedad id
     * @param id del Pokémon
     */
    public Pokemon(String id) {
        this.id = id;
    }

    /**
     * Constructor con todas las propiedades
     * @param id del Pokémon
     * @param nombre del Pokémon
     * @param tipos del Pokémon
     * @param descripcion del Pokémon
     */
    public Pokemon(String id, String nombre, List<String> tipos, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipos = tipos;
        this.descripcion = descripcion;
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

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipos=" + tipos + ", descripcion=" + descripcion + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}