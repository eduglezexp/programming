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
        } else {
            this.denominador = denominador;
        }
    }

    /**
     * Suma de dos fracciones
     * @param otraFraccion
     * @return nueva fraccion con el resultado
     */
    public Fraccion sumar(Fraccion otraFraccion) {
        float nuevoNumerador = (this.numerador * otraFraccion.denominador) +
                               (otraFraccion.numerador * this.denominador);
        float nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    /**
     * Resta de dos fracciones
     * @param otraFraccion
     * @return nueva fraccion con el resultado
     */
    public Fraccion restar(Fraccion otraFraccion) {
        float nuevoNumerador = (this.numerador * otraFraccion.denominador) -
                               (otraFraccion.numerador * this.denominador);
        float nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    /**
     * Multiplicación de dos fracciones
     * @param otraFraccion
     * @return nueva fraccion con el resultado
     */
    public Fraccion multiplicar(Fraccion otraFraccion) {
        float nuevoNumerador = this.numerador * otraFraccion.numerador;
        float nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    /**
     * División de dos fracciones
     * @param otraFraccion
     * @return nueva fraccion con el resultado
     */
    public Fraccion dividir(Fraccion otraFraccion) {
        float nuevoNumerador = this.numerador * otraFraccion.denominador;
        float nuevoDenominador = this.denominador * otraFraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    @Override
    public String toString() {
        return numerador+ "/" +denominador;
    }
}