package es.ies.puerto.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;
import es.ies.puerto.model.services.UsuarioServiceSqlite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class UsuariosController extends AbstractController{

    @FXML
    private Button buttonVolverAtras;

    @FXML
    private ListView<UsuarioEntitySqlite> listViewUsuarios; 

    /**
     * Metodo de inicializacion de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
        configurarListView();
        cargarUsuarios();
    }

    /**
     * Configura la visualizacion de la lista de usuarios y
     * define como se mostraran los elementos en la ListView
     */
    private void configurarListView() {
        listViewUsuarios.setCellFactory(param -> new ListCell<UsuarioEntitySqlite>() {
        @Override
        protected void updateItem(UsuarioEntitySqlite usuario, boolean empty) {
            super.updateItem(usuario, empty);
            if (empty || usuario == null) {
                setText(null);
                return;
            } 
            String idRow = ConfigManager.ConfigProperties.getProperty("idRow");
            String usuarioRow = ConfigManager.ConfigProperties.getProperty("usuarioRow");
            String emailRow = ConfigManager.ConfigProperties.getProperty("emailRow");
            String nombreRow = ConfigManager.ConfigProperties.getProperty("nombreRow");
            String formato = ""+idRow+": %s\n"+usuarioRow+": %s\n"+emailRow+": %s\n"+nombreRow+": %s";
            String texto = String.format(
                formato, 
                usuario.getId(), 
                usuario.getUser(), 
                usuario.getEmail(),
                usuario.getName()
                );
            setText(texto);
            }
        });
    }

    /**
     * Metodo que carga los usuarios desde la base de datos y los muestra en la ListView
     */
    private void cargarUsuarios() {
        try {
            UsuarioServiceSqlite service = getUsuarioServiceSqlite();
            ArrayList<UsuarioEntitySqlite> listaUsuarios = service.obtenerUsuarios();
            ObservableList<UsuarioEntitySqlite> usuarios = FXCollections.observableArrayList(listaUsuarios);
            listViewUsuarios.setItems(usuarios);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maneja el evento de clic en el boton de volver atras
     * Redirige a la pantalla de inicio de sesion (login)
     */
    @FXML
    protected void onVolverAtrasClick() {
        String tituloPantalla = ConfigManager.ConfigProperties.getProperty("loginTitle");
        mostrarPantalla(buttonVolverAtras, "login.fxml", tituloPantalla);
    }
}