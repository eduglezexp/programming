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
    private Text textPuntos;

    @FXML
    private Text textVictorias;

    @FXML
    private Text textDerrotas;

    @FXML
    private Canvas ahorcadoCanvas;

    @FXML
    private Text textIntentos;

    @FXML
    private Text textLetrasUsadas;

    @FXML
    private Text textPalabra;

    @FXML
    private Text textPalabraMostrar;

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
    private int puntosUsuario;
    private String emailUsuario;
    private String palabraSecreta;   
    private char[] estadoPalabra;    
    private int intentosRestantes; 
    private StringBuilder letrasUtilizadas;
    private int victorias = 0;
    private int derrotas = 0;
    private boolean juegoTerminado = false;
    private final int umbralVictorias = 3;

    /**
     * Metodo que se ejecuta al iniciar el controlador
     * Se encarga de cambiar el idioma de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Carga los datos del usuario en la vista
     * Inicializa nivel puntos victorias derrotas y comienza el juego
     */
    public void cargarDatosUsuario(UsuarioEntitySqlite usuario) {
        if (usuario != null) {
            nivelUsuario = usuario.getIdNivel();
            puntosUsuario = usuario.getPuntos();
            emailUsuario = usuario.getEmail();
            victorias = usuario.getVictorias();
            derrotas = usuario.getDerrotas();
            usernameSinPrefijo = usuario.getUser();
            String usuarioStr = ConfigManager.ConfigProperties.getProperty("usuarioStr");
            String nivelStr = ConfigManager.ConfigProperties.getProperty("nivelStr");
            String puntosStr = ConfigManager.ConfigProperties.getProperty("puntosStr");
            String victoriasStr = ConfigManager.ConfigProperties.getProperty("victoriasStr");
            String derrotasStr = ConfigManager.ConfigProperties.getProperty("derrotasStr");
            textUsuarioMostrar.setText(usuarioStr + usuario.getUser());
            textPuntos.setText(puntosStr + usuario.getPuntos());
            textVictorias.setText(victoriasStr + usuario.getVictorias());
            textDerrotas.setText(derrotasStr + usuario.getDerrotas());
            try {
                List<NivelEntitySqlite> nivel = getNivelServiceSqlite().obtenerNivelPorUsuario(nivelUsuario);
                textNivel.setText(nivelStr + nivel.get(0).getNivel());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            iniciarJuego();
        }
    }

    /**
     * Obtiene el nivel actual del usuario
     * @return nivel del usuario
     */
    private int obtenerNivelUsuario() {
        return nivelUsuario;
    }

    /**
     * Dibuja el estado actual del ahorcado en el canvas
     */
    private void dibujarAhorcado() {
        GraphicsContext graphicsContext = ahorcadoCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, ahorcadoCanvas.getWidth(), ahorcadoCanvas.getHeight());
        
        double centerX = ahorcadoCanvas.getWidth() / 2.0;
        double centerY = ahorcadoCanvas.getHeight() / 2.0;
        double scale = 1.2;
        int errores = calcularIntentos(palabraSecreta.length()) - intentosRestantes;
        int maxErrores = calcularIntentos(palabraSecreta.length());
    
        graphicsContext.strokeLine(centerX - 45 * scale, centerY + 80 * scale, centerX + 45 * scale, centerY + 80 * scale); // Base del ahorcado 
    
        if (errores >= 1) graphicsContext.strokeLine(centerX - 10 * scale, centerY + 80 * scale, centerX - 10 * scale, centerY - 40 * scale); // Poste vertical
        if (errores >= 2) graphicsContext.strokeLine(centerX - 10 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 40 * scale); // Travesaño
        if (errores >= 3) graphicsContext.strokeLine(centerX + 40 * scale, centerY - 40 * scale, centerX + 40 * scale, centerY - 20 * scale); // Cuerda
        if (errores >= 4) graphicsContext.strokeOval(centerX + 30 * scale, centerY - 20 * scale, 20 * scale, 20 * scale); // Cabeza
        if (errores >= 5) graphicsContext.strokeLine(centerX + 40 * scale, centerY, centerX + 40 * scale, centerY + 30 * scale); // Torso
        if (errores >= 6) graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 25 * scale, centerY + 20 * scale); // Brazo izquierdo
        if (errores >= 7) graphicsContext.strokeLine(centerX + 40 * scale, centerY + 10 * scale, centerX + 55 * scale, centerY + 20 * scale); // Brazo derecho
        if (errores >= 8) graphicsContext.strokeLine(centerX + 40 * scale, centerY + 30 * scale, centerX + 25 * scale, centerY + 40 * scale); // Pierna izquierda
        if (errores >= 9) graphicsContext.strokeLine(centerX + 40 * scale, centerY + 30 * scale, centerX + 55 * scale, centerY + 40 * scale); // Pierna derecha
        
        if (maxErrores > 9) {
            if (errores >= 10) graphicsContext.strokeLine(centerX + 25 * scale, centerY + 40 * scale, centerX + 15 * scale, centerY + 45 * scale); // Pie izquierdo  
            if (errores >= 11) graphicsContext.strokeLine(centerX + 55 * scale, centerY + 40 * scale, centerX + 65 * scale, centerY + 45 * scale); // Pie derecho
        }
    }
    
    /**
     * Limpia el contenido del canvas
     */
    private void limpiarCanvas() {
        GraphicsContext graphicsContext = ahorcadoCanvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, ahorcadoCanvas.getWidth(), ahorcadoCanvas.getHeight());
    }    

    /**
     * Carga una palabra aleatoria segun el nivel del usuario
     * @param nivel nivel actual del usuario
     */
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

    /**
     * Inicializa los valores del juego para una nueva partida
     */
    private void iniciarJuego() {
        cargarPalabraAleatoria(obtenerNivelUsuario());  
        intentosRestantes = calcularIntentos(palabraSecreta.length()); 
        estadoPalabra = new char[palabraSecreta.length()];
        for (int i = 0; i < estadoPalabra.length; i++) {
            estadoPalabra[i] = '_';
        }
        textPalabraMostrar.setText(formatearEstadoPalabra());
        String intentosStr = ConfigManager.ConfigProperties.getProperty("intentosStr");
        textIntentos.setText(intentosStr + intentosRestantes);
        textMensaje.setText("");
        textMensaje.setStyle("-fx-fill: red;");
        letrasUtilizadas = new StringBuilder();
        String letrasUsadasStr = ConfigManager.ConfigProperties.getProperty("letrasUsadasStr");
        textLetrasUsadas.setText(letrasUsadasStr);
        limpiarCanvas();
        dibujarAhorcado(); 
        juegoTerminado = false;
        textFieldLetra.setDisable(false);
        insertarButton.setDisable(false);
    }

    /**
     * Formatea la palabra con guiones bajos para mostrar el progreso
     * @return palabra formateada con espacios
     */
    private String formatearEstadoPalabra() {
        StringBuilder stringbuilder = new StringBuilder();
        for (char letra : estadoPalabra) {
            stringbuilder.append(letra).append(' ');
        }
        return stringbuilder.toString().trim(); 
    }
    
    /**
     * Calcula la cantidad de intentos segun el nivel y la longitud de la palabra
     * @param longitudPalabra longitud de la palabra secreta
     * @return numero de intentos permitidos
     */
    private int calcularIntentos(int longitudPalabra) {
        int base;
        switch (nivelUsuario) {
            case 3: base = 9; break;
            case 2: base = 10; break;
            case 1: 
            default: base = 11; break;
        }
        return Math.min(base, longitudPalabra);
    }

    /**
     * Metodo que se ejecuta al hacer clic en el boton de comprar
     */
    @FXML
    protected void onComprarClick() {

    }

    /**
     * Metodo que se ejecuta al hacer clic en el boton de insertar
     * Procesa la letra o palabra ingresada y actualiza el estado del juego
     */
    @FXML
    protected void onInsertarClick() {
        if (juegoTerminado) {
            return;
        }

        String letraIngresada = textFieldLetra.getText().toLowerCase();
        textFieldLetra.clear();

        if (palabraSecreta == null || palabraSecreta.isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorNoIniciado"));
            textMensaje.setStyle("-fx-fill: red;");
            return;
        }
        if (letraIngresada.isEmpty()) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("introduceLetra"));
            textMensaje.setStyle("-fx-fill: red;");
            return;
        }
        
        if (letraIngresada.length() > 1) {
            if (letraIngresada.equals(palabraSecreta)) {
                revelarPalabra();
                procesarVictoria();
                terminarJuego();
                return;
            } else {
                intentosRestantes--;
                String intentosStr = ConfigManager.ConfigProperties.getProperty("intentosStr");
                textIntentos.setText(intentosStr + intentosRestantes);
                dibujarAhorcado();
                textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorPalabra"));
                textMensaje.setStyle("-fx-fill: red;");
                if (intentosRestantes <= 0) {
                    revelarPalabra();
                    procesarDerrota();
                    terminarJuego();
                }
                return;
            }
        }

        char letra = letraIngresada.charAt(0);

        if (letrasUtilizadas.toString().contains(String.valueOf(letra))) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorLetraIntroducida"));
            textMensaje.setStyle("-fx-fill: orange;");
            return;
        }

        letrasUtilizadas.append(letra).append(" ");
        String letrasUsadasStr = ConfigManager.ConfigProperties.getProperty("letrasUsadasStr");
        textLetrasUsadas.setText(letrasUsadasStr + letrasUtilizadas.toString());

        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                estadoPalabra[i] = letra;
                acierto = true;
            }
        }
        if (!acierto) {
            intentosRestantes--;
            String intentosStr = ConfigManager.ConfigProperties.getProperty("intentosStr");
            textIntentos.setText(intentosStr + intentosRestantes);
            dibujarAhorcado(); 
        }
        textPalabraMostrar.setText(formatearEstadoPalabra());

        if (String.valueOf(estadoPalabra).equals(palabraSecreta)) {
            procesarVictoria();
        } else if (intentosRestantes <= 0) {
            revelarPalabra();
            procesarDerrota();
            terminarJuego();
        } else if (acierto) {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("bienHecho"));
            textMensaje.setStyle("-fx-fill: green;");
        } else {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("errorLetra"));
            textMensaje.setStyle("-fx-fill: red;");
        }
    }

    /**
     * Revela toda la palabra secreta al jugador
     */
    private void revelarPalabra() {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            estadoPalabra[i] = palabraSecreta.charAt(i);
        }
        textPalabraMostrar.setText(formatearEstadoPalabra());
    }    

    /**
     * Finaliza el juego desactivando los controles
     */
    private void terminarJuego() {
        juegoTerminado = true;
        textFieldLetra.setDisable(true);
        insertarButton.setDisable(true);
    }    

    /**
     * Metodo que se ejecuta cuando el jugador acierta la palabra
     * Incrementa el contador de victorias, acumula puntos y verifica si es necesario subir de nivel
     */
    private void procesarVictoria() {
        victorias++;
        int puntosGanados = 10;  
        puntosUsuario += puntosGanados;
        textMensaje.setText(String.format(ConfigManager.ConfigProperties.getProperty("puntosStr"), puntosGanados));
        textMensaje.setStyle("-fx-fill: green;");
        String puntosStr = ConfigManager.ConfigProperties.getProperty("puntosStr");
        textPuntos.setText(puntosStr + puntosUsuario);
        String victoriasStr = ConfigManager.ConfigProperties.getProperty("victoriasStr");
        textVictorias.setText(victoriasStr + victorias);
        try {
            getUsuarioServiceSqlite().actualizarPuntosVictorias(puntosUsuario, victorias, emailUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (victorias % umbralVictorias == 0) {
            subirNivel();
        }
    }

    /**
     * Metodo que se ejecuta cuando el jugador pierde
     * Resta puntos suma derrotas y verifica si debe bajar de nivel
     */
    private void procesarDerrota() {
        int puntosRestados = 5;
        puntosUsuario = Math.max(0, puntosUsuario - puntosRestados);
        String puntosStr = ConfigManager.ConfigProperties.getProperty("puntosStr");
        textPuntos.setText(puntosStr + puntosUsuario);
        derrotas++;
        textMensaje.setText(String.format(ConfigManager.ConfigProperties.getProperty("mensajeDerrota"), puntosRestados, derrotas));
        textMensaje.setStyle("-fx-fill: red;");
        String derrotasStr = ConfigManager.ConfigProperties.getProperty("derrotasStr");
        textDerrotas.setText(derrotasStr + derrotas);
        try {
            getUsuarioServiceSqlite().actualizarPuntosDerrotas(puntosRestados, derrotas, emailUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (derrotas >= 3) {
            bajarNivel();
            derrotas = 0;
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
                String nivelStr = ConfigManager.ConfigProperties.getProperty("nivelStr");
                textNivel.setText(nivelStr + nivel.get(0).getNivel());
                getUsuarioServiceSqlite().actualizarNivel(nivelUsuario, emailUsuario);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("mensajeSubirNivel"));
            textMensaje.setStyle("-fx-fill: darkblue;");
        } else {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("mensajeNivelMaximo"));
            textMensaje.setStyle("-fx-fill: blue;");
        }
    }

    /**
     * Reduce el nivel del jugador si no esta en el minimo
     */
    private void bajarNivel() {
        if (nivelUsuario > 1) {
            nivelUsuario--;
            try {
                List<NivelEntitySqlite> nivel = getNivelServiceSqlite().obtenerNivelPorUsuario(nivelUsuario);
                String nivelStr = ConfigManager.ConfigProperties.getProperty("nivelStr");
                textNivel.setText(nivelStr + nivel.get(0).getNivel());
                getUsuarioServiceSqlite().actualizarNivel(nivelUsuario, emailUsuario);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("mensajeBajarNivel"));
            textMensaje.setStyle("-fx-fill: darkred;");
        } else {
            textMensaje.setText(ConfigManager.ConfigProperties.getProperty("mensajeNivelMinimo"));
            textMensaje.setStyle("-fx-fill: red;");
        }
    }
    
    /**
     * Metodo que se ejecuta al hacer clic en el boton de reiniciar
     * Reinicia el juego con una nueva palabra
     */
    @FXML
    protected void onReiniciarClick() {
        iniciarJuego();
    }

    /**
     * Metodo que se ejecuta al hacer clic en el boton de volver atras
     * Vuelve a la pantalla de perfil del usuario
     */
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