package es.ies.puerto.model.entities;

import java.util.Objects;

public class PalabraEntitySqlite {
    
    private int id;
    private String palabra;
    private int idNivel;
    
    public PalabraEntitySqlite() {
    }

    public PalabraEntitySqlite(int id) {
        this.id = id;
    }

    public PalabraEntitySqlite(int id, String palabra, int idNivel) {
        this.id = id;
        this.palabra = palabra;
        this.idNivel = idNivel;
    }

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