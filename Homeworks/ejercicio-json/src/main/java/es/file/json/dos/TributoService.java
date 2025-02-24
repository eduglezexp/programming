package es.file.json.dos;

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

public class TributoService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/tributos.json";
    File file;
    List<Tributo> tributos;

    /**
     * Constructor por defecto
     */
    public TributoService() {
        tributos = new ArrayList<>();
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }

    /**
     * Metodo para guardar un archivo
     * @param file del tributo
     * @param tributos lista de tributos
     */
    public void saveFile(File file, List<Tributo> tributos) {
        try {
            objectMapper.writeValue(file, tributos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para buscar un tributo por su identificador
     * @param id Identificador del tributo
     * @return El tributo encontrado o null si no existe
     */
    public Tributo findById(int id) {
        Tributo tributo = new Tributo(id);
        int posicion = tributos.indexOf(tributo);
        if (posicion < 0) {
            return null;
        }
        return tributos.get(posicion);
    }

    /**
     * Metodo para buscar tributos dentro de un rango de fechas especificado
     * @param startDate Fecha de inicio en formato YYYY-MM-DD
     * @param endDate Fecha de fin en formato YYYY-MM-DD
     * @return Lista de tributos dentro del rango de fechas
     */
    public List<Tributo> findByDateRange(String startDate, String endDate) {
        List<Tributo> tributosFiltrados = new ArrayList<>();
        if (startDate == null || startDate.isEmpty()) {
            return tributosFiltrados;
        }
        if (endDate == null || endDate.isEmpty()) {
            return tributosFiltrados;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        for (Tributo tributo : tributos) {
            LocalDate fechaTributo = LocalDate.parse(tributo.getFechaSeleccion(), formatter);
            if (!fechaTributo.isBefore(start) && !fechaTributo.isAfter(end)) {
                tributosFiltrados.add(tributo);
            }
        }
        return tributosFiltrados;
    }

    /**
     * Metodo que obtiene la lista completa de tributos
     * @return Lista de todos los tributos
     */
    public List<Tributo> getList() {
        return tributos;
    }
    
    /**
     * Metodo que carga todos los tributos disponibles
     * @return Lista de todos los tributos cargados
     */
    public List<Tributo> loadAll() {
        try {
            tributos = objectMapper.readValue(file, new TypeReference<List<Tributo>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tributos;
    }
    
    /**
     * Metodo para agregar un nuevo tributo
     * @param obj Tributo a agregar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean add(Tributo obj) {
        if (obj == null) {
            return false;
        }
        int posicion = tributos.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar = tributos.add(obj);
        if (insertar) {
            saveFile(file, tributos);
        }
        return insertar;
    }

    /**
     * Metodo que elimina un tributo existente
     * @param obj Tributo a eliminar
     * @return true si la operacion fue exitosa, false en caso contrario
     */
    public boolean delete(Tributo obj) {
        if (obj == null) {
            return false;
        }
        boolean borrar = tributos.remove(obj);
        if (borrar) {
            saveFile(file, tributos);
        }
        return borrar;
    }
}