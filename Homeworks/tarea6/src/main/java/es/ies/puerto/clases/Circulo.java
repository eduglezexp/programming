package es.ies.puerto.clases;

/**
 * Ejercicio 19
 * Crea una clase Circulo con un atributo radio. Implementa un método que calcule el área 
 * y el perímetro del círculo. Usa getters y setters para el radio.
 * Ejercicio 20
 * Modifica la clase Circulo para que el setter de radio solo acepte valores positivos 
 * y mayores a 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Circulo {
    private int radio;

    /**
     * Constructor por defecto
     */
    public Circulo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param radio del circulo
     */
    public Circulo(int radio) {
        setRadio(radio);
    }

    /**
     * Getters and Setters
     */
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        if (radio > 0) {
            this.radio = radio;
        }
    } 

    public float calcularArea() {
        double area = Math.PI * Math.pow(radio, 2);
        return (float) area;
    }

    public float calcularPerimetro() {
        double diametro = 2 * radio * Math.PI;
        double perimetro = diametro * Math.PI;
        return (float) perimetro;
    }

    @Override
    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }
}