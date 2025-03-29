package es.ies.puerto.model.entities;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioEntitySqlite {

    private String user;
    private String name;
    private String email;
    private String password;

    /**
     * Constructor por defecto
     */
    public UsuarioEntitySqlite() {
    }

    /**
     * Constructor con la propiedad usuario
     * @param email identificador de la clase Usuario
     */
    public UsuarioEntitySqlite(String email) {
        this.email = email;
    }

    /**
     * Constructor con todas las propiedades
     * @param usuario nick del usuario
     * @param email del usuario
     * @param nombre del usuario
     * @param password del usuario
     */
    public UsuarioEntitySqlite(String usuario, String email, String nombre, String password) {
        this.user = usuario;
        this.email = email;
        this.name = nombre;
        this.password = password;
    }

    /**
     * Getters and Setters
     */
    public String getUser() {
        return user;
    }

    public void setUser(String usuario) {
        this.user = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioEntitySqlite [user=" + user + ", name=" + name + ", email=" + email + ", password=" + password
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioEntitySqlite)) {
            return false;
        }
        UsuarioEntitySqlite usuarioEntitySqlite = (UsuarioEntitySqlite) o;
        return Objects.equals(email, usuarioEntitySqlite.email);
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }    
}