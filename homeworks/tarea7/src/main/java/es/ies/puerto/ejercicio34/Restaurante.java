package es.ies.puerto.ejercicio34;

/**
 * 34. Clase Restaurante con Menú
 * Crea una clase Restaurante con una lista (array) de platos (clase Plato). 
 * Implementa métodos para agregar y eliminar platos del menú y usar toString() 
 * para mostrar los detalles del restaurante.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Restaurante {
    private int numeroPlatos;
    private String nombre;
    private Plato[] menu;

    /**
     * Constructor por defecto
     */
    public Restaurante() {
        this.numeroPlatos = 0;
        this.menu = new Plato[5]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.numeroPlatos = 0;
        this.menu = new Plato[5]; 
    }

    /**
     * Metodo para agregar un plato al menu
     * @param plato 
     * @return true/false
     */
    public boolean addPlato(Plato plato) {
        if (plato == null) {
            return false;
        }
        if (numeroPlatos >= menu.length) {
            return false;
        }
        menu[numeroPlatos] = plato;
        numeroPlatos++;
        return true;
    }

    /**
     * Metodo para eliminar un plato del menu
     * @param plato
     * @return true/false
     */
    public boolean deleteMenu(Plato plato) {
        if (plato == null) {
            return false;
        }
        if (numeroPlatos == 0) {
            return false;
        }
        for (int i = 0; i < menu.length; i++) {
            if (plato.equals(menu[i])) {
                menu[i] = null;
                numeroPlatos--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un plato
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                menu[index++] = menu[i];
            }
        }
        while (index < menu.length) {
            menu[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroPlatos; i++) {
            mensaje += menu[i];
        }
        return mensaje;
    }
}