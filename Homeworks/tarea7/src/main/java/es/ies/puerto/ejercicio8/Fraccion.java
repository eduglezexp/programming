package es.ies.puerto.ejercicio8;

/**
 * 8. Clase Fracción con Métodos Matemáticos
 * Crea una clase Fraccion con atributos numerador y denominador. Implementa métodos 
 * para sumar, restar, multiplicar y dividir fracciones. Sobrescribe toString() para 
 * mostrar la fracción en formato numerador/denominador.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Fraccion {
    private float numerador;
    private float denominador;

    /**
     * Constructor por defecto
     */
    public Fraccion() {
    }

    /**
     * Constructor con todas las propiedades
     * @param numerador de la fraccion
     * @param denominador de la fraccion
     */
    public Fraccion(float numerador, float denominador) {
        this.numerador = numerador;
        setDenominador(denominador);
    }

    /**
     * Getters and Setters
     */
    public float getNumerador() {
        return numerador;
    }

    public void setNumerador(float numerador) {
        this.numerador = numerador;
    }

    public float getDenominador() {
        return denominador;
    }

    public void setDenominador(float denominador) {
        if (denominador == 0) {
            this.denominador = 1;
        }
        this.denominador = denominador;
    }
    
    /**
     * Funcion para calcular la suma de dos fracciones
     * @param otraFraccion 
     * @return nueva fraccion con el resultado
     */
    public float sumar(Fraccion otraFraccion) {
        return 0;
    }

    /**
     * Funcion para calcular la resta de dos fracciones
     * @param otraFraccion 
     * @return nueva fraccion con el resultado
     */
    public float restar(Fraccion otraFraccion) {
        return 0;
    }

    /**
     * Funcion para calcular la division de dos fracciones
     * @param otraFraccion 
     * @return nueva fraccion con el resultado
     */
    public float dividir(Fraccion otraFraccion) {
        return 0;
    }

    /**
     * Funcion para calcular la multiplicacion de dos fracciones
     * @param otraFraccion 
     * @return nueva fraccion con el resultado
     */
    public float multiplicar(Fraccion otraFraccion) {
        return 0;
    }

    @Override
    public String toString() {
        return numerador+ "/" +denominador;
    }
}