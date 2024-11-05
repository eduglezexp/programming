package es.ies.puerto.ejercicio27;

/**
 * 27. Clase Planeta con Atributos Astronómicos
 * Define una clase Planeta con atributos nombre, masa, y radio. 
 * Implementa métodos para calcular la gravedad en la superficie del planeta. 
 * Usa toString() para describir el planeta.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Planeta {
    private String nombre;
    private float masa; 
    private float radio;
    private static final float G = 6.67430e-11f;

    /**
     * Constructor por defecto 
     */
    public Planeta() {

    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param masa
     * @param radio
     */
    public Planeta(String nombre, float masa, float radio) {
        this.nombre = nombre;
        this.masa = masa;
        this.radio = radio;
    }

    /**
     * Metodo para calcular la gravedad en la superficie
     * @return
     */
    public float calcularGravedadSuperficie() {
        return (G * masa) / (radio * radio);
    }

    @Override
    public String toString() {
        return "Planeta: " + nombre +
               "\nMasa: " + masa + " kg" +
               "\nRadio: " + radio + " m" +
               "\nGravedad en la superficie: " + calcularGravedadSuperficie() + " m/s²";
    }
}