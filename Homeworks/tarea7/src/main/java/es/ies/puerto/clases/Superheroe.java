package es.ies.puerto.clases;

/**
 * Crea una clase Superheroe que tenga como atributos el nombre, alias y habilidad principal. 
 * Sobrescribe toString() para imprimir la información del superhéroe y equals() para comparar 
 * superhéroes en función de su alias.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Superheroe {
    private String nombre;
    private String alias;
    private String habilidadPrincipal;
    
    /**
     * Constructor por defecto
     */
    public Superheroe() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre del superheroe
     * @param alias del superheroe
     * @param habilidadPrincipal del superheroe
     */
    public Superheroe(String nombre, String alias, String habilidadPrincipal) {
        this.nombre = nombre;
        this.alias = alias;
        this.habilidadPrincipal = habilidadPrincipal;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getHabilidadPrincipal() {
        return habilidadPrincipal;
    }

    public void setHabilidadPrincipal(String habilidadPrincipal) {
        this.habilidadPrincipal = habilidadPrincipal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alias == null) ? 0 : alias.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Superheroe other = (Superheroe) obj;
        if (alias == null) {
            if (other.alias != null)
                return false;
        } else if (!alias.equals(other.alias))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Superheroe [nombre=" + nombre + ", alias=" + alias + ", habilidadPrincipal=" 
        + habilidadPrincipal + "]";
    }
}