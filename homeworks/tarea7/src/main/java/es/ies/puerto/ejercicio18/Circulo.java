package es.ies.puerto.ejercicio18;
import java.util.Objects;

/**
 * 18. Clase Circulo con Métodos para Área y Perímetro
 * Define una clase Circulo con el atributo radio. Implementa los métodos area() y 
 * perimetro(). Usa equals() para comparar círculos por su radio.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Circulo {
    private float radio;

    /**
     * Constructor por defecto
     */
    public Circulo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param radio del circulo
     */
    public Circulo(float radio) {
        this.radio = radio;
    }

    /*
     * Getters and Setters
     */
    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    /**
     * Funcion para calcular el area del circulo
     * @return area del circulo
     */
    public float calcularArea() {
        double area = Math.PI * Math.pow(radio, 2);
        return (float) area;
    }

    /**
     * Funcion para calcular el perimetro del circulo
     * @return perimetro del area
     */
    public float calcularPerimetro() {
        double perimetro = 2 * Math.PI * radio;
        return (float) perimetro;
    }
    
    @Override
    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Circulo)) {
            return false;
        }
        Circulo circulo = (Circulo) o;
        return radio == circulo.radio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }
}