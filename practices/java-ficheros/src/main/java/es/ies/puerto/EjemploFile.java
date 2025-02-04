package es.ies.puerto;

import es.ies.puerto.model.FileOperaciones;
import es.ies.puerto.model.Persona;



public class EjemploFile {
    
    public static void main(String[] args) {
        FileOperaciones operaciones = new FileOperaciones();
        Persona persona = new Persona("00000000H", "dios");
        //System.out.println(persona);
        boolean insertar = operaciones.create(persona);
        if (insertar) {
            System.out.println("Se ha insertado correctamente");
        } else {
            System.out.println("No se ha insertado el elemento");
        }
        Persona personaUpdate = new Persona("00000000H", "Dios 2");
        operaciones.update(personaUpdate);
    }    
}