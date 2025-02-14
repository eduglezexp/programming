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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + fechaNacimiento + "," + puesto ;
    }
}