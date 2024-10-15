package es.ies.puerto;

/**
 * Ejercicio 8
 * Crea una clase Empleado con los atributos nombre, puesto y salario. 
 * Usa getters y setters para cada atributo. El salario no puede ser negativo.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Empleado con nombre "Ana", puesto "Gerente", 
 * y salario 5000. Asegúrate de que el salario no sea negativo.
 * Ejercicio 9
 * Modifica la clase Empleado para que el setter de puesto no permita 
 * valores vacíos o nulos.
 * Instancia y uso de la clase
 * Crea un objeto de la clase Empleado con nombre "Carlos", puesto "Ingeniero" 
 * y salario 3000. Intenta asignar un puesto vacío y muestra el resultado de 
 * la validación.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Empleado {
    private String nombre;
    private String puesto;
    private float salario;
    
    public Empleado() {
    }

    

    public Empleado(String nombre, float salario) {
        this.nombre = nombre;
        this.salario = salario;
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
        if (puesto.trim().length() == 0 || puesto == null){
            this.puesto = "puesto";
        } else {
            this.puesto = puesto;
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario < 0) {
            this.salario = 0;
        } else {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", puesto=" + puesto + ", salario=" + salario + "]";
    }

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Ana", "Gerente", 5000);
        System.out.println(empleado1);
        Empleado empleado2 = new Empleado("Carlos", null , 3000);
        System.out.println(empleado2);
    }
}