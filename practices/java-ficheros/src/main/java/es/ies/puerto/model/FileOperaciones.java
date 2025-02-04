package es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.Operaciones;

public class FileOperaciones implements Operaciones{
    
    private File file;
    private String fichero = "empleados.txt";

    public FileOperaciones() {
        try {
            URL resource = getClass().getClassLoader().getResource(fichero);
            if (resource == null) {
                
            }
            file = new File(resource.toURI());
        } catch (Exception e) {
            
        }
    }

    @Override
    public boolean create(Persona persona) {
        if (persona == null || persona.getIdentificador() == null) {
            return false;
        }
        Set<Persona> personas = read(file);
        if (personas.contains(persona)) {
            return false;
        }
        return create(persona.toString(), file);
    }

    private boolean create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Set<Persona> read(File file) {
        Set<Persona> personas = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayline = line.split(",");
                Empleado empleado = new Empleado(arrayline[0], arrayline[1], arrayline[2], Double.parseDouble(arrayline[3]));
                personas.add(empleado);
            }
        } catch (IOException e) {
            return new HashSet<>();
        }
        return personas;
    }

    @Override
    public boolean update(Persona persona) {
        if (persona == null || persona.getIdentificador() == null) {
            return false;
        }
        Set<Persona> personas = read(file);
        if (personas.contains(persona)) {
            return false;
        }
        for (Persona personaBuscar : personas) {
            if (personaBuscar.equals(persona)) {
                personas.remove(personaBuscar);
                personas.add(persona);
                return updateFile(personas, file);
            }
        }
        return false;
    }

    private boolean updateFile(Set<Persona> personas, File file) {
        String path = file.getAbsolutePath();
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        for (Persona persona : personas) {
            create(persona);
        }
        return true;
    }

    @Override
    public boolean delete(Persona persona) {
        if (persona == null || persona.getIdentificador() == null) {
            return false;
        }
        Set<Persona> personas = read(file);
        if (personas.contains(persona)) {
            return false;
        }
        for (Persona personaBuscar : personas) {
            if (personaBuscar.equals(persona)) {
                personas.remove(personaBuscar);
                return updateFile(personas, file);
            }
        }
        return false;
    }

    @Override
    public Persona read(Persona persona) {
        if (persona == null || persona.getIdentificador() == null) {
            return persona;
        }
        Set<Persona> personas = read(file);
        if (personas.contains(persona)) {
            for (Persona personaBuscar : personas) {
                if (personaBuscar.equals(persona)) {
                    return personaBuscar;
                }
            }
        }
        return persona;
    }

    @Override
    public Persona read(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return null;
        }
        Persona persona = new Empleado(identificador);
        return read(persona);
    }
}