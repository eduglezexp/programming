package es.ies.puerto.ejercicio19;

/**
 * 19. Clase Conversor con Métodos de Conversión estáticos
 * Crea una clase Conversor con métodos para convertir unidades de longitud 
 * (metros a pies__, kilómetros a millas). Usa toString() para mostrar el valor 
 * convertido.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Conversor {
    private float metros;
    public float kilometros;

    
    /**
     * Constructor por defecto
     */
    public Conversor() {
    }

    
    /**
     * Constructor con todas las propiedades
     * @param metros 
     * @param kilometros
     */
    public Conversor(float metros, float kilometros) {
        this.metros = metros;
        this.kilometros = kilometros;
    }

    /**
     * Getters and Setters
     */
    public float getMetros() {
        return metros;
    }


    public void setMetros(float metros) {
        this.metros = metros;
    }


    public float getKilometros() {
        return kilometros;
    }


    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Funcion para convertir metros a pies
     * @return pies
     */
    public float metrosAPies() {
        return (float) (metros * 3.28084);
    }

    /**
     * Funcion para convertir kilometros a millas
     * @return millas
     */
    public float kilometrosAMillas() {
        return (float) (kilometros * 0.621371);
    }

    @Override
    public String toString() {
        return "Conversor [metros=" + metros + ", kilometros=" + kilometros + "]";
    }
}