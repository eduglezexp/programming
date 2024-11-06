package es.ies.puerto.ejercicio43;

/**
 * 43. Clase Galería con Pinturas
 * Crea una clase Galeria que almacene una lista (array) de pinturas (clase Pintura, 
 * con las propiedades: anio, artista, precio ). Implementa métodos para agregar, eliminar 
 * listar pinturas. Usa toString() para describir la galería.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Galeria {
    private int numeroPinturas;
    private String nombre;
    private Pintura[] pinturas;

    /**
     * Constructor por defecto
     */
    public Galeria() {
        this.numeroPinturas = 0;
        this.pinturas = new Pintura[10]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Galeria(String nombre) {
        this.nombre = nombre;
        this.numeroPinturas = 0;
        this.pinturas = new Pintura[10]; 
    }

    /**
     * Metodo para agregar una pintura a la galería
     * @param pintura
     * @return true/false
     */
    public boolean addPintura(Pintura pintura) {
        if (pintura == null) {
            return false;
        }
        if (numeroPinturas >= pinturas.length) {
            return false;
        }
        pinturas[numeroPinturas] = pintura;
        numeroPinturas++;
        return true;
    }

    /**
     * Mwtodo para eliminar una pintura de la lista
     * @param pintura
     * @return true/false
     */
    public boolean deletePintura(Pintura pintura) {
        if (pintura == null) {
            return false;
        }
        if (numeroPinturas == 0) {
            return false;
        }
        for (int i = 0; i < pinturas.length; i++) {
            if (pintura.equals(pinturas[i])) {
                pinturas[i] = null;
                numeroPinturas--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo para ordenar la lista de pinturas despues de una eliminacion
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < pinturas.length; i++) {
            if (pinturas[i] != null) {
                pinturas[index++] = pinturas[i];
            }
        }
        while (index < pinturas.length) {
            pinturas[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroPinturas; i++) {
            mensaje += pinturas[i];
        }
        return mensaje;
    }
}