package es.ies.puerto.controller;

import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class JuegoController extends AbstractController{

    @FXML
    private Text textUsuarioMostrar;

    @FXML
    private Text textNivel;

    @FXML
    private Canvas ahorcadoCanvas;

    @FXML
    private Text textIntentos;

    @FXML
    private Text textPalabra;

    @FXML
    private TextField textFieldLetra;

    @FXML
    private Text textMensaje;

    @FXML
    private Button puntosButton;

    @FXML
    private Button insertarButton;

    @FXML
    private Button reiniciarButton;

    @FXML
    private Button buttonVolverAtras;
    

    /**
     * Metodo de inicializacion de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Carga los datos del usuario en los campos de la interfaz grafica para Json
     * @param usuario El objeto Usuario con los datos que se mostraran en pantalla
     * Nota: Si se va a usar Json, cambiar el UsuarioEntitySqlite por UsuarioEntityJson
     */
    public void cargarDatosUsuario(UsuarioEntitySqlite usuario) {
        if (usuario != null) {
            textUsuarioMostrar.setText(usuario.getUser());
            textNivel.setText(String.valueOf(usuario.getIdNivel()));
        }
    }

    @FXML
    protected void onVerEstadisticasClick() {
        
    }

    @FXML
    protected void onInsertarClick() {
        
    }

    @FXML
    protected void onReiniciarClick() {
        
    }

    @FXML
    protected void onVolverAtrasClick() {
        try {
            List<UsuarioEntitySqlite> usuarios = getUsuarioServiceSqlite().obtenerUsuarioPorEmailOUser(textUsuarioMostrar.getText());
            if (!usuarios.isEmpty()) {
                UsuarioEntitySqlite usuario = usuarios.get(0);
                String tituloPantalla = ConfigManager.ConfigProperties.getProperty("profileTitle");
                mostrarPantalla(buttonVolverAtras, "profile.fxml", tituloPantalla, usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}