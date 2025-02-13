package es.ies.puerto.model;

public class Empleado {
    String id;
    String nombre;
    String fechaNacimiento;
    String puesto;

    public Empleado(String id) {
        this.id = id;
    }

    public Empleado(String id, String nombre, String fechaNacimiento, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + fechaNacimiento + "," + puesto ;
    }
}