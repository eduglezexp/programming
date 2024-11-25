package es.ies.puerto.ejercicio30;

/**
 * 30. Clase Playlist con Canciones
 * Crea una clase Playlist que almacene una lista(array) de canciones (clase Cancion). 
 * Implementa métodos para agregar, eliminar y listar canciones. 
 * Usa toString() para mostrar la lista.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Playlist {
    private int numeroCanciones;
    private String nombre;
    private Cancion[] canciones;

    /**
     * Constructor por defecto
     */
    public Playlist() {
        this.numeroCanciones = 0;
        this.canciones = new Cancion[10];  
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.numeroCanciones = 0;
        this.canciones = new Cancion[10];  
    }

    /**
     * Metodo para agregar una cancion a la playlist
     * @param cancion 
     * @return true/false
     */
    public boolean addCancion(Cancion cancion) {
        if (cancion == null) {
            return false;
        }
        if (numeroCanciones >= canciones.length) {
            return false;
        }
        canciones[numeroCanciones] = cancion;
        numeroCanciones++;  
        return true;
    }

    /**
     * Metodo para eliminar una cancion
     * @param cancion
     * @return true/false
     */
    public boolean deleteCancion(Cancion cancion) {
        if (cancion == null) {
            return false;
        }
        if (numeroCanciones == 0) {
            return false;
        }
        for (int i = 0; i < canciones.length; i++) {
            if (cancion.equals(canciones[i])) {
                canciones[i] = null;
                numeroCanciones--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar una cancion
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] != null) {
                canciones[index++] = canciones[i];
            }
        }
        while (index < canciones.length) {
            canciones[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroCanciones; i++) {
            mensaje += canciones[i];
        }
        return mensaje;
    }
}