package es.ies.puerto.ejercicio3;

/**
 * Define la clase Coche con atributos marca, modelo, año y velocidad. Incluye métodos
 * acelerar() y frenar(), que modifiquen la velocidad. Usa getters y setters para 
 * controlar el acceso a los atributos.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Coche {
    private String marca;
    private String modelo;
    private int anio;
    private int velocidad;

    /**
     * Constructor por defecto 
     */
    public Coche() {
    }

    /**
     * Constructor con todas las propiedades
     * @param marca del coche
     * @param modelo del coche
     * @param anio del coche
     * @param velocidad del coche
     */
    public Coche(String marca, String modelo, int anio, int velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        setVelocidad(velocidad);
    }

    /**
     * Getters and Setters
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad >= 0) {
            this.velocidad = velocidad;
        }
    }
    
    public void acelerar(int incremento) {
        if (incremento > 0) {
            setVelocidad(this.velocidad + incremento);
        }
    }

    public void frenar(int decremento) {
        if (decremento > 0) {
            setVelocidad(this.velocidad - decremento);
        }
    }

    @Override
    public String toString() {
        return "Coche [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", velocidad=" + velocidad + "]";
    }
}