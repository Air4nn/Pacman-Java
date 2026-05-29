package com.mycompany.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Esta clase detecta las teclas que presiona el jugador
public class ControlTeclado implements KeyListener {

    // Referencia al objeto Pacman
    private Pacman pacman;

    // Constructor
    public ControlTeclado(Pacman pacman) {
        this.pacman = pacman;
    }

    // Método que se ejecuta cuando una tecla es presionada
    @Override
    public void keyPressed(KeyEvent e) {

        // Obtiene el código de la tecla presionada
        int tecla = e.getKeyCode();

        // Dependiendo de la tecla cambia la dirección deseada
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

    // Métodos obligatorios de KeyListener
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}