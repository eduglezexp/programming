package es.ies.puerto.clases;

/**
 * Ejercicio 5
 * Crea una clase llamada Rectangulo con los atributos base y altura. 
 * Implementa un método que calcule el área del rectángulo. 
 * Usa getters y setters para los atributos.
 * Ejercicio 6
 * Añade un método en la clase Rectangulo que calcule el perímetro del rectángulo.
 * La fórmula para calcular el perímetro de un rectángulo es:
 *  𝑃 = 2⋅(𝑏+ℎ)
 * Donde:
 *  P es el perímetro.
 *  b es la longitud de la base del rectángulo.
 *  h es la altura del rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Rectangulo {
    private float base;
    private float altura;

    /**
     * Constructor por defecto
     */
    public Rectangulo() {

    }

    /**
     * Constructor con todas las propiedades
     * @param base del rectangulo
     * @param altura del rectangulo
     */
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * Getters and Setters
     */
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calcularArea() {
        return base * altura;
    }
    
    public float calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return "Rectangulo [base=" + base + ", altura=" + altura + "]";
    }
}