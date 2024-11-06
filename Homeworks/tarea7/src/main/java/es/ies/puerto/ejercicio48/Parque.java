package es.ies.puerto.ejercicio48;

/**
 * 48. Clase Parque con Atracciones
 * Crea una clase Parque con una lista (array) de atracciones (clase Atraccion, 
 * con las propiedades:precio, nombre). Implementa métodos para agregar y eliminar 
 * atracciones, y usa toString() para describir el parque.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Parque {
    private int numeroAtracciones; 
    private String nombre;
    private Atraccion[] atracciones; 

    /**
     * Constructor por defecto
     */
    public Parque() {
        this.numeroAtracciones = 0;
        this.atracciones = new Atraccion[10]; 
    }

    /**
     * Constructor con la propiedad nombre
     */
    public Parque(String nombre) {
        this.nombre = nombre;
        this.numeroAtracciones = 0;
        this.atracciones = new Atraccion[10]; 
    }

    /**
     * Metodo para agregar una atraccion al parque
     * @param atraccion
     * @return true/false
     */
    public boolean addAtraccion(Atraccion atraccion) {
        if (atraccion == null) {
            return false;
        }
        if (numeroAtracciones >= atracciones.length) {
            return false; 
        }
        atracciones[numeroAtracciones] = atraccion;
        numeroAtracciones++;
        return true;
    }

    /**
     * Metodo para eliminar una atraccion del parque
     * @param atraccion
     * @return true/false
     */
    public boolean deleteAtraccion(Atraccion atraccion) {
        if (atraccion == null) {
            return false;
        }
        if (numeroAtracciones == 0) {
            return false; 
        }
        for (int i = 0; i < atracciones.length; i++) {
            if (atraccion.equals(atracciones[i])) {
                atracciones[i] = null;
                numeroAtracciones--;
                ordenarLista();
                return true;
            }
        }
        return false; 
    }

    /**
     * Metodo para ordenar la lista de atracciones despues de una eliminacion
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < atracciones.length; i++) {
            if (atracciones[i] != null) {
                atracciones[index++] = atracciones[i];
            }
        }
        while (index < atracciones.length) {
            atracciones[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " + nombre;
        for (int i = 0; i < numeroAtracciones; i++) {
            mensaje += atracciones[i];
        }
        return mensaje;
    }
}