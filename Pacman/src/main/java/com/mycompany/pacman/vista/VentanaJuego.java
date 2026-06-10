// Archivo VentanaJuego java del paquete vista
// Este archivo dibuja la interfaz visual y muestra informacion al jugador

package com.mycompany.pacman.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import javax.swing.Box;

public class VentanaJuego extends JFrame {

    public VentanaJuego(
            PanelJuego panel,
            ActionListener accionIniciar,
            ActionListener accionPausar,
            ActionListener accionReiniciar,
            ActionListener accionSalir
    ) {

        setTitle("Pac-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear barra de menu
        JMenuBar barraMenu = new JMenuBar();

        // Crear menu principal
        JMenu menuJuego = new JMenu("Menu");

        // Opciones del menu
        JMenuItem itemIniciar = new JMenuItem("Iniciar partida");
        JMenuItem itemPausar = new JMenuItem("Pausar / Reanudar");
        JMenuItem itemReiniciar = new JMenuItem("Reiniciar partida");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Conectar opciones con el controlador
        itemIniciar.addActionListener(accionIniciar);
        itemPausar.addActionListener(accionPausar);
        itemReiniciar.addActionListener(accionReiniciar);
        itemSalir.addActionListener(accionSalir);

        // Agregar opciones al menu
        menuJuego.add(itemIniciar);
        menuJuego.add(itemPausar);
        menuJuego.add(itemReiniciar);
        menuJuego.add(itemSalir);

        // Agregar menu a la barra
        // Empuja el menu hacia la derecha
        barraMenu.add(Box.createHorizontalGlue());
        barraMenu.add(menuJuego);

        // Agregar barra a la ventana
        setJMenuBar(barraMenu);

        add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
