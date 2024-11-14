package es.ies.examen;

import java.util.Objects;

public class Friki {
    private int identificador;
    private String nombre;
    private int nivelFrikismo;
    private String especialidad;

    /**
     * Constructor por defecto
     */
    public Friki() {
    }
    
    /**
     * Constructor con todas las propiedades
     * @param identificador
     * @param nombre
     * @param nivelFrikismo
     * @param especialidad
     */
    public Friki(int identificador, String nombre, int nivelFrikismo, String especialidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.nivelFrikismo = nivelFrikismo;
        this.especialidad = especialidad;
    }

    /**
     * Getters and Setters
     */
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelFrikismo() {
        return nivelFrikismo;
    }

    public void setNivelFrikismo(int nivelFrikismo) {
        this.nivelFrikismo = nivelFrikismo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "Friki{" +
            "identificador='" + getIdentificador() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", nivelFrikismo='" + getNivelFrikismo() + "'" +
            ", especialidad='" + getEspecialidad() + "'" +
            "}";
    }    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Friki)) {
            return false;
        }
        Friki friki = (Friki) o;
        return identificador == friki.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
}