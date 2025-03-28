package es.ies.puerto.model.entities;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioEntitySqlite {

    private String usuario;
    private String nombre;
    private String email;
    private String password;

    /**
     * Constructor por defecto
     */
    public UsuarioEntitySqlite() {
    }

    /**
     * Constructor con la propiedad usuario
     * @param usuario identificador de la clase Usuario
     * @param email identificador de la clase Usuario
     */
    public UsuarioEntitySqlite(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Constructor con todas las propiedades
     * @param usuario nick del usuario
     * @param password del usuario
     * @param nombre del usuario
     * @param email del usuario
     */
    public UsuarioEntitySqlite(String usuario, String password, String email) {
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor con todas las propiedades
     * @param usuario nick del usuario
     * @param password del usuario
     * @param nombre del usuario
     * @param email del usuario
     */
    public UsuarioEntitySqlite(String usuario, String password, String nombre, String email) {
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
        return "UsuarioEntity [usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email="
                + email + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioEntitySqlite)) {
            return false;
        }
        UsuarioEntitySqlite usuarioEntity = (UsuarioEntitySqlite) o;
        return Objects.equals(usuario, usuarioEntity.usuario) && Objects.equals(email, usuarioEntity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, email);
    }    
}