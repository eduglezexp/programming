package es.ies.puerto.ejercicio39;

import es.ies.puerto.ejercicio22.Articulo;

/**
 * 39. Clase Tienda con Artículos
 * Crea una clase Tienda que almacene una lista (array) de artículos 
 * (clase Articulo ejercicio 22). Implementa métodos para agregar y 
 * eliminar artículos y usar toString() para mostrar los detalles de la tienda.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Tienda {
    private int numeroArticulos;
    private String nombre;
    private Articulo[] articulos;

    /**
     * Constructor por defecto
     */
    public Tienda() {
        this.numeroArticulos = 0;
        this.articulos = new Articulo[10];
    }

    /**
     * Constructor con la propiedad nombre
     * @param numeroArticulos
     * @param nombre
     * @param articulos
     */
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.numeroArticulos = 0;
        this.articulos = new Articulo[10];
    }

    /**
     * Metodo para agregar un articulo a la lista
     * @param articulo 
     * @return true/false
     */
    public boolean addProducto(Articulo articulo) {
        if (articulo == null) {
            return false;
        }
        if (numeroArticulos >= articulos.length) {
            return false;
        }
        articulos[numeroArticulos] = articulo;
        numeroArticulos++;
        return true;
    }

    /**
     * Metodo para eliminar un articulo de la lista
     * @param articulo
     * @return true/false
     */
    public boolean deleteArticulo(Articulo articulo) {
        if (articulo == null) {
            return false;
        }
        if (numeroArticulos == 0) {
            return false;
        }
        for (int i = 0; i < articulos.length; i++) {
            if (articulo.equals(articulos[i])) {
                articulos[i] = null;
                numeroArticulos--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un articulo
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < articulos.length; i++) {
            if (articulos[i] != null) {
                articulos[index++] = articulos[i];
            }
        }
        while (index < articulos.length) {
            articulos[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroArticulos; i++) {
            mensaje += articulos[i];
        }
        return mensaje;
    }
}