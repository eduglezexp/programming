package es.ies.puerto;

import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    private String codigo;

    /**
     * Constructor con todos los atributos
     * @param nombre del producto
     * @param precio del producto
     * @param codigo del producto
     */
    public Producto(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    /**
     * Constructor con solo el codigo
     * @param codigo del producto
     */
    public Producto(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto{nombre='" +nombre+ "', precio=" +precio+ ", codigo='"  +codigo+ "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}