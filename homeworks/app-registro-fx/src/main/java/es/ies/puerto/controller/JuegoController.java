package es.ies.puerto.controller;

import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.controller.abstractas.AbstractController;
import es.ies.puerto.model.entities.NivelEntitySqlite;
import es.ies.puerto.model.entities.PalabraEntitySqlite;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    private String usernameSinPrefijo;
    private int nivelUsuario;
    private String palabraSecreta;   
    private char[] estadoPalabra;    
    private int intentosRestantes; 

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
            nivelUsuario = usuario.getIdNivel();
            usernameSinPrefijo = usuario.getUser();
            textUsuarioMostrar.setText("Usuario: " + usuario.getUser());
            try {
                List<NivelEntitySqlite> nivel = getNivelServiceSqlite().obtenerNivelPorUsuario(usuario.getIdNivel());
                textNivel.setText("Nivel: " + nivel.get(0).getNivel());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            iniciarJuego();
        }
    }

    private int obtenerNivelUsuario() {
        return nivelUsuario;
    }

    private void dibujarAhorcado() {
        GraphicsContext graphicsContext = ahorcadoCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, ahorcadoCanvas.getWidth(), ahorcadoCanvas.getHeight());
        
        double centerX = ahorcadoCanvas.getWidth() / 2.0;
        double centerY = ahorcadoCanvas.getHeight() / 2.0;
        
        double scale = 1.2;
        
        int errores = 9 - intentosRestantes;
        
        // base
        graphicsContext.strokeLine(centerX - 45 * scale, centerY + 80 * scale, centerX + 45 * scale, centerY + 80 * scale);
    
        if (errores >= 1) {
            // Poste vertical
            graphicsContext.strokeLine(centerX - 10 * scale, centerY + 80 * scale, centerX - 10 * scale, centerY - 40 * scale);
        }
        if (errores >= 2) {
            // Poste horizontal
            graphicsContext.strokeLine(centerX - 10 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 40 * scale);
        }
        if (errores >= 3) {
            // Cuerda
            graphicsContext.strokeLine(centerX + 40 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 20 * scale);
        }
        if (errores >= 4) {
            // Cabeza
            graphicsContext.strokeOval(centerX + 30 * scale, centerY - 20 * scale, 20 * scale, 20 * scale);
        }
        if (errores >= 5) {
            // Cuerpo
            graphicsContext.strokeLine(centerX + 40 * scale, centerY, centerX + 40 * scale, centerY + 30 * scale);
        }
        if (errores >= 6) {
            // Brazo izquierdo
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 25 * scale, centerY + 20 * scale);
        }
        if (errores >= 7) {
            // Brazo derecho
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 55 * scale, centerY + 20 * scale);
        }
        if (errores >= 8) {
            // Pierna izquierda
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 30 * scale, centerX + 25 * scale, centerY + 40 * scale);
        }
        if (errores >= 9) {
            // Pierna derecha
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 30 * scale, centerX + 55 * scale, centerY + 40 * scale);
        }
    }    
     
    private void limpiarCanvas() {
        GraphicsContext graphicsContext = ahorcadoCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, ahorcadoCanvas.getWidth(), ahorcadoCanvas.getHeight());
    }    

    private void cargarPalabraAleatoria(int nivel) {
        try {
            List<PalabraEntitySqlite> palabras = getPalabraServiceSqlite().obtenerPalabraAleatoriaPorNivel(nivel);
            if (!palabras.isEmpty()) {
                this.palabraSecreta = palabras.get(0).getPalabra().toLowerCase();
            } else {
                this.palabraSecreta = "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void iniciarJuego() {
        cargarPalabraAleatoria(obtenerNivelUsuario());  
        intentosRestantes = 9; 
        estadoPalabra = new char[palabraSecreta.length()];
        for (int i = 0; i < estadoPalabra.length; i++) {
            estadoPalabra[i] = '_';
        }
        textPalabra.setText(formatearEstadoPalabra());
        textIntentos.setText("Intentos: " + intentosRestantes);
        textMensaje.setText("");
        textMensaje.setStyle("-fx-fill: red;");
        limpiarCanvas();
        dibujarAhorcado(); 
    }

    private String formatearEstadoPalabra() {
        StringBuilder stringbuilder = new StringBuilder();
        for (char letra : estadoPalabra) {
            stringbuilder.append(letra).append(' ');
        }
        return stringbuilder.toString().trim(); 
    }
    

    @FXML
    protected void onVerEstadisticasClick() {
        
    }

    @FXML
    protected void onInsertarClick() {
        String letraIngresada = textFieldLetra.getText().toLowerCase();
        textFieldLetra.clear();

        if (palabraSecreta == null || palabraSecreta.isEmpty()) {
            textMensaje.setText("No hay juego iniciado");
            return;
        }
        if (letraIngresada.isEmpty()) {
            textMensaje.setText("Introduce una letra válida");
            return;
        }

        if (letraIngresada.equals(palabraSecreta)) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                estadoPalabra[i] = palabraSecreta.charAt(i);
            }
            textPalabra.setText(formatearEstadoPalabra());
            textMensaje.setText("¡Has ganado!");
            textMensaje.setStyle("-fx-fill: green;");
            return;
        }

        char letra = letraIngresada.charAt(0);

        for (char c : estadoPalabra) {
            if (c == letra) {
                textMensaje.setText("Ya has introducido esa letra");
                return;
            }
        }

        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                estadoPalabra[i] = letra;
                acierto = true;
            }
        }
        if (!acierto) {
            intentosRestantes--;
            textIntentos.setText("Intentos: " + intentosRestantes);
            dibujarAhorcado(); 
        }

        textPalabra.setText(formatearEstadoPalabra());

        if (String.valueOf(estadoPalabra).equals(palabraSecreta)) {
            textMensaje.setText("¡Has ganado!");
            textMensaje.setStyle("-fx-fill: green;");
        } else if (intentosRestantes <= 0) {
            textMensaje.setText("¡Has perdido! La palabra era: " + palabraSecreta);
            textMensaje.setStyle("-fx-fill: red;");
        } else if (acierto) {
            textMensaje.setText("¡Bien hecho!");
            textMensaje.setStyle("-fx-fill: green;");
        } else {
            textMensaje.setText("Letra incorrecta");
            textMensaje.setStyle("-fx-fill: red;");
        }
    }


    @FXML
    protected void onReiniciarClick() {
        iniciarJuego();
    }

    @FXML
    protected void onVolverAtrasClick() {
        try {
            List<UsuarioEntitySqlite> usuarios = getUsuarioServiceSqlite().obtenerUsuarioPorEmailOUser(usernameSinPrefijo);
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