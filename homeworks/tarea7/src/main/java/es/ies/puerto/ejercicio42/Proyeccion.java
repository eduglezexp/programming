package es.ies.puerto.ejercicio42;

import java.util.Objects;

/**
 * 42. Clase Cine con Proyecciones
 * Crea una clase Cine que almacene una lista (array) de proyecciones 
 * (clase Proyeccion, clase con propiedades: ciudad, hora, y fecha). 
 * Implementa métodos para agregar y eliminar proyecciones, y usa 
 * toString() para mostrar los detalles del cine.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Proyeccion {
    private String ciudad;
    private String hora;  
    private String fecha; 

    /**
     * Constructor por defecto
     */
    public Proyeccion() {

    }

    /**
     * Constuctor con todas las propidades
     * @param ciudad
     * @param hora
     * @param fecha
     */
    public Proyeccion(String ciudad, String hora, String fecha) {
        this.ciudad = ciudad;
        this.hora = hora;
        this.fecha = fecha;
    }

    /**
     * Getters and Setters
     */
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Proyeccion)) {
            return false;
        }
        Proyeccion proyeccion = (Proyeccion) o;
        return Objects.equals(ciudad, proyeccion.ciudad) && Objects.equals(hora, proyeccion.hora) && Objects.equals(fecha, proyeccion.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, hora, fecha);
    }
    
    @Override
    public String toString() {
        return "\nProyeccion{" +
               "ciudad='" + ciudad + '\'' +
               ", hora='" + hora + '\'' +
               ", fecha='" + fecha + '\'' +
               '}';
    }
}