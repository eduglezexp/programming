package es.ies.puerto.modelo.db.services.abstractas;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

import es.ies.puerto.config.ConfigManager;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public abstract class Conexion {
    private String rutaArchivoBD;
    private Connection connection;
    private final SQLiteConfig config;

    /**
     * Constructor por defecto que devuelve una nueva conexión usando 
     * la configuración (incluye formato de fecha)
     */
    public Conexion() {
        this.rutaArchivoBD = ConfigManager.ConfigProperties.getUrlBd();
        this.config = new SQLiteConfig();
        this.config.setDateStringFormat("yyyy-MM-dd");
    }

    /**
     * Getters and Setters
     */
    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + rutaArchivoBD;
        return config.createConnection(url);
    }

    /**
     * Funcion que conecta a la bbdd
     */
    protected Connection conectar() throws SQLException{
        if (connection == null || connection.isClosed()) {
            connection = getConnection();
        }
        return connection;
    }

    /**
     * Funcion que cierra la conexion a la bbdd
     */
    protected void cerrar() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close(); 
            connection = null;
        }
    }
}