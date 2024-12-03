package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 * posible examen
 */

 public class Ejercicio15 {
    static List<List<String>> productos = new ArrayList<>();
    static int electronica = 0;
    static int ropa = 1;
    static int libro = 2;
    public static void main(String[] args) {
        productos.add(crearLista());
        productos.add(crearLista());
        productos.add(crearLista());
        System.out.println(productos);
        //productos.get(ropa).add("Pantalon");
        addproducto(productos.get(ropa), "pantalon");
        addproducto(productos.get(ropa), "camiseta");
        addproducto(productos.get(ropa), "polo");
        addproducto(productos.get(electronica), "casco");
        System.out.println(productos);
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
    public static boolean addproducto(List<String> lista, String producto){
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
    public static boolean deleteProducto(List<String> lista, String producto){
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
    public static boolean moverproducto(List<String> listaOrigen, List<String> listaDestino, String producto){
        if (!listaOrigen.contains(producto) || listaDestino.contains(producto)) {
            return false;
        }
        deleteProducto(listaOrigen, producto);
        return addproducto(listaDestino, producto);
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