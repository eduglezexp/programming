package es.ies.puerto;

/**
 * Crea una clase llamada Círculo que represente un círculo. Debe de poseer como atributo 
 * su radio, del cual vamos a obtener el perímetro de este.
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

    @Override
    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }

    public float calcularArea() {
        double area = Math.PI * Math.pow(radio, 2);
        return (float) area;
    }

    public float calcularPerimetro() {
        double perimetro = 2 * Math.PI * radio;
        return (float) perimetro;
    }
}