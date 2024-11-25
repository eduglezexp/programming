package es.ies.puerto.ejercicio11;

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

    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param marca
     * @param modelo
     */
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
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

    @Override
    public String toString() {
        return "\nVehiculo [marca=" + marca + ", modelo=" + modelo + "]";
    }
}
