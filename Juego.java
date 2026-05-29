package com.mycompany.pacman;

import javax.swing.JFrame;

// Clase principal del juego
public class Juego {

    public static void main(String[] args) {

        // Crear el mapa
        Mapa mapa = new Mapa();

        // Crear a Pac-Man
        Pacman pacman = new Pacman(1, 1);

        // Crear el panel donde se dibuja el juego
        PanelJuego panel = new PanelJuego(mapa, pacman);

        // Crear la ventana
        JFrame ventana = new JFrame("Pac-Man");

        // Configuración de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setSize(620, 520);

        ventana.setResizable(false);

        ventana.setLocationRelativeTo(null);

        // Agregar el panel a la ventana
        ventana.add(panel);

        // Agregar control del teclado
        ventana.addKeyListener(new ControlTeclado(pacman));

        // Mostrar ventana
        ventana.setVisible(true);

        // GAME LOOP
        // Se ejecuta constantemente mientras el juego está abierto
        while (true) {

            // Mover Pac-Man
            pacman.mover(mapa.getMatriz());

            // Redibujar pantalla
            panel.repaint();

            // Pausa para controlar velocidad del juego
            try {

                Thread.sleep(150);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}