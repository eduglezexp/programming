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

public class JuegoController extends AbstractController{

    @FXML
    private Text textUsuarioMostrar;

    @FXML
    private Text textNivel;

    @FXML
    private Text textPuntos;

    @FXML
    private Text textVictorias;

    @FXML
    private Canvas ahorcadoCanvas;

    @FXML
    private Text textIntentos;

    @FXML
    private Text textLetrasUsadas;

    @FXML
    private Text textPalabra;

    @FXML
    private TextField textFieldLetra;

    @FXML
    private Text textMensaje;

    @FXML
    private Button tiendaButton;

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
    private StringBuilder letrasUtilizadas;
    private int victorias = 0;
    private int puntosTotales = 0;
    private final int umbralVictorias = 3;

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

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
        
        graphicsContext.strokeLine(centerX - 45 * scale, centerY + 80 * scale, centerX + 45 * scale, centerY + 80 * scale);
    
        if (errores >= 1) {
            graphicsContext.strokeLine(centerX - 10 * scale, centerY + 80 * scale, centerX - 10 * scale, centerY - 40 * scale);
        }
        if (errores >= 2) {
            graphicsContext.strokeLine(centerX - 10 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 40 * scale);
        }
        if (errores >= 3) {
            graphicsContext.strokeLine(centerX + 40 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 20 * scale);
        }
        if (errores >= 4) {
            graphicsContext.strokeOval(centerX + 30 * scale, centerY - 20 * scale, 20 * scale, 20 * scale);
        }
        if (errores >= 5) {
            graphicsContext.strokeLine(centerX + 40 * scale, centerY, centerX + 40 * scale, centerY + 30 * scale);
        }
        if (errores >= 6) {
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 25 * scale, centerY + 20 * scale);
        }
        if (errores >= 7) {
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 55 * scale, centerY + 20 * scale);
        }
        if (errores >= 8) {
            graphicsContext.strokeLine(centerX + 40 * scale, centerY + 30 * scale, centerX + 25 * scale, centerY + 40 * scale);
        }
        if (errores >= 9) {
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
        letrasUtilizadas = new StringBuilder();
        textLetrasUsadas.setText("Letras usadas: ");
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
    protected void onComprarClick() {

    }

    @FXML
    protected void onInsertarClick() {
        String letraIngresada = textFieldLetra.getText().toLowerCase();
        textFieldLetra.clear();

        if (palabraSecreta == null || palabraSecreta.isEmpty()) {
            textMensaje.setText("No hay juego iniciado");
            textMensaje.setStyle("-fx-fill: red;");
            return;
        }
        if (letraIngresada.isEmpty()) {
            textMensaje.setText("Introduce una letra válida");
            textMensaje.setStyle("-fx-fill: red;");
            return;
        }

        if (letraIngresada.length() > 1) {
            if (letraIngresada.equals(palabraSecreta)) {
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    estadoPalabra[i] = palabraSecreta.charAt(i);
                }
                textPalabra.setText(formatearEstadoPalabra());
                procesarVictoria();
                return;
            } else {
                intentosRestantes--;
                textIntentos.setText("Intentos: " + intentosRestantes);
                dibujarAhorcado();
                textMensaje.setText("Palabra incorrecta");
                textMensaje.setStyle("-fx-fill: red;");
                if (intentosRestantes <= 0) {
                    textMensaje.setText("¡Has perdido! La palabra era: " + palabraSecreta);
                    textMensaje.setStyle("-fx-fill: red;");
                }
                return;
            }
        }

        char letra = letraIngresada.charAt(0);

        if (letrasUtilizadas.toString().contains(String.valueOf(letra))) {
            textMensaje.setText("Ya has introducido esa letra");
            textMensaje.setStyle("-fx-fill: orange;");
            return;
        }

        letrasUtilizadas.append(letra).append(" ");
        textLetrasUsadas.setText("Letras usadas: " + letrasUtilizadas.toString());

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
            procesarVictoria();
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

    /**
     * Metodo que se ejecuta cuando el jugador acierta la palabra
     * Incrementa el contador de victorias, acumula puntos y verifica si es necesario subir de nivel
     */
    private void procesarVictoria() {
        victorias++;
        int puntosGanados = 10;  
        puntosTotales += puntosGanados;
        textMensaje.setText("¡Has ganado! +" + puntosGanados + " puntos");
        textMensaje.setStyle("-fx-fill: green;");
        textPuntos.setText("Puntos: " + puntosTotales);
        textVictorias.setText("Victorias: " + victorias);
        if (victorias % umbralVictorias == 0) {
            subirNivel();
        }
    }

    /**
     * Incrementa el nivel y actualiza la dificultad
     */
    private void subirNivel() {
        if (nivelUsuario < 3) {
            nivelUsuario++;
            try {
                List<NivelEntitySqlite> nivel = getNivelServiceSqlite().obtenerNivelPorUsuario(nivelUsuario);
                textNivel.setText("Nivel: " + nivel.get(0).getNivel());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            textMensaje.setText("¡Subiste de nivel!");
            textMensaje.setStyle("-fx-fill: darkblue;");
        } else {
            textMensaje.setText("Nivel máximo alcanzado");
            textMensaje.setStyle("-fx-fill: blue;");
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