package es.ies.puerto.ejercicio33;

/**
 * 33. Clase Computadora con Componentes
 * Crea una clase Computadora con atributos marca, modelo y una lista (array) de componentes 
 * (como Procesador, RAM, etc.). Implementa métodos para agregar componentes y usar toString() 
 * para describir la computadora.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Computadora {
    private String marca;
    private String modelo;
    private int numeroComponentes;
    private Componente[] componentes;

    /**
     * Constructor por defecto
     */
    public Computadora() {
        this.numeroComponentes = 0;
        this.componentes = new Componente[5]; 
    }

    /**
     * Constructor con todas las propiedades
     * @param marca
     * @param modelo
     */
    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroComponentes = 0;
        this.componentes = new Componente[5]; 
    }

    /**
     * Metodo para agregar un componente a la lista
     * @param componente 
     * @return true/false
     */
    public boolean addComponente(Componente componente) {
        if (componente == null) {
            return false;
        }
        if (numeroComponentes >= componentes.length) {
            return false;
        }
        componentes[numeroComponentes] = componente;
        numeroComponentes++;  
        return true;
    }

    @Override
    public String toString() {
        String mensaje = "Marca: " +marca+ " Modelo: " +modelo;
        for (int i = 0; i < numeroComponentes; i++) {
            mensaje += componentes[i];
        }
        return mensaje;
    }
}