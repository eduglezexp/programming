package es.ies.puerto.ejercicio28;

import java.util.Objects;

/**
 * 28. Clase Ciudad con Comparación por Población
 * Crea una clase Ciudad con atributos nombre, pais, y poblacion. 
 * Implementa métodos para comparar ciudades por su población con 
 * equals() y usar toString() para describir la ciudad.
 * @author edglezexp
 * @version 1.0.0
 */

 public class Ciudad {
    private String nombre;
    private String pais;
    private int poblacion; 

    /**
     * Constructor por defecto
     */
    public Ciudad() {

    }

    /**
     * Constrctor con todas las propiedades
     * @param nombre
     * @param pais
     * @param poblacion
     */
    public Ciudad(String nombre, String pais, int poblacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ciudad otraCiudad = (Ciudad) obj;
        return this.poblacion == otraCiudad.poblacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(poblacion);
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre +
               "\nPaís: " + pais +
               "\nPoblación: " + poblacion + " habitantes";
    }
}

