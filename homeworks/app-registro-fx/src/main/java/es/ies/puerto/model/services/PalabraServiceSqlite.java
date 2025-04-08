package es.ies.puerto.model.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.model.abstractas.Conexion;
import es.ies.puerto.model.entities.PalabraEntitySqlite;

public class PalabraServiceSqlite extends Conexion{

    /**
     * Constructor por defecto
     */
    public PalabraServiceSqlite() {

    }

    /**
     * Contructor con la ruta del archivo de la bbdd
     * @param unaRutaArchivoBD path de la bbdd
     * @throws SQLException error controlado
     */
    public PalabraServiceSqlite(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public List<PalabraEntitySqlite> obtenerPalabraAleatoriaPorNivel(int nivel) throws SQLException {
        String sql = "SELECT * FROM palabras WHERE id_nivel = ? ORDER BY RANDOM() LIMIT 1";
        return obtenerPalabra(sql, Integer.toString(nivel));
    }

    private List<PalabraEntitySqlite> obtenerPalabra(String sql, String... parametros) throws SQLException{
        List<PalabraEntitySqlite> palabras = new ArrayList<PalabraEntitySqlite>();
        try {
            PreparedStatement sentencia = getConnection().prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setString(i + 1, parametros[i]);
            }
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                int palabraId = resultado.getInt("id");
                String palabraStr = resultado.getString("palabra");
                int idNivel = resultado.getInt("id_nivel");
                PalabraEntitySqlite palabra = new PalabraEntitySqlite(palabraId, palabraStr, idNivel);
                palabras.add(palabra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
        return palabras;
    }
}   
