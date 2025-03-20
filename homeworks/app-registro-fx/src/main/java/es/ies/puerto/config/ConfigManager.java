package es.ies.puerto.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigManager {

    public static class ConfigProperties {

        static String path;

        private static final Properties properties = new Properties();
        
        static {
            File file = new File(path);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Path: " +file.getAbsolutePath());
            }
            try {
                FileInputStream input = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(input, "UTF-8");
                properties.load(isr);
                properties.load(new FileInputStream("config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         *  Metodo estatico para obtener una propiedad
         **/
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

        public static void setPath(String path) {
            ConfigProperties.path = path;
        }
    }
}