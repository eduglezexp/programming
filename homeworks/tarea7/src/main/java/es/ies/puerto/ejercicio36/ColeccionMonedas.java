package es.ies.puerto.ejercicio36;

/**
 * 36. Clase Colección de Monedas
 * Crea una clase ColeccionMonedas que almacene una lista (array) de monedas (clase Moneda). 
 * Implementa métodos para agregar monedas y listar todas las monedas. 
 * Usa toString() para mostrar detalles de la colección.
 * @author eduglezexp
 * @version 1.0.0
 */

public class ColeccionMonedas {
    private int numeroMonedas;
    private String nombre;
    private Moneda[] monedas;

    /**
     * Constructor por defecto
     */
    public ColeccionMonedas() {
        this.numeroMonedas = 0;
        this.monedas = new Moneda[5]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public ColeccionMonedas(String nombre) {
        this.nombre = nombre;
        this.numeroMonedas = 0;
        this.monedas = new Moneda[5]; 
    }

    /**
     * Metodo para agregar una moneda a la coleccion
     * @param moneda 
     * @return true/false
     */
    public boolean addMoneda(Moneda moneda) {
        if (moneda == null) {
            return false;
        }
        if (numeroMonedas >= monedas.length) {
            return false;
        }
        monedas[numeroMonedas] = moneda;
        numeroMonedas++;
        return true;
    }

    @Override
    public String toString() {
        String mensaje = "Marca: " +nombre;
        for (int i = 0; i < numeroMonedas; i++) {
            mensaje += monedas[i];
        }
        return mensaje;
    }
}