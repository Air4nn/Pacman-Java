package com.mycompany.pacman;

import com.mycompany.pacman.controlador.ControladorJuego;

public class JuegoMain {

    public static void main(String[] args) {

        ControladorJuego controlador = new ControladorJuego();
        controlador.iniciar();
    }
}