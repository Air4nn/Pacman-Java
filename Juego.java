package com.mycompany.pacman;

import javax.swing.JFrame;

// Clase principal del juego
public class Juego {

    public static void main(String[] args) {

        // Crear el mapa
        Mapa mapa = new Mapa();

        // Crear a Pac-Man
        Pacman pacman = new Pacman(1, 1);

        // Crear el fantasma
        Fantasma fantasma = new Fantasma(13, 1, mapa.getMatriz());

        // Crear el panel donde se dibuja el juego
        PanelJuego panel = new PanelJuego(mapa, pacman, fantasma);

        // Crear la ventana
        JFrame ventana = new JFrame("Pac-Man");

        // Configuración de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el panel a la ventana
        ventana.add(panel);

        // Ajusta automáticamente el tamaño de la ventana
        ventana.pack();

        ventana.setResizable(false);

        ventana.setLocationRelativeTo(null);

        // Agregar control del teclado
        ventana.addKeyListener(new ControlTeclado(pacman));

        // Mostrar ventana
        ventana.setVisible(true);

        // Indica si el jugador ganó
        boolean juegoGanado = false;

        // GAME LOOP
        // Se ejecuta constantemente mientras el juego está abierto
        while (true) {

            // Si el jugador ganó, se actualiza la pantalla y se detiene el ciclo
            if (juegoGanado) {
                panel.repaint();
                break;
            }

            // Mueve a Pac-Man según la dirección actual
            pacman.mover(mapa.getMatriz());

            // Mueve al fantasma automáticamente
            fantasma.mover(mapa.getMatriz());

            // Verifica si Pac-Man está sobre una comida
            if (mapa.hayComida(pacman.getY(), pacman.getX())) {

                // Elimina la comida del mapa
                mapa.comerComida(pacman.getY(), pacman.getX());

                // Suma 10 puntos al puntaje de Pac-Man
                pacman.sumarPuntos(10);

                // Verifica si ya no queda comida
                if (!mapa.quedaComida()) {

                    // Cambia el estado del juego a ganado
                    juegoGanado = true;

                    // Le avisa al panel que debe mostrar el mensaje de victoria
                    panel.setJuegoGanado(true);

                    // Mensaje en consola
                    System.out.println("¡Ganaste!");
                }
            }

            // Redibuja el panel para actualizar el mapa, Pac-Man, fantasma y puntaje
            panel.repaint();

            try {
                // Controla la velocidad del juego
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
