package es.ies.puerto.ejercicio4;
import java.util.Objects;

/**
 * Crea una clase Rectangulo con atributos ancho y alto. Implementa los métodos carea() y 
 * perimetro(). Sobrescribe equals() para comparar rectángulos por sus dimensiones y toString() 
 * para describir el rectángulo.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Rectangulo {
    private float ancho;
    private float alto;
    
    /**
     * Constructor por defecto 
     */
    public Rectangulo() {
    }

    /**
     * Constructor con todas las propiedades
     * @param ancho del rectangulo
     * @param alto del rectangulo
     */
    public Rectangulo(float ancho, float alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Getters and Setters
     */
    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float area() {
        return alto * ancho;
    }

    public float perimetro() {
        return 2 * (alto + ancho);
    }

    @Override
    public String toString() {
        return "Rectangulo [ancho=" + ancho + ", alto=" + alto + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rectangulo)) {
            return false;
        }
        Rectangulo rectangulo = (Rectangulo) o;
        return ancho == rectangulo.ancho && alto == rectangulo.alto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ancho, alto);
    }
}