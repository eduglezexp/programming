package es.ies.puerto;
import java.util.Objects;

/**
 * Ejercicio 4: El Mago
 * Descripción Crea una clase llamada Mago que represente a un personaje en un juego. El mago tiene un nivel de poder mágico (poderMagico) y una cantidad de puntos de maná (mana). El mago puede lanzar hechizos si tiene suficiente maná, y su poder de hechizo dependerá de su nivel de poder mágico.
 * Atributos:
 *  nombre (tipo String): Nombre del mago.
 *  nivel (tipo int): Nivel de poder mágico del mago.
 *  mana (tipo int): Puntos de maná disponibles.
 * Métodos:
 *  lanzarHechizo(int nivel): Lanza un hechizo si el mago tiene suficiente maná, teniendo que ser siempre mayor > 0*. Cada hechizo cuesta una cantidad de maná. Si el mago tiene el maná necesario, reduce el maná y calcula el daño del hechizo.
 *  calcularDanio(): Calcula el daño del hechizo según el nivel de poderMagico. La fórmula del daño será daño = poderMagico * 10.
 *  recargar(int cantidad): Recarga la cantidad de maná especificada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Mago {
    private String nombre;
    private int nivel;
    private int mana;

    /**
     * Constructor por defecto
     */
    public Mago() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre
     * @param nivel
     * @param mana
     */
    public Mago(String nombre, int nivel, int mana) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.mana = mana;
    }

    /**
     * Getters and Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Metodo para saber si se puede lanzar un hechizo
     * @param valor
     */
    public boolean lanzarHechizo(int valor) {
        if ((this.mana - valor) > 0) {
            this.mana -= valor;
            return true;
        }
        return false;
    }

    /**
     * Metodo para calcular el danio del hechizo
     * @return
     */
    public int calcularDanio() {
        return nivel * 10;
    }

    /**
     * Metodo para recargar el mana
     * @param cantidad
     */
    public void recargar(int cantidad) {

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mago)) {
            return false;
        }
        Mago mago = (Mago) o;
        return Objects.equals(nombre, mago.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    @Override
    public String toString() {
        return "Mago [nombre=" + nombre + ", nivel=" + nivel + ", mana=" + mana + "]";
    }
}