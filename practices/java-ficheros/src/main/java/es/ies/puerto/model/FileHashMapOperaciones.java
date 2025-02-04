package es.ies.puerto.model;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FileHashMapOperaciones extends FileOperaciones{
    public FileHashMapOperaciones() {
        super();
    }

    private Map<String, Persona> fileToMap(File file) {
        Map<String, Persona> personaMap = new TreeMap<>();
        Set<Persona> personas = super.read(file);
        for (Persona persona : personas) {
            personaMap.put(persona.getIdentificador(), persona);
        }
        return personaMap;
    }
}