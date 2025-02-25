package es.file.json.uno;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class CaballeroService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/caballeros.json";
    File file;
    List<Caballero> caballeros;

    /**
     * Constructor por defecto
     */
    public CaballeroService() {
        caballeros = new ArrayList<>();
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }

    /**
     * Metodo para guardar un archivo
     * @param file del caballero
     * @param caballeros lista de caballeros
     */
    public void saveFile(File file, List<Caballero> caballeros) {
        try {
            objectMapper.writeValue(file, caballeros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para buscar un caballero por su identificador
     * @param id Identificador del caballero
     * @return El caballero encontrado o null si no existe
     */
    public Caballero findById(int id) {
        Caballero caballero = new Caballero(id);
        int posicion = caballeros.indexOf(caballero);
        if (posicion < 0) {
            return null;
        }
        return caballeros.get(posicion);
    }

    /**
     * Metodo para buscar caballeros dentro de un rango de fechas especificado
     * @param startDate Fecha de inicio en formato YYYY-MM-DD
     * @param endDate Fecha de fin en formato YYYY-MM-DD
     * @return Lista de caballero dentro del rango de fechas
     */
    public List<Caballero> findByDateRange(String startDate, String endDate) {
        List<Caballero> caballerosFiltrados = new ArrayList<>();
        if (startDate == null || startDate.isEmpty()) {
            return caballerosFiltrados;
        }
        if (endDate == null || endDate.isEmpty()) {
            return caballerosFiltrados;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        for (Caballero caballero : caballeros) {
            LocalDate fechaCaballero = LocalDate.parse(caballero.getFechaIngreso(), formatter);
            if (!fechaCaballero.isBefore(start) && !fechaCaballero.isAfter(end)) {
                caballerosFiltrados.add(caballero);
            }
        }
        return caballerosFiltrados;
    }

    /**
     * Metodo que obtiene la lista completa de caballeros
     * @return Lista de todos los caballeros
     */
    public List<Caballero> getList() {
        return caballeros;
    }
    
    /**
     * Metodo que carga todos los caballeros disponibles
     * @return Lista de todos los caballeros cargados
     */
    public List<Caballero> loadAll() {
        try {
            caballeros = objectMapper.readValue(file, new TypeReference<List<Caballero>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caballeros;
    }
    
    /**
     * Metodo para agregar un nuevo caballero
     * @param obj caballero a agregar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean add(Caballero obj) {
        if (obj == null) {
            return false;
        }
        int posicion = caballeros.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar = caballeros.add(obj);
        if (insertar) {
            saveFile(file, caballeros);
        }
        return insertar;
    }

    /**
     * Metodo que elimina un caballero existente
     * @param obj caballero a eliminar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean delete(Caballero obj) {
        if (obj == null) {
            return false;
        }
        boolean borrar = caballeros.remove(obj);
        if (borrar) {
            saveFile(file, caballeros);
        }
        return borrar;
    }
}