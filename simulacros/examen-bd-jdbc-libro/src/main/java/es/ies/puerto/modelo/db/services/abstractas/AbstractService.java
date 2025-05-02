package es.ies.puerto.modelo.db.services.abstractas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

 public abstract class AbstractService<T> extends Conexion {

    /**
     * Mapea una fila del ResultSet a un objeto T
     * @param rs el ResultSet apuntando a la fila actual
     * @return una instancia de T con los datos de la fila
     * @throws SQLException si ocurre un error al leer del ResultSet
     */
    protected abstract T mapRow(ResultSet rs) throws SQLException;

    /**
     * Ejecuta una consulta SQL y mapea cada fila a T usando mapRow
     * @param sql a ejecutar
     * @param params parámetros opcionales para el PreparedStatement
     * @return lista de objetos T
     */
    public List<T> executeQuery(String sql, String... params) {
        List<T> lista = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                sentencia.setString(i + 1, params[i]);
            }
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    T objeto = mapRow(resultado);
                    lista.add(objeto);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return lista;
    }
}
