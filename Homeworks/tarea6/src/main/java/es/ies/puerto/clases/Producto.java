package es.ies.puerto.clases;

/**
 * Ejercicio 15
 * Crea una clase Producto con los atributos nombre, precio y stock. 
 * El precio no puede ser negativo y el stock debe ser al menos 0.
 * Ejercicio 16
 * Añade a la clase Producto un método para vender productos, que disminuya 
 * el stock y retorne el total de la venta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Producto {
    private String nombre;
    private float precio;
    private int stock;
    
    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * Constructor con todas las propiedades
     * @param nombre del producto
     * @param precio del producto
     * @param stock del producto
     */
    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
    }

    public String ventaProductos(Producto producto, int cantidad) {
        if (producto.stock < cantidad) {
            return "Stock insuficente";
        }
        producto.stock -= cantidad;
        float total = producto.precio *= cantidad;
        return "El total de la venta es: " +total;
    }
}