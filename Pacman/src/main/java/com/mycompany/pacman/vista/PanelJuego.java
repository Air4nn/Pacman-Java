// Archivo PanelJuego java del paquete vista
// Este archivo dibuja la interfaz visual y muestra informacion al jugador

package com.mycompany.pacman.vista;

import com.mycompany.pacman.modelo.Fantasma;
import com.mycompany.pacman.modelo.Mapa;
import com.mycompany.pacman.modelo.Pacman;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.io.InputStream;

public class PanelJuego extends JPanel {

    private Mapa mapa;
    private Pacman pacman;
    private Fantasma[] fantasmas;

    // Indica si el jugador gano la partida
    private boolean juegoGanado = false;

    // Indica si el jugador perdio la partida
    private boolean juegoPerdido = false;

    // Indica si el juego esta pausado
    private boolean juegoPausado = false;

    // Controla si Pac Man tiene la boca abierta o cerrada
    private boolean bocaAbierta = true;

    // Tamano de cada celda del mapa en pixeles
    private final int TAM_CELDA = 30;

    // Espacio superior para mostrar puntaje high score y tiempo
    private final int ALTO_SUPERIOR = 50;

    // Espacio inferior para mostrar vidas
    private final int ALTO_INFERIOR = 45;

    // Puntaje mas alto guardado
    private int highScore = 0;

    // Tiempo transcurrido en segundos
    private int segundosJuego = 0;

    // Indica si la partida ya inicio
    private boolean partidaIniciada = false;

    // Fuente estilo arcade
    private Font fuenteArcade;

    // Opcion seleccionada en el menu inicial
    // 0 Iniciar partida
    // 1 Salir
    private int opcionSeleccionada = 0;

    // Controla la cuenta regresiva antes de iniciar
    // 1 no mostrar nada
    // 3 2 1 cuenta regresiva
    // 0 GO
    private int cuentaRegresiva = -1;

    public PanelJuego(Mapa mapa, Pacman pacman, Fantasma[] fantasmas) {
        this.mapa = mapa;
        this.pacman = pacman;
        this.fantasmas = fantasmas;

        // Color de fondo del panel
        setBackground(Color.BLACK);

        // Cargar fuente personalizada tipo arcade desde resources fuentes
        try {
            InputStream archivoFuente =
                    getClass().getResourceAsStream("/fuentes/Pixel Emulator.otf");

            fuenteArcade = Font.createFont(
                    Font.TRUETYPE_FONT,
                    archivoFuente
            );

        } catch (Exception e) {

            // Si la fuente no carga se usa una fuente basica como respaldo
            fuenteArcade = new Font("Courier New", Font.BOLD, 16);

            e.printStackTrace();
        }
    }

    // Cambia el estado de victoria del juego
    public void setJuegoGanado(boolean juegoGanado) {
        this.juegoGanado = juegoGanado;
    }

    // Cambia el estado de derrota del juego
    public void setJuegoPerdido(boolean juegoPerdido) {
        this.juegoPerdido = juegoPerdido;
    }

    // Cambia el estado de pausa del juego
    public void setJuegoPausado(boolean juegoPausado) {
        this.juegoPausado = juegoPausado;
    }

    // Actualiza el high score que se muestra en pantalla
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    // Actualiza el tiempo transcurrido del juego
    public void setTiempo(int segundosJuego) {
        this.segundosJuego = segundosJuego;
    }

