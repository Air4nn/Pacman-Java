package com.mycompany.pacman;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

// Esta clase se encarga de dibujar el juego en pantalla
public class PanelJuego extends JPanel {

    // Referencia al mapa, Pac-Man y fantasma
    private Mapa mapa;
    private Pacman pacman;
    private Fantasma fantasma;

    // Indica si el jugador ganó
    private boolean juegoGanado = false;

    // Tamaño de cada celda del mapa
    private final int TAM_CELDA = 40;

    // Constructor
    public PanelJuego(Mapa mapa, Pacman pacman, Fantasma fantasma) {
        this.mapa = mapa;
        this.pacman = pacman;
        this.fantasma = fantasma;

        setBackground(Color.BLACK);
    }

    // Cambia el estado de victoria del juego
    public void setJuegoGanado(boolean juegoGanado) {
        this.juegoGanado = juegoGanado;
    }

    // Método que dibuja todos los elementos
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Obtener la matriz del mapa
        int[][] matriz = mapa.getMatriz();

        // Recorrer todas las filas
        for (int fila = 0; fila < matriz.length; fila++) {

            // Recorrer todas las columnas
            for (int columna = 0; columna < matriz[fila].length; columna++) {

                // Convertir posiciones de matriz a pixeles
                int x = columna * TAM_CELDA;
                int y = fila * TAM_CELDA;

                // Dibujar paredes
                if (matriz[fila][columna] == Mapa.PARED) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);
                }

                // Dibujar espacios vacíos
                else {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);
                }

                // Dibujar comida
                if (matriz[fila][columna] == Mapa.COMIDA) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + 15, y + 15, 10, 10);
                }
            }
        }

        // Dibujar Pac-Man con forma de boca
        g.setColor(Color.YELLOW);

        g.fillArc(
            pacman.getX() * TAM_CELDA,
            pacman.getY() * TAM_CELDA,
            TAM_CELDA,
            TAM_CELDA,
            30,
            300
        );

        // Dibujar fantasma
        g.setColor(Color.RED);

        // Cabeza del fantasma
        g.fillOval(
            fantasma.getX() * TAM_CELDA,
            fantasma.getY() * TAM_CELDA,
            TAM_CELDA,
            TAM_CELDA
        );

        // Cuerpo del fantasma
        g.fillRect(
            fantasma.getX() * TAM_CELDA,
            fantasma.getY() * TAM_CELDA + 20,
            TAM_CELDA,
            20
        );

        // Mostrar el puntaje en pantalla
        g.setColor(Color.WHITE);

        g.drawString(
            "Puntaje: " + pacman.getPuntaje(),
            10,
            20
        );

        // Mostrar las vidas de Pac-Man en pantalla
        g.drawString(
            "Vidas: " + pacman.getVidas(),
            10,
            40
        );

        // Mostrar mensaje de victoria si ya no queda comida
        if (juegoGanado) {
            g.setColor(Color.GREEN);

            g.drawString(
                "¡GANASTE!",
                250,
                250
            );
        }
    }

    // Este método calcula automáticamente el tamaño ideal del panel.
    // Se usa junto con ventana.pack() en la clase Juego.
    @Override
    public Dimension getPreferredSize() {

        // Calcula el ancho total: columnas del mapa * tamaño de celda
        int ancho = mapa.getColumnas() * TAM_CELDA;

        // Calcula el alto total: filas del mapa * tamaño de celda
        int alto = mapa.getFilas() * TAM_CELDA;

        // Devuelve el tamaño que debe tener el panel
        return new Dimension(ancho, alto);
    }
}
