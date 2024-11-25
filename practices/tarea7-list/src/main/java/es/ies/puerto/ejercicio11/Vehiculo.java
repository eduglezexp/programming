package es.ies.puerto.ejercicio11;

import java.util.Objects;

/**
 * 11. Clase Vehículo
 * Define una clase base Vehiculo con atributos marca y modelo. 
 * Usa toString() para describir el vehículo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Vehiculo {
    private String marca;
    private String modelo;
    private String matricula;

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Constructor con la propiedad matricula
     * @param matricula
     */
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Constructor con las propiedades marca y modelo 
     * @param marca
     * @param modelo
     */
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Constructor con todas las propiedades
     * @param marca
     * @param modelo
     */
    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    /**
     * Getters and Setters
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
    
    @Override
    public String toString() {
        return "\n{" +
            " marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", matricula='" + getMatricula() + "'" +
            "}";
    }
}