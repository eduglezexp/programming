package es.ies.puerto.model.services;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ies.puerto.model.entities.Usuario;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuarioServiceJson {
    ObjectMapper objectMapper;
    String path = "src/main/resources/es/ies/puerto/json/usuarios.json";
    File file;
    Set<Usuario> usuarios;

    /**
     * Constructor por defecto
     */
    public UsuarioServiceJson() {
        usuarios = new HashSet<>();
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }

    /**
     * Metodo que carga todos los usuarios disponibles
     * @return Lista de todos los usuarios cargados
     */
    public Set<Usuario> loadAll() {
        if (!file.exists()) {
            saveFile(file, usuarios); 
            return usuarios;
        }
        try {
            if (file.length() > 0) {
                usuarios = objectMapper.readValue(file, new TypeReference<Set<Usuario>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Metodo para guardar un archivo
     * @param file del usuario
     * @param usuarios lista de usuarios
     */
    public void saveFile(File file, Set<Usuario> usuarios) {
        try {
            objectMapper.writeValue(file, usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para agregar un nuevo usuario
     * @param obj caballero a agregar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean add(Usuario obj) {
        if (obj == null) {
            return false;
        }
        boolean added = usuarios.add(obj);
        if (added) {
            saveFile(file, usuarios);
        }
        return added;
    }

    /**
     * Metodo para buscar y devolver un valor que tenga el usuario
     * @param valor a buscar
     * @param criterio de lo que se le va a buscar al usuario
     * @return usuario
     */
    public Usuario buscarUsuarioPorCriterio(String valor, Function<Usuario, String> criterio) {
        if (valor == null || valor.isEmpty()) {
            return null;
        }
        for (Usuario usuario : usuarios) {
            if (criterio.apply(usuario).equals(valor)) {
                return usuario;
            }
        }
        return null;
    }
}