package com.mycompany.pacman.controlador;

import com.mycompany.pacman.modelo.Mapa;
import com.mycompany.pacman.modelo.Pacman;
import com.mycompany.pacman.modelo.Fantasma;
import com.mycompany.pacman.modelo.GestorPuntaje;
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

    // Controlan el menú y el estado del juego
    private boolean partidaIniciada;
    private boolean juegoPausado;

    // Guarda el tiempo transcurrido en segundos
    private int segundosJuego;

    // Cuenta ciclos para calcular aproximadamente 1 segundo
    private int contadorCiclos;

    // Maneja el high score guardado en archivo
    private GestorPuntaje gestorPuntaje;

    // Hilo encargado de mover los fantasmas automáticamente
    private HiloFantasma hiloFantasma;

    // Controla qué opción del menú inicial está seleccionada
    // 0 = Iniciar partida
    // 1 = Salir
    private int opcionMenu;

    public ControladorJuego() {

        // Crear mapa
        mapa = new Mapa();

        // Crear Pac-Man en su posición inicial
        pacman = new Pacman(1, 1);

        // Crear fantasmas en posiciones iniciales
        fantasmas = new Fantasma[4];
        fantasmas[0] = new Fantasma(10, 10);
        fantasmas[1] = new Fantasma(9, 10);
        fantasmas[2] = new Fantasma(11, 10);
        fantasmas[3] = new Fantasma(10, 9);

        // Crear panel donde se dibuja el juego
        panel = new PanelJuego(mapa, pacman, fantasmas);

        // Crear ventana y conectar las opciones del menú superior
        ventana = new VentanaJuego(
            panel,
            e -> iniciarPartida(),
            e -> pausarReanudar(),
            e -> reiniciarPartida(),
            e -> salirJuego()
        );

        // El teclado controla el menú inicial y luego a Pac-Man
        ventana.addKeyListener(new ControlTeclado(pacman, this));

        juegoGanado = false;
        juegoPerdido = false;
        partidaIniciada = false;
        juegoPausado = false;

        segundosJuego = 0;
        contadorCiclos = 0;

        opcionMenu = 0;

        // Crear gestor para cargar y guardar el high score
        gestorPuntaje = new GestorPuntaje();

        // Crear el hilo de fantasmas, pero todavía no se inicia
        hiloFantasma = new HiloFantasma(fantasmas, mapa, panel);

        // Configuración inicial del panel
        panel.setHighScore(gestorPuntaje.cargarHighScore());
        panel.setJuegoPausado(false);
        panel.setPartidaIniciada(false);
        panel.setTiempo(0);
        panel.setOpcionSeleccionada(opcionMenu);
    }

    public void iniciar() {

        // Mostrar ventana
        ventana.setVisible(true);

        // Iniciar hilo de fantasmas
        hiloFantasma.start();

        // Game loop principal
        while (true) {

            if (!partidaIniciada) {
                hiloFantasma.setPausado(true);
                panel.repaint();
                esperar();
                continue;
            }

            if (juegoPausado) {
                hiloFantasma.setPausado(true);
                panel.repaint();
                esperar();
                continue;
            }

            if (juegoGanado) {
                hiloFantasma.setPausado(true);
                guardarHighScoreSiEsNecesario();
                panel.repaint();
                break;
            }

            if (juegoPerdido) {
                hiloFantasma.setPausado(true);
                guardarHighScoreSiEsNecesario();
                panel.repaint();
                break;
            }

            // Reanudar fantasmas mientras el juego esté activo
            hiloFantasma.setPausado(false);

            // Mover Pac-Man
            pacman.mover(mapa.getMatriz());

            // Ya no se mueven fantasmas aquí.
            // Ahora los mueve HiloFantasma en segundo plano.

            verificarComida();
            verificarColisionFantasma();
            actualizarTiempo();

            panel.repaint();

            esperar();
        }
    }

    private void verificarComida() {

        // Revisa si Pac-Man está sobre una comida
        if (mapa.hayComida(pacman.getY(), pacman.getX())) {

            // Elimina la comida del mapa
            mapa.comerComida(pacman.getY(), pacman.getX());

            // Suma puntos
            pacman.sumarPuntos(10);

            // Si ya no queda comida, el jugador gana
            if (!mapa.quedaComida()) {

                juegoGanado = true;
                panel.setJuegoGanado(true);

                guardarHighScoreSiEsNecesario();

                System.out.println("¡Ganaste!");
            }
        }
    }

    private void verificarColisionFantasma() {

        // Recorre todos los fantasmas para revisar choque con Pac-Man
        for (int i = 0; i < fantasmas.length; i++) {

            if (fantasmas[i].getX() == pacman.getX() &&
                fantasmas[i].getY() == pacman.getY()) {

                // Pac-Man pierde una vida
                pacman.perderVida();

                System.out.println(
                    "Pac-Man fue atrapado. Vidas restantes: "
                    + pacman.getVidas()
                );

                // Si ya no tiene vidas, termina el juego
                if (pacman.estaMuerto()) {

                    juegoPerdido = true;
                    panel.setJuegoPerdido(true);

                    guardarHighScoreSiEsNecesario();

                    System.out.println("GAME OVER");
                } else {

                    // Reinicia Pac-Man
                    pacman.reiniciarPosicion();

                    // Reinicia fantasmas
                    fantasmas[0].reiniciarPosicion(10, 10);
                    fantasmas[1].reiniciarPosicion(9, 10);
                    fantasmas[2].reiniciarPosicion(11, 10);
                    fantasmas[3].reiniciarPosicion(10, 9);
                }

                break;
            }
        }
    }

    private void actualizarTiempo() {

        // Como esperar() usa 125 ms, 8 ciclos son aproximadamente 1 segundo
        contadorCiclos++;

        if (contadorCiclos >= 8) {
            segundosJuego++;
            contadorCiclos = 0;

            panel.setTiempo(segundosJuego);
        }
    }

    private void guardarHighScoreSiEsNecesario() {

        // Cargar el high score actual del archivo
        int highScoreActual = gestorPuntaje.cargarHighScore();

        // Si el puntaje actual es mayor, se guarda
        if (pacman.getPuntaje() > highScoreActual) {
            gestorPuntaje.guardarHighScore(pacman.getPuntaje());
            panel.setHighScore(pacman.getPuntaje());
        }
    }

    private void iniciarPartida() {

        // Inicia la partida desde el menú
        partidaIniciada = true;
        juegoPausado = false;

        panel.setPartidaIniciada(true);
        panel.setJuegoPausado(false);

        // Permite mover fantasmas
        hiloFantasma.setPausado(false);

        panel.repaint();

        System.out.println("Partida iniciada");
    }

    private void pausarReanudar() {

        if (partidaIniciada) {

            // Cambia entre pausado y reanudado
            juegoPausado = !juegoPausado;

            panel.setJuegoPausado(juegoPausado);

            // Pausa o reanuda también el hilo de fantasmas
            hiloFantasma.setPausado(juegoPausado);

            panel.repaint();

            if (juegoPausado) {
                System.out.println("Juego pausado");
            } else {
                System.out.println("Juego reanudado");
            }
        }
    }

    private void reiniciarPartida() {

        // Detener hilo anterior de fantasmas
        hiloFantasma.detener();

        // Crear nuevo mapa
        mapa = new Mapa();

        // Crear nuevo Pac-Man
        pacman = new Pacman(1, 1);

        // Crear nuevos fantasmas
        fantasmas = new Fantasma[4];
        fantasmas[0] = new Fantasma(10, 10);
        fantasmas[1] = new Fantasma(9, 10);
        fantasmas[2] = new Fantasma(11, 10);
        fantasmas[3] = new Fantasma(10, 9);

        juegoGanado = false;
        juegoPerdido = false;
        partidaIniciada = true;
        juegoPausado = false;

        segundosJuego = 0;
        contadorCiclos = 0;

        opcionMenu = 0;

        // Actualiza el panel con los nuevos objetos
        panel.actualizarDatos(mapa, pacman, fantasmas);
        panel.setJuegoGanado(false);
        panel.setJuegoPerdido(false);
        panel.setJuegoPausado(false);
        panel.setPartidaIniciada(true);
        panel.setTiempo(0);
        panel.setHighScore(gestorPuntaje.cargarHighScore());
        panel.setOpcionSeleccionada(opcionMenu);

        // Crear nuevo hilo de fantasmas con el nuevo mapa y nuevos fantasmas
        hiloFantasma = new HiloFantasma(fantasmas, mapa, panel);
        hiloFantasma.start();

        // Actualiza el teclado con el nuevo objeto Pac-Man
        ventana.addKeyListener(new ControlTeclado(pacman, this));

        panel.repaint();

        System.out.println("Partida reiniciada");
    }

    private void salirJuego() {

        // Detener hilo de fantasmas antes de cerrar
        hiloFantasma.detener();

        System.exit(0);
    }

    private void esperar() {
        try {
            Thread.sleep(125);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    public void moverMenuArriba() {
        opcionMenu--;

        if (opcionMenu < 0) {
            opcionMenu = 1;
        }

        panel.setOpcionSeleccionada(opcionMenu);
        panel.repaint();
    }

    public void moverMenuAbajo() {
        opcionMenu++;

        if (opcionMenu > 1) {
            opcionMenu = 0;
        }

        panel.setOpcionSeleccionada(opcionMenu);
        panel.repaint();
    }

    public void ejecutarOpcionMenu() {

        if (opcionMenu == 0) {
            iniciarPartida();
        }

        if (opcionMenu == 1) {
            salirJuego();
        }
    }
}