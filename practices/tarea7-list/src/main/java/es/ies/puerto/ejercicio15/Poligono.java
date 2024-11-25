package es.ies.puerto.ejercicio15;

import java.util.Objects;

/**
 * 15. Clase Polígono
 * Crea una clase Poligono con un método area(). 
 * Implementa los métodos toString()y equals.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Poligono {
    private float perimetro;
    private float apotema;

    /**
     * Constructor por defecto
     */
    public Poligono() {
    }

    /**
     * Constructor con todas las propiedades
     * @param perimetro
     * @param apotema
     */
    public Poligono(float perimetro, float apotema) {
        this.perimetro = perimetro;
        this.apotema = apotema;
    }

    /**
     * Getters and Setters
     */
    public float getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(float perimetro) {
        this.perimetro = perimetro;
    }

    public float getApotema() {
        return apotema;
    }

    public void setApotema(float apotema) {
        this.apotema = apotema;
    }

    public float calcularArea() {
        return perimetro * apotema / 2;
    }

    @Override
    public String toString() {
        return "Poligono [perimetro=" + perimetro + ", apotema=" + apotema + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Poligono)) {
            return false;
        }
        Poligono poligono = (Poligono) o;
        return perimetro == poligono.perimetro && apotema == poligono.apotema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perimetro, apotema);
    }
    
}