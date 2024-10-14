package es.ies.puerto;

/**
 * Ejercicio 8
 * Crea una clase Empleado con los atributos nombre, puesto y salario. 
 * Usa getters y setters para cada atributo. El salario no puede ser negativo.
 * Ejercicio 9
 * Modifica la clase Empleado para que el setter de puesto no permita 
 * valores vacíos o nulos.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Empleado {
    private String nombre;
    private String puesto;
    private float salario;
    
    public Empleado() {
    }

    public Empleado(String nombre, String puesto, float salario) {
        this.nombre = nombre;
        setPuesto(puesto);
        setSalario(salario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto.equals("") || puesto == null){
            this.puesto = "puesto";
        } 
        this.puesto = puesto;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario < 0) {
            this.salario = 0;
        }
        this.salario = salario;
    }
}
