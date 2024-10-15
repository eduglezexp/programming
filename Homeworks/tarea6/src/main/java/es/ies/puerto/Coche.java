package es.ies.puerto;

/**
 * Ejercicio 3
 * Crea una clase Coche con los atributos marca, modelo y año. 
 * Incluye un constructor y métodos getter y setter para cada atributo.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Coche con marca "Toyota", modelo "Corolla", y año 2022. 
 * Muestra los atributos del coche (marca, modelo, año) usando getters.
 * Ejercicio 4
 * Modifica la clase Coche para que el setter del atributo año solo permita 
 * valores mayores o iguales a 1886 (año de creación del primer coche).
 * Instancia y uso de la clase
 * Crea un objeto de la clase Coche con marca "Ford", modelo "Mustang", y año 2020. 
 * Intenta asignar un año menor a 1886 y muestra el resultado de la validación.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Coche {
    private String marca;
    private String modelo;
    private int anio;

    public Coche() {

    }

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        setAnio(anio);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio <= 1886) {
            this.anio = 1886;
        } else {
            this.anio = anio;
        }
    }    

    @Override
    public String toString() {
        return "Coche [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
    }

    public static void main(String[] args) {
        Coche coche1 = new Coche("Toyota", "Corolla", 2022);
        System.out.printf("Marca: "+coche1.getMarca()+ "\nModelo: " +coche1.getModelo()+ 
        "\nAño: " +coche1.getAnio());
        System.out.println();
        Coche coche2 = new Coche("Ford", "Mustang", 2020);
        coche2.setAnio(1882);
        System.out.println(coche2);
    }
}