package es.ies.puerto;

/**
 * Ejercicio 15
 * Crea una clase Producto con los atributos nombre, precio y stock. 
 * El precio no puede ser negativo y el stock debe ser al menos 0.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Producto con nombre "Laptop", precio 1000, 
 * y stock 50. Asegúrate de que el precio no sea negativo y que el stock 
 * no sea menor a 0.
 * Ejercicio 16
 * Añade a la clase Producto un método para vender productos, que disminuya 
 * el stock y retorne el total de la venta.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Producto con nombre "Cámara", precio 300, 
 * y stock 20. Realiza una venta de 5 unidades y muestra el stock restante 
 * y el total de la venta.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Producto {
    private String nombre;
    private float precio;
    private int stock;
    
    public Producto() {
    }

    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

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

    public void ventaProductos() {
        
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop", 1000, 50);
        System.out.println(producto1);

    }
}
