package es.ies.puerto.model.entities;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.1.0
 */

public class PalabraEntitySqlite {
    
    private int id;
    private String palabra;
    private int idNivel;
    
    /**
     * Constructor por defecto
     */
    public PalabraEntitySqlite() {
    }

    /**
     * Constructor con las propiedad identificativa id
     * @param id de la palabra
     */
    public PalabraEntitySqlite(int id) {
        this.id = id;
    }

    /**
     * Constructor con todas las propiedades
     * @param id de la palabra
     * @param palabra de la palabra
     * @param idNivel de la palabra
     */
    public PalabraEntitySqlite(int id, String palabra, int idNivel) {
        this.id = id;
        this.palabra = palabra;
        this.idNivel = idNivel;
    }

    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    @Override
    public String toString() {
        return "PalabraEntitySqlite [id=" + id + ", palabra=" + palabra + ", idNivel=" + idNivel + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PalabraEntitySqlite)) {
            return false;
        }
        PalabraEntitySqlite palabraEntitySqlite = (PalabraEntitySqlite) o;
        return id == palabraEntitySqlite.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}