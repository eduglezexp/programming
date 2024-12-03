package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio21 {
    static List<List<String>> elementos = new ArrayList<>();
    static int ropa = 1;
    static int libro = 2;
    public static void main(String[] args) {
        elementos.add(crearLista());
        elementos.add(crearLista());
        elementos.add(crearLista());
        System.out.println(elementos);
        //productos.get(ropa).add("Pantalon");
        addElemento(elementos.get(ropa), "pantalon");
        addElemento(elementos.get(ropa), "camiseta");
        addElemento(elementos.get(ropa), "polo");
        deleteListaIsEmpty(elementos, libro);
        System.out.println(elementos);
    }
    
    /**
     * Metodo para crear una lista
     * @return lista vacia
     */
    public static List<String> crearLista(){
        return new ArrayList<>();
    }
    
    /**
     * Metodo para agregar un producto
     * @param lista
     * @param producto
     * @return true/false
     */
    public static boolean addElemento(List<String> lista, String producto){
        if (lista == null) {
        return false;
    }
        if (producto == null) {
        return false;
    }
    
    return lista.add(producto);
    }
    
    /**
     * Metodo para eliminar un producto
     * @param lista
     * @param producto
     * @return true/false
     */
    public static boolean deleteElemento(List<String> lista, String producto){
        if (lista == null || lista.isEmpty()) {
            return false;
        }
        if (producto == null) {
            return false;
        }
        return lista.remove(producto);
    }
    
    /**
     * Metodo para mover un producto
     * @param lista
     * @param producto
     * @return true/false
     */
    public static boolean moverElemento(List<String> listaOrigen, List<String> listaDestino, String producto){
        if (!listaOrigen.contains(producto) || listaDestino.contains(producto)) {
            return false;
        }
        deleteElemento(listaOrigen, producto);
        return addElemento(listaDestino, producto);
    }

    /**
     * Metodo para eliminar una lista si esta vacia
     * @param lista
     * @param producto
     * @return true/false
     */
    public static boolean deleteListaIsEmpty(List<List<String>> lista, int posicion){
        if (lista == null || lista.isEmpty()) {
            return false;
        }
        if (lista.get(posicion).isEmpty()) {
            lista.remove(posicion);
            return true;
        }
        return false;
    }
}