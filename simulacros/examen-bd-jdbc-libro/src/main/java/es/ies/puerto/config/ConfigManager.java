package es.ies.puerto.config;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class ConfigManager {

    public static class ConfigProperties {

        private static final String PATH_FILE = "src/main/resources/app.properties";
        private static final Properties properties = new Properties();
        
        static {
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(PATH_FILE), StandardCharsets.UTF_8)) {  
                properties.load(reader); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         *  Getters and Setters
         **/
        public static String getUrlBd() {
            return properties.getProperty("urlBd");
        }
    }
}