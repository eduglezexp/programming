package es.ies.puerto.modelo.db.services.abstractas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Autor;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public abstract class AbstractService<T> extends Conexion {
    /**
     * Metodo para ejecutar una query
     * @param sql a ejectar
     * @param params a añadir
     * @return lista de algo
     * @throws SQLException error controlado
     */
    public List<T> executeQuery(String sql, String... params) {
        List<T> autores = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement sentencia = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                sentencia.setString(i + 1, params[i]);
            }
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    String dni = resultado.getString("dni");
                    String nombre = resultado.getString("nombre");
                    String nacionalidad = resultado.getString("nacionalidad");
                    Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                    //T objeto = new Autor(dni, nombre, nacionalidad, fechaNacimiento);
                    //autores.add(objeto);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return autores;
    }
}

