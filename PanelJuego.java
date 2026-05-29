package com.mycompany.pacman;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

// Esta clase se encarga de dibujar el juego en pantalla
public class PanelJuego extends JPanel {

    // Referencia al mapa y a Pac-Man
    private Mapa mapa;
    private Pacman pacman;

    // Tamaño de cada celda del mapa
    private final int TAM_CELDA = 40;

    // Constructor
    public PanelJuego(Mapa mapa, Pacman pacman) {

        this.mapa = mapa;
        this.pacman = pacman;

        // Fondo negro
        setBackground(Color.BLACK);
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

        // Dibujar Pac-Man
        g.setColor(Color.YELLOW);

        g.fillOval(
                pacman.getX() * TAM_CELDA,
                pacman.getY() * TAM_CELDA,
                TAM_CELDA,
                TAM_CELDA
        );
    }
}