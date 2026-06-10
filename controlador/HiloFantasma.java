// Archivo HiloFantasma java del paquete controlador
// Este archivo controla acciones del juego conecta modelo y vista y maneja eventos

package com.mycompany.pacman.controlador;

import com.mycompany.pacman.modelo.Fantasma;
import com.mycompany.pacman.modelo.Mapa;
import com.mycompany.pacman.vista.PanelJuego;

// Esta clase mueve los fantasmas en un hilo separado
public class HiloFantasma extends Thread {

    private Fantasma[] fantasmas;
    private Mapa mapa;
    private PanelJuego panel;

    // Controla si el hilo sigue funcionando
    private boolean activo = true;

    // Controla si los fantasmas estan pausados
    private boolean pausado = false;

    public HiloFantasma(Fantasma[] fantasmas, Mapa mapa, PanelJuego panel) {
        this.fantasmas = fantasmas;
        this.mapa = mapa;
        this.panel = panel;
    }

    @Override
    public void run() {

        while (activo) {

            if (!pausado) {

                // Mover todos los fantasmas automaticamente
                for (int i = 0; i < fantasmas.length; i++) {
                    fantasmas[i].mover(mapa.getMatriz(), fantasmas);
                }

                // Redibujar pantalla
                panel.repaint();
            }

            try {
                // Velocidad de los fantasmas
                Thread.sleep(100);
            } catch (InterruptedException e) {
                activo = false;
            }
        }
    }

    // Detiene el hilo completamente
    public void detener() {
        activo = false;
    }

    // Pausa o reanuda el movimiento de fantasmas
    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }
}
