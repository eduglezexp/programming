package es.ies.puerto.model.services;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ies.puerto.model.entities.Usuario;

public class UsuarioServiceJson {
    ObjectMapper objectMapper;
    String path = "src/main/resources/es/ies/puerto/json/usuarios.json";
    File file;
    Set<Usuario> usuarios;

    public UsuarioServiceJson() {
        usuarios = new HashSet<>();
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }

    public Set<Usuario> loadAll() {
        try {
            usuarios = objectMapper.readValue(file, new TypeReference<Set<Usuario>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void saveFile(File file, Set<Usuario> usuarios) {
        try {
            objectMapper.writeValue(file, usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean add(Usuario obj) {
        if (obj == null) {
            return false;
        }
        usuarios.add(obj);
        saveFile(file, usuarios);
        return true;
    }
}