package es.ies.puerto.clases;

/**
 * Ejercicio 17
 * Crea una clase Vehiculo con los atributos marca, modelo y combustible. 
 * Define un método que permita agregar combustible al vehículo.
 * Ejercicio 18
 * Modifica la clase Vehiculo para que el setter de combustible no permita 
 * valores negativos.
 * @author eduglezexp
 * @version 1.0.0
*/

public class Vehiculo {
    private String marca;
    private String modelo;
    private int combustible;
    
    /**
     * Constructor por defecto
     */
    public Vehiculo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param marca del vehiculo
     * @param modelo del vehiculo
     * @param combustible del vehiculo
     */
    public Vehiculo(String marca, String modelo, int combustible) {
        this.marca = marca;
        this.modelo = modelo;
        setCombustible(combustible);
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

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        if (combustible > 0) {
            this.combustible = combustible;
        }
    }

    public String agregarCombustible(int cantidad) {
        int total = combustible += cantidad;
        return "Combustible actual: " +total+ " Litros";
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", combustible=" + combustible + "]";
    }
}