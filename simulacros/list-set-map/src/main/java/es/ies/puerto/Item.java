package es.ies.puerto;

import java.util.Objects;

public class Item {
    private String nombre;
    private double precio;
    private String codigo;

    /**
     * Constructor con todos los atributos
     * @param nombre del item
     * @param precio del item
     * @param codigo del item
     */
    public Item(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    /**
     * Constructor con solo el codigo
     * @param codigo del item
     */
    public Item(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Item{nombre='" +nombre+ "', precio=" +precio+ ", codigo='" +codigo+ "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(codigo, item.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}