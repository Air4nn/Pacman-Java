package com.mycompany.pacman.controlador;

import com.mycompany.pacman.modelo.Mapa;
import com.mycompany.pacman.modelo.Pacman;
import com.mycompany.pacman.modelo.Fantasma;
import com.mycompany.pacman.vista.PanelJuego;
import com.mycompany.pacman.vista.VentanaJuego;

public class ControladorJuego {

    private Mapa mapa;
    private Pacman pacman;
    private Fantasma[] fantasmas;
    private PanelJuego panel;
    private VentanaJuego ventana;

    private boolean juegoGanado;
    private boolean juegoPerdido;

    // Controlan el menú
    private boolean partidaIniciada;
    private boolean juegoPausado;

    public ControladorJuego() {

        mapa = new Mapa();

        pacman = new Pacman(1, 1);

        fantasmas = new Fantasma[4];
        fantasmas[0] = new Fantasma(13, 1);
        fantasmas[1] = new Fantasma(13, 3);
        fantasmas[2] = new Fantasma(11, 1);
        fantasmas[3] = new Fantasma(7, 4);

        panel = new PanelJuego(mapa, pacman, fantasmas);

        ventana = new VentanaJuego(
            panel,
            e -> iniciarPartida(),
            e -> pausarReanudar(),
            e -> reiniciarPartida(),
            e -> salirJuego()
        );

        ventana.addKeyListener(new ControlTeclado(pacman));

        juegoGanado = false;
        juegoPerdido = false;
        partidaIniciada = false;
        juegoPausado = false;
    }

    public void iniciar() {

        ventana.setVisible(true);

        while (true) {

            if (!partidaIniciada) {
                panel.repaint();
                esperar();
                continue;
            }

            if (juegoPausado) {
                panel.repaint();
                esperar();
                continue;
            }

            if (juegoGanado) {
                panel.repaint();
                break;
            }

            if (juegoPerdido) {
                panel.repaint();
                break;
            }

            pacman.mover(mapa.getMatriz());

            for (int i = 0; i < fantasmas.length; i++) {
                fantasmas[i].mover(mapa.getMatriz(), fantasmas);
            }

            verificarComida();

            verificarColisionFantasma();

            panel.repaint();

            esperar();
        }
    }

    private void verificarComida() {

        if (mapa.hayComida(pacman.getY(), pacman.getX())) {

            mapa.comerComida(pacman.getY(), pacman.getX());

            pacman.sumarPuntos(10);

            if (!mapa.quedaComida()) {

                juegoGanado = true;

                panel.setJuegoGanado(true);

                System.out.println("¡Ganaste!");
            }
        }
    }

    private void verificarColisionFantasma() {

        for (int i = 0; i < fantasmas.length; i++) {

            if (fantasmas[i].getX() == pacman.getX() &&
                fantasmas[i].getY() == pacman.getY()) {

                pacman.perderVida();

                System.out.println(
                    "Pac-Man fue atrapado. Vidas restantes: "
                    + pacman.getVidas()
                );

                if (pacman.estaMuerto()) {

                    juegoPerdido = true;

                    panel.setJuegoPerdido(true);

                    System.out.println("GAME OVER");
                } else {

                    pacman.reiniciarPosicion();

                    fantasmas[0].reiniciarPosicion(13, 1);
                    fantasmas[1].reiniciarPosicion(13, 3);
                    fantasmas[2].reiniciarPosicion(11, 1);
                    fantasmas[3].reiniciarPosicion(7, 4);
                }

                break;
            }
        }
    }

    private void iniciarPartida() {
        partidaIniciada = true;
        juegoPausado = false;

        System.out.println("Partida iniciada");
    }

    private void pausarReanudar() {

        if (partidaIniciada) {
            juegoPausado = !juegoPausado;

            if (juegoPausado) {
                System.out.println("Juego pausado");
            } else {
                System.out.println("Juego reanudado");
            }
        }
    }

    private void reiniciarPartida() {

        mapa = new Mapa();

        pacman = new Pacman(1, 1);

        fantasmas = new Fantasma[4];
        fantasmas[0] = new Fantasma(13, 1);
        fantasmas[1] = new Fantasma(13, 3);
        fantasmas[2] = new Fantasma(11, 1);
        fantasmas[3] = new Fantasma(7, 4);

        juegoGanado = false;
        juegoPerdido = false;
        partidaIniciada = true;
        juegoPausado = false;

        panel.actualizarDatos(mapa, pacman, fantasmas);
        panel.setJuegoGanado(false);
        panel.setJuegoPerdido(false);

        ventana.addKeyListener(new ControlTeclado(pacman));

        panel.repaint();

        System.out.println("Partida reiniciada");
    }

    private void salirJuego() {
        System.exit(0);
    }

    private void esperar() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}