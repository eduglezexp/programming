package es.ies.puerto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrabajoFicheros {
    public static void main(String[] args) {
        String directorio = "/home/dam/1DAM/Programacion/programming/practices/file-example";
        String nombre = "archivo.txt";
        File archivo = new File(directorio, nombre);
        File carpeta = new File(directorio);
        System.out.println("Es un fichero:" +archivo.isFile());
        System.out.println("Es un fichero:" +carpeta.isFile());
        System.out.println("parth del fichero:" +archivo.getAbsolutePath());
        if (!archivo.exists()) {
            throw new IllegalArgumentException();
        } 
        File nuevoFichero = new File(directorio+"/nuevo.txt");
        try {
            if (!nuevoFichero.exists()) {
                nuevoFichero.createNewFile();
            } else {
                System.out.println("Error no controlado");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        create("nueva fila", archivo);
        read(archivo);
        update("nueva fila", "Juan, 26 años", archivo);
        delete("Juan, 26 años", archivo);
    }

    public static void create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine(); // Añadir una nueva línea después del registro
            System.out.println("Registro agregado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void update(String oldData, String newData, File file) {
        File tempFile = new File("temp.txt");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(oldData)) {
                    writer.write(newData);  // Reemplazar la línea
                } else {
                    writer.write(line);  // Copiar la línea tal cual
                }
                writer.newLine();
            }
    
            // Reemplazar el archivo original con el archivo temporal
            if (file.delete()) {
                tempFile.renameTo(file);
                System.out.println("Archivo actualizado.");
            } else {
                System.out.println("Error al eliminar el archivo original.");
            }
    
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    public static void delete(String dataToDelete,File file) {
        File tempFile = new File("temp.txt");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(dataToDelete)) {  // Excluir la línea a eliminar
                    writer.write(line);
                    writer.newLine();
                }
            }
    
            if (file.delete()) {
                tempFile.renameTo(file);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Error al eliminar el archivo original.");
            }
    
        } catch (IOException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }
}