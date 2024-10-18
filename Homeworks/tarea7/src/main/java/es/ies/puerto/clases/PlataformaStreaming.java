package es.ies.puerto.clases;

/**
 * Crea una clase PlataformaStreaming con nombre, número de suscriptores y catálogo principal. 
 * Sobrescribe toString() para mostrar los detalles de la plataforma y equals() para comparar 
 * si dos plataformas tienen el mismo catálogo principal.
 * @author eduglezexp
 * @version 1.0.0
 */

public class PlataformaStreaming {
    private String nombre;
    private int suscriptores;
    private String catalogoPrincipal;
    
    /**
     * Constructor por defecto
     */
    public PlataformaStreaming() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre de la plataforma de streaming
     * @param suscriptores de la plataforma de streaming
     * @param catalogoPrincipal de la plataforma de streaming
     */
    public PlataformaStreaming(String nombre, int suscriptores, String catalogoPrincipal) {
        this.nombre = nombre;
        this.suscriptores = suscriptores;
        this.catalogoPrincipal = catalogoPrincipal;
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

    public int getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(int suscriptores) {
        this.suscriptores = suscriptores;
    }

    public String getCatalogoPrincipal() {
        return catalogoPrincipal;
    }

    public void setCatalogoPrincipal(String catalogoPrincipal) {
        this.catalogoPrincipal = catalogoPrincipal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((catalogoPrincipal == null) ? 0 : catalogoPrincipal.hashCode());
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
        PlataformaStreaming other = (PlataformaStreaming) obj;
        if (catalogoPrincipal == null) {
            if (other.catalogoPrincipal != null)
                return false;
        } else if (!catalogoPrincipal.equals(other.catalogoPrincipal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PlataformaStreaming [nombre=" + nombre + ", suscriptores=" + suscriptores + ", catalogoPrincipal="
                + catalogoPrincipal + "]";
    }
}