    // Cambia si la partida ya inicio o no
    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    // Cambia visualmente la opcion seleccionada del menu inicial
    public void setOpcionSeleccionada(int opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    // Cambia el numero que se muestra en la cuenta regresiva
    public void setCuentaRegresiva(int cuentaRegresiva) {
        this.cuentaRegresiva = cuentaRegresiva;
    }

    // Dibuja una decoracion en la pantalla de inicio
    // Siempre queda abajo y centrada sin importar el tamano del mapa
    private void dibujarDecoracionInicio(Graphics g) {

        // Posicion base centrada
        int centroX = getWidth() / 2;

        // Posicion vertical cerca de la parte inferior
        int y = getHeight() - 155;

        // Tamano de los dibujos decorativos
        int tamPacman = 55;
        int tamFantasma = 45;

        // Pac Man decorativo
        g.setColor(Color.YELLOW);
        g.fillArc(
                centroX - 200,
                y,
                tamPacman,
                tamPacman,
                30,
                300
        );

        // Puntos de comida decorativos
        g.setColor(Color.WHITE);
        g.fillOval(centroX - 130, y + 18, 9, 9);
        g.fillOval(centroX - 95, y + 18, 9, 9);
        g.fillOval(centroX - 60, y + 18, 9, 9);

        // Fantasmas decorativos con colores clasicos
        dibujarFantasmaDecorativo(g, centroX - 10, y + 3, tamFantasma, Color.RED);
        dibujarFantasmaDecorativo(g, centroX + 50, y + 3, tamFantasma, Color.CYAN);
        dibujarFantasmaDecorativo(g, centroX + 110, y + 3, tamFantasma, Color.ORANGE);
        dibujarFantasmaDecorativo(g, centroX + 170, y + 3, tamFantasma, Color.PINK);
    }

    // Dibuja un fantasma decorativo con ojos y paticas
    private void dibujarFantasmaDecorativo(Graphics g,int x,int y,int tam,Color color) {

        // Color principal del fantasma
        g.setColor(color);

        // Cabeza redonda
        g.fillOval(x, y, tam, tam);

        // Cuerpo rectangular
        g.fillRect(x,y + tam / 2,tam,tam / 2);

        // Paticas del fantasma
        // Se suben un poco con tam 14 para que no queden separadas del cuerpo
        g.fillOval(x, y + tam - 10, 14, 14);
        g.fillOval(x + 15, y + tam - 10, 14, 14);
        g.fillOval(x + 30, y + tam - 10, 14, 14);

        // Ojos blancos
        g.setColor(Color.WHITE);
        g.fillOval(x + 10, y + 12, 10, 13);
        g.fillOval(x + 25, y + 12, 10, 13);

        // Pupilas negras
        g.setColor(Color.BLACK);
        g.fillOval(x + 14, y + 17, 4, 4);
        g.fillOval(x + 29, y + 17, 4, 4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Pantalla de inicio
        // Si la partida todavia no ha iniciado solo se muestra esta pantalla
        // y no se dibuja el mapa ni los personajes
        if (!partidaIniciada) {

            // Fondo negro completo
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            // 
            // HIGH SCORE
            // 

            g.setFont(fuenteArcade.deriveFont(18f));
            g.setColor(Color.WHITE);

            String tituloHighScore = "HIGH SCORE";
            int xTituloHighScore =
                    (getWidth() - g.getFontMetrics().stringWidth(tituloHighScore)) / 2;

            g.drawString(tituloHighScore, xTituloHighScore, 25);

            // Valor numerico del high score
            String valorHighScore = String.valueOf(highScore);
            int xValorHighScore =
                    (getWidth() - g.getFontMetrics().stringWidth(valorHighScore)) / 2;

            g.drawString(valorHighScore, xValorHighScore, 55);

            // 
            // TITULO PAC MAN
            // 

            // Hace que el titulo parpadee cada medio segundo
            boolean mostrarTitulo = (System.currentTimeMillis() / 500) % 2 == 0;

            if (mostrarTitulo) {
                g.setFont(fuenteArcade.deriveFont(34f));
                g.setColor(Color.YELLOW);

                String titulo = "PAC-MAN";
                int xTitulo =
                        (getWidth() - g.getFontMetrics().stringWidth(titulo)) / 2;

                // Titulo centrado y un poco mas arriba del centro
                int yTitulo = getHeight() / 2 - 120;

                g.drawString(titulo, xTitulo, yTitulo);
            }

            // 
            // OPCIONES DEL MENU
            // 

            g.setFont(fuenteArcade.deriveFont(16f));

            String opcion1 = "INICIAR PARTIDA";
            String opcion2 = "SALIR";

            // Si la opcion seleccionada es iniciar se dibujan flechas a los lados
            if (opcionSeleccionada == 0) {
                opcion1 = "<  INICIAR PARTIDA  >";
            }

            // Si la opcion seleccionada es salir se dibujan flechas a los lados
            if (opcionSeleccionada == 1) {
                opcion2 = "<  SALIR  >";
            }

            int xOpcion1 =
                    (getWidth() - g.getFontMetrics().stringWidth(opcion1)) / 2;

            int xOpcion2 =
                    (getWidth() - g.getFontMetrics().stringWidth(opcion2)) / 2;

            int yOpcion1 = getHeight() / 2 - 30;
            int yOpcion2 = getHeight() / 2 + 15;

            // Color de la opcion Iniciar Partida
            if (opcionSeleccionada == 0) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.WHITE);
            }

            g.drawString(opcion1, xOpcion1, yOpcion1);

            // Color de la opcion Salir
            if (opcionSeleccionada == 1) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }

            g.drawString(opcion2, xOpcion2, yOpcion2);

            // 
            // CONTROLES DEL MENU
            // 

            g.setFont(fuenteArcade.deriveFont(11f));

            int yControles = getHeight() / 2 + 70;

            // Texto completo para calcular el centrado
            String textoCompleto =
                    "ARRIBA/ABAJO SELECCIONAR   ENTER CONFIRMAR";

            int x = (getWidth()
                    - g.getFontMetrics().stringWidth(textoCompleto)) / 2;

            // ARRIBA ABAJO en cyan
            g.setColor(Color.CYAN);
            g.drawString("ARRIBA/ABAJO", x, yControles);

            // SELECCIONAR en blanco
            x += g.getFontMetrics().stringWidth("ARRIBA/ABAJO ");

            g.setColor(Color.WHITE);
            g.drawString("SELECCIONAR", x, yControles);

            // ENTER en amarillo
            x += g.getFontMetrics().stringWidth("SELECCIONAR   ");

            g.setColor(Color.YELLOW);
            g.drawString("ENTER", x, yControles);

            // CONFIRMAR en blanco
            x += g.getFontMetrics().stringWidth("ENTER ");

            g.setColor(Color.WHITE);
            g.drawString("CONFIRMAR", x, yControles);

            // Decoracion inferior de Pac Man y fantasmas
            dibujarDecoracionInicio(g);

            // 
            // CUENTA REGRESIVA
            // 

            if (cuentaRegresiva >= 0) {

                g.setFont(fuenteArcade.deriveFont(45f));
                g.setColor(Color.YELLOW);

                String textoCuenta;

                if (cuentaRegresiva == 0) {
                    textoCuenta = "GO!";
                } else {
                    textoCuenta = String.valueOf(cuentaRegresiva);
                }

                int xCuenta =
                        (getWidth() - g.getFontMetrics().stringWidth(textoCuenta)) / 2;

                g.drawString(textoCuenta, xCuenta, getHeight() / 2 + 150);
            }

            // Sale del metodo para no dibujar el mapa detras de la pantalla de inicio
            return;
        }

