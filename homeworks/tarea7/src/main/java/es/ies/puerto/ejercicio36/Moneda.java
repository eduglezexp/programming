package es.ies.puerto.ejercicio36;

/**
 * 36. Clase Colección de Monedas
 * Crea una clase ColeccionMonedas que almacene una lista (array) de monedas (clase Moneda). 
 * Implementa métodos para agregar monedas y listar todas las monedas. 
 * Usa toString() para mostrar detalles de la colección.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Moneda {
    private String nombre;
    private float valor; 
    private String pais;

    /**
     * Constructor por defecto
     */
    public Moneda() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param valor
     * @param pais
     */
    public Moneda(String nombre, float valor, String pais) {
        this.nombre = nombre;
        this.valor = valor;
        this.pais = pais;
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "\nMoneda [nombre=" + nombre + ", valor=" + valor + ", pais=" + pais + "]";
    }
}