package es.ies.puerto.ejercicio3;

/**
 * Define la clase Coche con atributos marca, modelo, año y velocidad. Incluye métodos
 * acelerar() y frenar(), que modifiquen la velocidad. Usa getters y setters para 
 * controlar el acceso a los atributos.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Coche {
    private String marca;
    private String modelo;
    private int anio;

    /**
     * Constructor por defecto 
     */
    public Coche() {
    }

    /**
     * Constructor con todas las propiedades
     * @param marca
     * @param modelo
     * @param anio
     */
    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }   
}
