package es.ies.puerto.ejercicio43;
import java.util.Objects;

/**
 * 43. Clase Galería con Pinturas
 * Crea una clase Galeria que almacene una lista (array) de pinturas (clase Pintura, 
 * con las propiedades: anio, artista, precio ). Implementa métodos para agregar, eliminar 
 * listar pinturas. Usa toString() para describir la galería.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Pintura {
    private int anio;
    private String artista;
    private float precio;

    /**
     * Constructor por defecto
     */
    public Pintura() {
    }

    /**
     * Constructor con todas las propiedades
     * @param anio
     * @param artista
     * @param precio
     */
    public Pintura(int anio, String artista, float precio) {
        this.anio = anio;
        this.artista = artista;
        this.precio = precio;
    }

    /**
     * Getters and Setters
     */
    public int getAnio() {
        return anio;
    }

    public String getArtista() {
        return artista;
    }

    public float getPrecio() {
        return precio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pintura)) {
            return false;
        }
        Pintura pintura = (Pintura) o;
        return anio == pintura.anio && Objects.equals(artista, pintura.artista) && precio == pintura.precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anio, artista, precio);
    }    

    @Override
    public String toString() {
        return "\nPintura{" +
               "anio=" + anio +
               ", artista='" + artista + '\'' +
               ", precio=" + precio +
               '}';
    }
}