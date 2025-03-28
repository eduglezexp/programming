package es.ies.puerto.model.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioEntityJson {

    private String usuario;
    private String password;
    private String nombre;
    private String email;

    /**
     * Constructor por defecto
     */
    public UsuarioEntityJson() {
    }

    /**
     * Constructor con la propiedad usuario
     * @param usuario identificador de la clase Usuario
     */
    public UsuarioEntityJson(@JsonProperty("usuario") String usuario) {
        this.usuario = usuario;
    }

    /**
     * Constructor con todas las propiedades
     * @param usuario nick del usuario
     * @param password del usuario
     * @param nombre del usuario
     * @param email del usuario
     */
    @JsonCreator
    public UsuarioEntityJson(@JsonProperty("usuario") String usuario, 
                   @JsonProperty("password") String password, 
                   @JsonProperty("nombre") String nombre, 
                   @JsonProperty("email") String email) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Getters and Setters
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntityJson)) return false;
        UsuarioEntityJson usuario1 = (UsuarioEntityJson) o;
        return Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }
}