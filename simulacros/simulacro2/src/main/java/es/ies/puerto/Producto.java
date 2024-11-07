package es.ies.puerto;

import java.util.Objects;

/**
 * Ejercicio 4: Construcción de Clases - Clase Producto
 * Descripción: Crea una clase Producto con los siguientes atributos:
 *  codigo (String)
 *  nombre (String)
 *  precio (float)
 *  identificador (String)
 * Define los métodos necesarios:
 *  Constructor para inicializar todos los atributos, y para obteber los valores de 
 *  estos en cualquier momento(get/set).
 *  Método aplicarDescuento(double porcentaje) que reduzca el precio del producto en 
 *  el porcentaje indicado.
 * Ejemplo de uso:
 *  Crear un objeto de tipo Producto, aplicar un descuento y mostrar la información 
 *  actualizada.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Producto {
    private String codigo;
    private String nombre;
    private float precio;
    private String identificador;

    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * Constructor con todas las propiedades
     * @param codigo
     * @param nombre
     * @param precio
     * @param identificador
     */
    public Producto(String codigo, String nombre, float precio, String identificador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.identificador = identificador;
    }

    /**
     * Getters and Setters
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        this.precio = precio;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Metodo para aplicar un descuento
     * @param porcentaje
     * @return float del descuento
     */
    public float aplicarDescuento(double porcentaje) {
        if (porcentaje <= 0) {
            return -1;
        }
        float descuento = (float) (precio * (porcentaje / 100));
        return precio - descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(identificador, producto.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    
    @Override
    public String toString() {
        return "Ejercicio4 [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", identificador="
                + identificador + "]";
    }
}