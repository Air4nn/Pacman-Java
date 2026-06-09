package com.mycompany.pacman.controlador;

import com.mycompany.pacman.modelo.Pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlTeclado implements KeyListener {

    private Pacman pacman;
    private ControladorJuego controlador;

    public ControlTeclado(Pacman pacman, ControladorJuego controlador) {
        this.pacman = pacman;
        this.controlador = controlador;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla = e.getKeyCode();

        // Si la partida no ha iniciado, las flechas controlan el menú
        if (!controlador.isPartidaIniciada()) {

            if (tecla == KeyEvent.VK_UP) {
                controlador.moverMenuArriba();
            }

            if (tecla == KeyEvent.VK_DOWN) {
                controlador.moverMenuAbajo();
            }

            if (tecla == KeyEvent.VK_ENTER) {
                controlador.ejecutarOpcionMenu();
            }

            return;
        }

        // Si la partida ya inició, las flechas mueven a Pac-Man
        switch (tecla) {

            case KeyEvent.VK_UP:
                pacman.setDireccionDeseada("ARRIBA");
                break;

            case KeyEvent.VK_DOWN:
                pacman.setDireccionDeseada("ABAJO");
                break;

            case KeyEvent.VK_LEFT:
                pacman.setDireccionDeseada("IZQUIERDA");
                break;

            case KeyEvent.VK_RIGHT:
                pacman.setDireccionDeseada("DERECHA");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}