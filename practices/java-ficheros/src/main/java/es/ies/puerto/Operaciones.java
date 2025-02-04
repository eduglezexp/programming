package es.ies.puerto;

import es.ies.puerto.model.Persona;

public interface Operaciones {
    public boolean create(Persona persona);
    public boolean update(Persona persona);
    public boolean delete(Persona persona);
    public Persona read(Persona persona);
    public Persona read(String identificador);
}
