package es.ies.puerto.file.tres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar el archivo CSV de armas.
 * 
 * @author eduglezexp
 * @version 1.0.1
 */
public class FileArmasCsv {
    private static final String PATH = "src/main/resources/tres.csv";
    private List<Arma> armas;

    /**
     * Constructor por defecto
     */
    public FileArmasCsv() {
        armas = new ArrayList<>();
        cargarArmas();
    }

    /**
     * Metodo para leer el archivo CSV y cargar las armas en la lista
     */
    private void cargarArmas() {
        File archivo = new File(PATH);
        if (!archivo.exists()) {
            System.err.println("Archivo CSV no encontrado: " + PATH);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) { 
                    armas.add(new Arma(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Metodo para escribir la lista de armas en el archivo CSV
     */
    private void guardarArmas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, false))) {
            for (Arma arma : armas) {
                bw.write(arma.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Metodo para obtener una lista de armas
     * @return lista de armas
     */
    public List<Arma> obtenerArmas() {
        return new ArrayList<>(armas);
    }

    /**
     * Metodo para obtener un arma especifica
     * @param arma a obtener
     * @return el arma encontrada o null si no existe
     */
    public Arma obtenerArma(Arma arma) {
        if (arma == null || !armas.contains(arma)) {
            return null;
        }
        int index = armas.indexOf(arma);
        return armas.get(index);
    }

    /**
     * Metodo para aniadir un arma
     * @param arma a añadir
     */
    public void addArma(Arma arma) {
        if (arma == null || armas.contains(arma)) {
            return;
        }
        armas.add(arma);
        guardarArmas();
    }

    /**
     * Metodo para eliminar un arma
     * @param arma a eliminar
     */
    public void deleteArma(Arma arma) {
        if (arma == null || !armas.contains(arma)) {
            return;
        }
        armas.remove(arma);
        guardarArmas();
    }

    /**
     * Metodo para actualizar un arma existente
     * @param arma a actualizar
     */
    public void updateArma(Arma arma) {
        if (arma == null || !armas.contains(arma)) {
            return;
        }
        int index = armas.indexOf(arma);
        if (index >= 0) {
            armas.set(index, arma);
            guardarArmas();
        }
    }
}