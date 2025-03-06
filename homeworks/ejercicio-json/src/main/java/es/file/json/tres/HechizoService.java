package es.file.json.tres;


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

public class HechizoService   {
    ObjectMapper objectMapper;
    String path = "src/main/resources/json/hechizos.json";
    File file;
    List<Hechizo> hechizos;

    /**
     * Constructor por defecto
     */
    public HechizoService() {
        hechizos = new ArrayList<>();
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }

    /**
     * Metodo para guardar un archivo
     * @param file del hechizo
     * @param hechizos lista de hechizos
     */
    public void saveFile(File file, List<Hechizo> hechizos) {
        try {
            objectMapper.writeValue(file, hechizos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para buscar un hechizo por su identificador
     * @param id Identificador del hechizo
     * @return El hechizo encontrado o null si no existe
     */
    public Hechizo findById(int id) {
        Hechizo hechizo = new Hechizo(id);
        int posicion = hechizos.indexOf(hechizo);
        if (posicion < 0) {
            return null;
        }
        return hechizos.get(posicion);
    }

    /**
     * Metodo para buscar hechizos dentro de un rango de fechas especificado
     * @param startDate Fecha de inicio en formato YYYY-MM-DD
     * @param endDate Fecha de fin en formato YYYY-MM-DD
     * @return Lista de hechizos dentro del rango de fechas
     */
    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        List<Hechizo> hechizosFiltrados = new ArrayList<>();
        if (startDate == null || startDate.isEmpty()) {
            return hechizosFiltrados;
        }
        if (endDate == null || endDate.isEmpty()) {
            return hechizosFiltrados;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        for (Hechizo hechizo : hechizos) {
            LocalDate fechaHechizo = LocalDate.parse(hechizo.getFechaCreacion(), formatter);
            if (!fechaHechizo.isBefore(start) && !fechaHechizo.isAfter(end)) {
                hechizosFiltrados.add(hechizo);
            }
        }
        return hechizosFiltrados;
    }

    /**
     * Metodo que obtiene la lista completa de hechizos
     * @return Lista de todos los hechizos
     */
    public List<Hechizo> getList() {
        return hechizos;
    }
    
    /**
     * Metodo que carga todos los hechizos disponibles
     * @return Lista de todos los hechizos cargados
     */
    public List<Hechizo> loadAll() {
        try {
            hechizos = objectMapper.readValue(file, new TypeReference<List<Hechizo>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hechizos;
    }
    
    /**
     * Metodo para agregar un nuevo hechizo
     * @param obj hechizo a agregar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean add(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        int posicion = hechizos.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar = hechizos.add(obj);
        if (insertar) {
            saveFile(file, hechizos);
        }
        return insertar;
    }

    /**
     * Metodo que elimina un hechizo existente
     * @param obj hechizo a eliminar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean delete(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        boolean borrar = hechizos.remove(obj);
        if (borrar) {
            saveFile(file, hechizos);
        }
        return borrar;
    }
}