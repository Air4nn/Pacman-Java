package com.mycompany.pacman.controlador;

import com.mycompany.pacman.modelo.Pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlTeclado implements KeyListener {

    private Pacman pacman;

    public ControlTeclado(Pacman pacman) {
        this.pacman = pacman;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla = e.getKeyCode();

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