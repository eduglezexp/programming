package es.ies.puerto.model;

public class Empleado extends Persona{
    private double salarioBase;
    private String puesto;

    public Empleado(String identificador) {
        super(identificador);
    }

    public Empleado(String identificador, String nombre, String puesto, double salarioBase) {
        super(identificador, nombre);
        this.salarioBase = salarioBase;
        this.puesto = puesto;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return getIdentificador() + "," + getNombre() + "," + getPuesto() + "," + getSalarioBase();
    }
}