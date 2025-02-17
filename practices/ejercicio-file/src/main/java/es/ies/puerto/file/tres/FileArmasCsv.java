package es.ies.puerto.file.tres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileArmasCsv {
    static File archivo = new File("src/main/resources/tres.csv");
    static List<Arma> armas;

    /**
     * constructor vacio
     */
    public FileArmasCsv(){
        armas = new ArrayList<>();
        leer();
    }

    /**
     * metodo que devuelve todas las armas
     * @return List<Arma>
     */
    public List<Arma> obtenerArmas() {
        return armas;
    }

    /**
     * metodo que busca un arma
     * @param Arma
     * @return Arma
     */
    public Arma obtenerArma(Arma arma) {
        if (arma == null) {
            return null;
        }
        int posicion = armas.indexOf(arma);
        if (posicion > 0) {
            return null;
        }
        return armas.get(posicion);
    }

    /**
     * Metodo que permite agregar armas
     * @param Arma
     * @throws Exception
     */
    public void addArma(Arma arma) {
        if (arma == null || armas.contains(arma)) {
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))){
            armas.add(arma);
            writer.write(arma.toString());
            writer.newLine();
        } catch (Exception e) {
        }
    }

    /**
     * Metodo que elimina un arma
     * @param arma
     * @throws Exception
     */
    public void deleteArma(Arma arma) {
        if (arma == null || !armas.contains(arma)) {
            return;
        }
        armas.remove(arma);
        modificarFile();
    }

    /**
     * Metodo que actualiza la informacion de un arma
     * @param arma
     */
    public void updateArma(Arma arma) {
        if (arma == null || !armas.contains(arma)) {
            return;
        }
        armas.remove(arma);
        armas.add(arma);
        modificarFile();
    }

    /**
     * Metodo para volcar todas las criaturas al fichero
     * @throws Exception
     */
    public void modificarFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) { 
            archivo.delete();
            archivo.createNewFile();
            for (Arma arma : armas) {
                writer.write(arma.toString());
                writer.newLine();
            }
        }catch(Exception e){

        }
    }

    /**
     * metodo para hacer que la lista statica tenga toda la informacion del fichero
     * @throws Exception
     */
    private void leer(){
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(",");
                int cantidad = lines.length; 
                String[] descripcionArray = line.split("\"");
                String descripcion = "\"" + descripcionArray[1] + "\"" ;
                int fuerza = Integer.parseInt(lines[cantidad-1]);
                Arma arma = new Arma(lines[0], lines[1], descripcion, lines[cantidad-2], fuerza);
                armas.add(arma);
            }

        } catch (Exception e) {
        }
    }
}
