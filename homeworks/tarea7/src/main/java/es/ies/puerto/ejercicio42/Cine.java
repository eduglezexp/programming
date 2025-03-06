package es.ies.puerto.ejercicio42;

/**
 * 42. Clase Cine con Proyecciones
 * Crea una clase Cine que almacene una lista (array) de proyecciones 
 * (clase Proyeccion, clase con propiedades: ciudad, hora, y fecha). 
 * Implementa métodos para agregar y eliminar proyecciones, y usa 
 * toString() para mostrar los detalles del cine.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Cine {
    private int numeroProyecciones;
    private String nombre;
    private Proyeccion[] proyecciones;

    /**
     * Constructor por defecto
     */
    public Cine() {
        this.numeroProyecciones = 0;
        this.proyecciones = new Proyeccion[10]; 
    }

    /**
     * Constructor con el nombre del cine
     * @param nombre
     */
    public Cine(String nombre) {
        this.nombre = nombre;
        this.numeroProyecciones = 0;
        this.proyecciones = new Proyeccion[10]; 
    }

    /**
     * Metodo para agregar una proyección al cine
     * @param proyeccion
     * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean addProyeccion(Proyeccion proyeccion) {
        if (proyeccion == null) {
            return false;
        }
        if (numeroProyecciones >= proyecciones.length) {
            return false;
        }
        proyecciones[numeroProyecciones] = proyeccion;
        numeroProyecciones++;
        return true;
    }

    /**
     * Metodo para eliminar una proyeccion de la lista
     * @param proyeccion
     * @return true/false
     */
    public boolean deleteProyeccion(Proyeccion proyeccion) {
        if (proyeccion == null) {
            return false;
        }
        if (numeroProyecciones == 0) {
            return false;
        }
        for (int i = 0; i < proyecciones.length; i++) {
            if (proyeccion.equals(proyecciones[i])) {
                proyecciones[i] = null;
                numeroProyecciones--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista de proyecciones después de una eliminación
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < proyecciones.length; i++) {
            if (proyecciones[i] != null) {
                proyecciones[index++] = proyecciones[i];
            }
        }
        while (index < proyecciones.length) {
            proyecciones[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroProyecciones; i++) {
            mensaje += proyecciones[i];
        }
        return mensaje;
    }
}