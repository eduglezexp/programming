package es.ies.puerto.modelo.db.services;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ies.puerto.modelo.db.entidades.Prestamo;
import es.ies.puerto.modelo.db.services.abstractas.Conexion;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class PrestamoService extends Conexion{

    /**
     * Metodo para crear un prestamo
     * @param prestamo a crear
     */
    public boolean crearPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (id_prestamo, libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement sentencia = getConnection().prepareStatement(sql)) {
            sentencia.setString(1, prestamo.getIdPrestamo());
            sentencia.setString(2, prestamo.getLibroId());
            sentencia.setString(3, prestamo.getUsuarioId());
            sentencia.setDate(4, null);
            sentencia.setString(5, null);
            boolean resultado = sentencia.executeUpdate() > 0;
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Prestamo> obtenerTodosPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        
        return prestamos;
    }

    public Prestamo obtenerPrestamoPorId(String id) {
        Prestamo prestamo = null;

       
        return prestamo;
    }

    public boolean actualizarPrestamo(Prestamo prestamo) {
        return false;
    }

    public boolean eliminarPrestamo(String id) {
        return false;
    }


    public List<Prestamo> obtenerPrestamosVencidos(Date fechaLimite) {
        List<Prestamo> resultado = new ArrayList<>();
        
        return resultado;
    }

    public List<Prestamo> obtenerPrestamosPorUsuario(String idUsuario) {
        List<Prestamo> resultado = new ArrayList<>();
        

        return resultado;
    }

    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> resultado = new ArrayList<>();
        

        return resultado;
    }
}
