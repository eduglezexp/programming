package es.ies.puerto.modelo.abstractas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.ies.puerto.config.ConfigManager;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public abstract class Conexion {
    private String rutaArchivoBD;
    private Connection connection;

    /**
     * Constructor por defecto
     */
    public Conexion() {
        this.rutaArchivoBD = ConfigManager.ConfigProperties.getUrlBd();
    }

    /**
     * Getters and Setters
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
    }

    /**
     * Funcion que conecta a la bbdd
     */
    protected Connection conectar() throws SQLException{
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
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