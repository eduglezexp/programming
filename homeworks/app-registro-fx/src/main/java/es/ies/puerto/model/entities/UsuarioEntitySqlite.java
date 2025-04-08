package es.ies.puerto.model.entities;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.1.0
 */
public class UsuarioEntitySqlite {

    private int id;  
    private String user;
    private String name;
    private String email;
    private String password;
    private int puntos;
    private int victorias;
    private int idNivel;

    /**
     * Constructor por defecto
     */
    public UsuarioEntitySqlite() {
    }

    public UsuarioEntitySqlite(String user, String email) {
        this.user = user;
        this.email = email;
    }

    /**
     * Constructor con casi todas las propiedades menos el id
     * @param usuario nick del usuario
     * @param email del usuario
     * @param nombre del usuario
     * @param password del usuario
     */
    public UsuarioEntitySqlite(String user, String name, String email, String password) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UsuarioEntitySqlite(String usuario, String email, String nombre, String password, int puntos,
        int victorias, int idNivel) {
        this.user = usuario;
        this.email = email;
        this.name = nombre;
        this.password = password;
        this.puntos = puntos;
        this.victorias = victorias;
        this.idNivel = idNivel;
    }

    /**
     * Constructor con todas las propiedades
     * @param id identificador del usuario
     * @param usuario nick del usuario
     * @param email del usuario
     * @param nombre del usuario
     * @param password del usuario
     * @param puntos del usuario
     * @param victorias del usuario
     * @param idNivel del usuario
     */
    public UsuarioEntitySqlite(int id, String user, String name, String email, String password, int puntos,
        int victorias, int idNivel) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.puntos = puntos;
        this.victorias = victorias;
        this.idNivel = idNivel;
    }
    
    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }  

    @Override
    public String toString() {
        return "UsuarioEntitySqlite [id=" + id + ", user=" + user + ", name=" + name + ", email=" + email
                + ", password=" + password + ", puntos=" + puntos + ", victorias=" + victorias + ", idNivel=" + idNivel
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
        return Objects.equals(user, usuarioEntitySqlite.user) && Objects.equals(email, usuarioEntitySqlite.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, email);
    }  
}