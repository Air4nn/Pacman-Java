package com.mycompany.pacman;

import javax.swing.JFrame;

// Clase principal del juego
public class Juego {

    public static void main(String[] args) {

        // Crear el mapa
        Mapa mapa = new Mapa();

        // Crear a Pac-Man
        Pacman pacman = new Pacman(1, 1);

        // Lista de fantasmas (Nuevo)
        Fantasma[] fantasmas = new Fantasma[3];

        fantasmas[0] = new Fantasma(13, 1, mapa.getMatriz());
        fantasmas[1] = new Fantasma(13, 3, mapa.getMatriz());
        fantasmas[2] = new Fantasma(11, 1, mapa.getMatriz());

        // Crear el panel (MModifique esto)
        PanelJuego panel = new PanelJuego(mapa, pacman, fantasmas);

        // Crear la ventana
        JFrame ventana = new JFrame("Pac-Man");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.pack();
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

        // Control teclado
        ventana.addKeyListener(new ControlTeclado(pacman));

        ventana.setVisible(true);

        boolean juegoGanado = false;

        // GAME LOOP
        while (true) {

            if (juegoGanado) {
                panel.repaint();
                break;
            }

            // PAacman
            pacman.mover(mapa.getMatriz());

            // Mover a los fantasmas (Nuevo)
            for (int i = 0; i < fantasmas.length; i++) {
                fantasmas[i].mover(mapa.getMatriz(), fantasmas);
            }

            // Comida
            if (mapa.hayComida(pacman.getY(), pacman.getX())) {

                mapa.comerComida(pacman.getY(), pacman.getX());
                pacman.sumarPuntos(10);

                if (!mapa.quedaComida()) {

                    juegoGanado = true;
                    panel.setJuegoGanado(true);

                    System.out.println("¡Ganaste!");
                }
            }

            // Choque de fantasmas (Nuevo)
            for (int i = 0; i < fantasmas.length; i++) {

                if (fantasmas[i].getX() == pacman.getX() &&
                    fantasmas[i].getY() == pacman.getY()) {

                    System.out.println("💀 Pacman fue atrapado");
                }
            }

            panel.repaint();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
