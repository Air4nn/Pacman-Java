package com.mycompany.pacman.vista;

import com.mycompany.pacman.modelo.Fantasma;
import com.mycompany.pacman.modelo.Mapa;
import com.mycompany.pacman.modelo.Pacman;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class PanelJuego extends JPanel {

    private Mapa mapa;
    private Pacman pacman;
    private Fantasma[] fantasmas;

    private boolean juegoGanado = false;
    private boolean juegoPerdido = false;

    private final int TAM_CELDA = 40;

    public PanelJuego(Mapa mapa, Pacman pacman, Fantasma[] fantasmas) {
        this.mapa = mapa;
        this.pacman = pacman;
        this.fantasmas = fantasmas;

        setBackground(Color.BLACK);
    }

    public void setJuegoGanado(boolean juegoGanado) {
        this.juegoGanado = juegoGanado;
    }

    public void setJuegoPerdido(boolean juegoPerdido) {
        this.juegoPerdido = juegoPerdido;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[][] matriz = mapa.getMatriz();

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {

                int x = columna * TAM_CELDA;
                int y = fila * TAM_CELDA;

                if (matriz[fila][columna] == Mapa.PARED) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, TAM_CELDA, TAM_CELDA);
                }

                if (matriz[fila][columna] == Mapa.COMIDA) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + 15, y + 15, 10, 10);
                }
            }
        }

        // Dibujar Pac-Man
        g.setColor(Color.YELLOW);
        g.fillArc(
            pacman.getX() * TAM_CELDA,
            pacman.getY() * TAM_CELDA,
            TAM_CELDA,
            TAM_CELDA,
            30,
            300
        );

        // Dibujar todos los fantasmas
        for (int i = 0; i < fantasmas.length; i++) {

            Fantasma fantasma = fantasmas[i];

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
        }

        // Mostrar puntaje y vidas
        g.setColor(Color.WHITE);
        g.drawString("Puntaje: " + pacman.getPuntaje(), 10, 20);
        g.drawString("Vidas: " + pacman.getVidas(), 10, 40);

        // Mensaje de victoria
        if (juegoGanado) {
            g.setColor(Color.GREEN);
            g.drawString("¡GANASTE!", 250, 250);
        }

        // Mensaje de derrota
        if (juegoPerdido) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 250, 270);
        }
    }
    
    public void actualizarDatos(Mapa mapa, Pacman pacman, Fantasma[] fantasmas) {
        this.mapa = mapa;
        this.pacman = pacman;
        this.fantasmas = fantasmas;
    }

    @Override
    public Dimension getPreferredSize() {
        int ancho = mapa.getColumnas() * TAM_CELDA;
        int alto = mapa.getFilas() * TAM_CELDA;

        return new Dimension(ancho, alto);
    }
}