package es.ies.puerto.ejercicio20;

/**
 * 20. Clase Factura con Métodos de Cálculo
 * Crea una clase Factura con atributos producto, cantidad y precio. Implementa métodos para 
 * calcular el total de la factura y usa toString() para mostrar la información de la factura.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Factura {
    private String producto;
    private int cantidad;
    private float precio;

    /**
     * Constructor por defecto
     */
    public Factura() {
    }

    /**
     * Constructor con todas las propiedades
     * @param producto
     * @param cantidad
     * @param precio
     */
    public Factura(String producto, int cantidad, float precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Getters and Setters
     */
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Metodo para calcular el total de la factura
     */
    public float calcularTotal() {
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return "Factura [producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
