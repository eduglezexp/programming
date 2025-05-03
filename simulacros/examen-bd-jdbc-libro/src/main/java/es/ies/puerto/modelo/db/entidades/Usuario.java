package es.ies.puerto.modelo.db.entidades;

import java.util.Date;
import java.util.Objects;

import es.ies.puerto.modelo.db.entidades.abstractas.AbstractEntity;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Usuario extends AbstractEntity{
    private String idUsuario;
    private String nombre;
    private String email;
    private String telefono;
    private Date fechaRegistro;

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /*
     * Constructor con la propiedad id
     */
    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Constructor con todas las propiedades
     */
    public Usuario(String idUsuario, String nombre, String email, String telefono, Date fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getters and Setters
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaRegistro() {
        return getFecha(fechaRegistro);
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
                + ", fechaRegistro=" + fechaRegistro + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }
}
