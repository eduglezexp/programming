package es.ies.puerto;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;


public abstract class UtilidadesTest {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    public static final String TEST_DB = "jdbc:sqlite:test.db";

    public Date getFecha(String fecha) {
        try {
            return SDF.parse(fecha);
        } catch (ParseException e) {
            return null;
        }
    }

    @AfterEach
    public void tearDown() throws SQLException {
       
        File originalDB = new File("src/main/resources/biblioteca.db");
        File backupDB = new File("src/main/backup/biblioteca.db");  
        
        System.out.println("Path original: " + originalDB.getAbsolutePath());
        System.out.println("Path backup: " + backupDB.getAbsolutePath());
        System.out.println("Backup existe? " + backupDB.exists());
    

        if (!backupDB.exists()) {
            throw new SQLException("El archivo de backup no existe en: " + backupDB.getAbsolutePath());
        }
    

        if (originalDB.exists()) {
            boolean deleted = originalDB.delete();
            if (!deleted) {
                throw new SQLException("No se pudo eliminar la base de datos original");
            }
        }
    
        try {
            Files.copy(
                backupDB.toPath(),
                originalDB.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Base de datos restaurada exitosamente");
        } catch (IOException e) {
            throw new SQLException("Error copiando el backup", e);
        }
    }


    
}
