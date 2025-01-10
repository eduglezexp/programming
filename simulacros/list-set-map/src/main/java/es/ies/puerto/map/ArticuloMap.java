package es.ies.puerto.map;


import java.util.HashMap;
import java.util.Map;

import es.ies.puerto.Articulo;

public class ArticuloMap {
    Map<String, Articulo> articulos;

    /**
     * Constructor por defecto
     */
    public ArticuloMap() {
        this.articulos = new HashMap<>();
    }

    /**
     * Funcion para agregar un articulo a la lista
     * @param articulo
     * @return true/false
     */
    public boolean agregar(Articulo articulo) {
        if (!articulos.containsKey(articulo.getCodigo())) { 
            articulos.put(articulo.getCodigo(), articulo);
            return true;
        }
        return false;
    }

    /**
     * Funcion para listar los articulos
     * @return hashMap con la lista de articulos
     */
    public Map<String, Articulo> listar() {
        return new HashMap<>(articulos);
    }

    /**
     * Funcion para buscar un articulo
     * @param codigo
     * @return articulo buscado
     */
    public Articulo buscar(String codigo) {
        return articulos.get(codigo);
    }

    /**
     * Funcion para actualizar un articulo
     * @param codigo
     * @param nuevoArticulo
     * @return true/false
     */
    public boolean actualizar(String codigo, Articulo nuevoArticulo) {
        if (articulos.containsKey(codigo)) { 
            articulos.put(codigo, nuevoArticulo);
            return true;
        }
        return false;
    }

    /**
     * Funcion para eliminar un articulo
     * @param codigo
     * @return true/false
     */
    public boolean eliminar(String codigo) {
        Articulo articuloEliminar = new Articulo(codigo);
        return articulos.remove(codigo, articuloEliminar);
    }
}