        // 
        // DIBUJAR MAPA
        // 

        // Obtener la matriz del mapa
        int[][] matriz = mapa.getMatriz();

        // Recorrer filas y columnas para dibujar el laberinto
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {

                // Convertir posicion de matriz a pixeles
                int x = columna * TAM_CELDA;
                int y = fila * TAM_CELDA + ALTO_SUPERIOR;

                // Dibujar paredes
                if (matriz[fila][columna] == Mapa.PARED) {

                    // Color azul oscuro estilo arcade
                    g.setColor(new Color(0, 0, 180));
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);

                } else {
                    // Dibujar fondo negro en espacios libres
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);
                }

                // Dibujar comida normal como punto pequeno
                if (matriz[fila][columna] == Mapa.COMIDA) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + 11, y + 11, 6, 6);
                }

                // Dibujar vida extra como un corazon simple
                if (matriz[fila][columna] == Mapa.VIDA_EXTRA) {
                    g.setColor(Color.RED);

                    g.fillOval(x + 7, y + 8, 8, 8);
                    g.fillOval(x + 15, y + 8, 8, 8);

                    int[] puntosX = {x + 6, x + 24, x + 15};
                    int[] puntosY = {y + 14, y + 14, y + 25};

                    g.fillPolygon(puntosX, puntosY, 3);
                }

                // Dibujar super bolita mas grande
                if (matriz[fila][columna] == Mapa.SUPER_BOLITA) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x + 9, y + 9, 12, 12);
                }
            }
        }

        // 
        // DIBUJAR PAC MAN
        // 

        int px = pacman.getX() * TAM_CELDA;
        int py = pacman.getY() * TAM_CELDA + ALTO_SUPERIOR;

        // Angulo inicial de la boca
        int anguloInicio = 30;

        // La boca cambia de direccion segun el movimiento de Pac Man
        if (pacman.getDireccionActual().equals("DERECHA")) {
            anguloInicio = 30;
        }

        if (pacman.getDireccionActual().equals("IZQUIERDA")) {
            anguloInicio = 210;
        }

        if (pacman.getDireccionActual().equals("ARRIBA")) {
            anguloInicio = 120;
        }

        if (pacman.getDireccionActual().equals("ABAJO")) {
            anguloInicio = 300;
        }

        // Cambia el estado de la boca en cada repintado
        bocaAbierta = !bocaAbierta;

        g.setColor(Color.YELLOW);

        // Si la boca esta abierta se dibuja un arco
        if (bocaAbierta) {
            g.fillArc(px, py, TAM_CELDA, TAM_CELDA, anguloInicio, 300);
        }

        // Si la boca esta cerrada se dibuja un circulo completo
        else {
            g.fillOval(px, py, TAM_CELDA, TAM_CELDA);
        }

        // 
        // DIBUJAR FANTASMAS
        // 

        for (int i = 0; i < fantasmas.length; i++) {

            Fantasma fantasma = fantasmas[i];

            // Si Pac Man tiene super poder todos los fantasmas se ven azules
            if (pacman.tieneSuperPoder()) {
                g.setColor(Color.BLUE);
            } else {

                // Color normal de cada fantasma
                if (i == 0) {
                    g.setColor(Color.RED);
                }

                if (i == 1) {
                    g.setColor(Color.PINK);
                }

                if (i == 2) {
                    g.setColor(Color.CYAN);
                }

                if (i == 3) {
                    g.setColor(Color.ORANGE);
                }
            }

            int fx = fantasma.getX() * TAM_CELDA;
            int fy = fantasma.getY() * TAM_CELDA + ALTO_SUPERIOR;

            // Cuerpo del fantasma
            g.fillOval(fx, fy, TAM_CELDA, TAM_CELDA);
            g.fillRect(fx, fy + TAM_CELDA / 2, TAM_CELDA, TAM_CELDA / 2);

            // Patas del fantasma
            g.fillOval(fx, fy + TAM_CELDA - 8, 10, 10);
            g.fillOval(fx + 10, fy + TAM_CELDA - 8, 10, 10);
            g.fillOval(fx + 20, fy + TAM_CELDA - 8, 10, 10);

            // Ojos
            g.setColor(Color.WHITE);
            g.fillOval(fx + 6, fy + 8, 8, 10);
            g.fillOval(fx + 17, fy + 8, 8, 10);

            // Pupilas
            g.setColor(Color.BLACK);
            g.fillOval(fx + 9, fy + 12, 3, 3);
            g.fillOval(fx + 20, fy + 12, 3, 3);
        }

        // 
        // HUD PUNTAJE HIGH SCORE TIEMPO Y VIDAS
        // 

        g.setFont(fuenteArcade.deriveFont(14f));
        g.setColor(Color.WHITE);

        // Puntaje arriba a la izquierda
        g.drawString("PUNTAJE: " + pacman.getPuntaje(), 10, 25);

        // High score arriba en el centro
        String textoHighScore = "HIGH SCORE: " + highScore;
        int anchoTexto = g.getFontMetrics().stringWidth(textoHighScore);
        int centroX = getWidth() / 2 - anchoTexto / 2;

        g.drawString(textoHighScore, centroX, 25);

        // Tiempo arriba a la derecha
        String textoTiempo = "TIEMPO: " + segundosJuego + "s";
        int anchoTiempo = g.getFontMetrics().stringWidth(textoTiempo);

        g.drawString(
                textoTiempo,
                getWidth() - anchoTiempo - 10,
                25
        );

        // Vidas abajo a la izquierda
        int yVidas = ALTO_SUPERIOR + mapa.getFilas() * TAM_CELDA + 28;

        g.drawString("VIDAS:", 10, yVidas);

        // Dibujar vidas como mini Pac Man
        for (int i = 0; i < pacman.getVidas(); i++) {
            g.setColor(Color.YELLOW);
            g.fillArc(80 + i * 24, yVidas - 16, 18, 18, 30, 300);
        }

        // 
        // MENSAJES CENTRADOS
        // 

        // Mensaje de pausa
        if (juegoPausado) {
            g.setFont(fuenteArcade.deriveFont(30f));
            g.setColor(Color.WHITE);
            g.drawString(
                    "PAUSA",
                    (getWidth() - g.getFontMetrics().stringWidth("PAUSA")) / 2,
                    getHeight() / 2
            );
        }

        // Mensaje de victoria
        if (juegoGanado) {
            g.setFont(fuenteArcade.deriveFont(30f));
            g.setColor(Color.GREEN);
            g.drawString(
                    "YOU WIN",
                    (getWidth() - g.getFontMetrics().stringWidth("YOU WIN")) / 2,
                    getHeight() / 2
            );
        }

        // Mensaje de derrota
        if (juegoPerdido) {
            g.setFont(fuenteArcade.deriveFont(30f));
            g.setColor(Color.RED);
            g.drawString(
                    "GAME OVER",
                    (getWidth() - g.getFontMetrics().stringWidth("GAME OVER")) / 2,
                    getHeight() / 2
            );
        }
    }

    // Actualiza los objetos cuando se reinicia la partida
    public void actualizarDatos(Mapa mapa, Pacman pacman, Fantasma[] fantasmas) {
        this.mapa = mapa;
        this.pacman = pacman;
        this.fantasmas = fantasmas;
    }

    @Override
    public Dimension getPreferredSize() {

        // Calcula el tamano ideal del panel segun el tamano del mapa
        int ancho = mapa.getColumnas() * TAM_CELDA;
        int alto = mapa.getFilas() * TAM_CELDA + ALTO_SUPERIOR + ALTO_INFERIOR;

        return new Dimension(ancho, alto);
    }
}
