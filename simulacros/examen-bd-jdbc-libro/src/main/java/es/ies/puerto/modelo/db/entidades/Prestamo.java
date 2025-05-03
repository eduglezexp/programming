package es.ies.puerto.modelo.db.entidades;



import java.util.Date;
import java.util.Objects;

import es.ies.puerto.modelo.db.entidades.abstractas.AbstractEntity;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Prestamo extends AbstractEntity{
    private String idPrestamo;
    private String libroId;
    private String usuarioId;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    /**
     * Constructor por defecto
     */
    public Prestamo() {
    }

    /*
     * Constructor con la propiedades id
     */
    public Prestamo(String idPrestamo, String libroId, String usuarioId) {
        this.idPrestamo = idPrestamo;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
    }

    /**
     * Constructor con todas las propiedades
     */
    public Prestamo(String idPrestamo, String libroId, String usuarioId, Date fechaPrestamo, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Getters and Setters
     */
    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaPrestamo() {
        return getFecha(fechaPrestamo);
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return getFecha(fechaDevolucion);
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo [idPrestamo=" + idPrestamo + ", libroId=" + libroId + ", usuarioId=" + usuarioId
                + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Prestamo)) {
            return false;
        }
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(idPrestamo, prestamo.idPrestamo) && Objects.equals(libroId, prestamo.libroId) && Objects.equals(usuarioId, prestamo.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrestamo, libroId, usuarioId);
    }
    
}
