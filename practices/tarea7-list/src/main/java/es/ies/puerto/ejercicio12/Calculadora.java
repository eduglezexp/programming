package es.ies.puerto.ejercicio12;

/**
 * 12. Clase Calculadora con Métodos Estáticos
 * Crea una clase Calculadora con métodos estáticos para sumar, restar, multiplicar y dividir 
 * dos números.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Calculadora {
    private float numero1;
    private float numero2;

    /**
     * Constructor por defecto de la clase
     */
    public Calculadora() {
    }

    /**
     * Constructor con todas las propiedades
     * @param numero1
     * @param numero2
     */
    public Calculadora(float numero1, float numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    /**
     * Getters and Setters
     */
    public float getNumero1() {
        return numero1;
    }

    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumero2() {
        return numero2;
    }

    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }

    public float sumar() {
        return numero1 + numero2;
    }
    
    public float restar() {
        return numero1 - numero2;
    }

    public float multiplicar() {
        return numero1 * numero2;
    }

    public float dividir() {
        if (numero2 == 0) {
            return -1;
        }
        return numero1 / numero2;
    }
}