package es.ies.puerto;

import es.ies.puerto.model.FileOperaciones;

public class Programa {
    public static void main(String[] args) {
        Operaciones operaciones;
        operaciones = new FileOperaciones();
        System.out.println(operaciones.read("00000000H"));
    }
}   