package es.ies.puerto;

/**
 * Ejercicio 3
 * Crea una clase Coche con los atributos marca, modelo y año. 
 * Incluye un constructor y métodos getter y setter para cada atributo.
 * Ejercicio 4
 * Modifica la clase Coche para que el setter del atributo año solo permita 
 * valores mayores o iguales a 1886 (año de creación del primer coche).
 * @author eduglezexp
 * @version 1.0.0
 */

public class Coche {
    private String marca;
    private String modelo;
    private int anio;

    public Coche() {

    }

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        setAnio(anio);
    }

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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio <= 1886) {
            this.anio = 1886;
        }
        this.anio = anio;
    }    
}