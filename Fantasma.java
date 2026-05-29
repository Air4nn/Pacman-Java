package com.mycompany.pacman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fantasma extends Personaje implements Runnable {

    private boolean activo;
    private Random rand;
    private int[][] mapa;

    // CAMBIO: ahora Fantasma hereda de Personaje, no de Entidad.
    // CAMBIO: recibe el mapa en el constructor para no depender de Game.mapa.
    public Fantasma(int x, int y, int[][] mapa) {
        super(x, y, 1);
        this.mapa = mapa;
        this.activo = true;
        this.rand = new Random();

        String[] direcciones = {"ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA"};
        this.direccionActual = direcciones[rand.nextInt(direcciones.length)];
    }

    @Override
    public void mover(int[][] mapa) {

        if (!puedeMover(mapa, direccionActual)) {
            direccionActual = obtenerDireccionValida(mapa);
        }

        if (rand.nextDouble() < 0.2) {
            direccionActual = obtenerDireccionValida(mapa);
        }

        if (puedeMover(mapa, direccionActual)) {
            switch (direccionActual) {
                case "ARRIBA":
                    y--;
                    break;
                case "ABAJO":
                    y++;
                    break;
                case "IZQUIERDA":
                    x--;
                    break;
                case "DERECHA":
                    x++;
                    break;
            }
        }
    }

    private boolean puedeMover(int[][] mapa, String direccion) {

        int nuevaX = x;
        int nuevaY = y;

        switch (direccion) {
            case "ARRIBA":
                nuevaY--;
                break;
            case "ABAJO":
                nuevaY++;
                break;
            case "IZQUIERDA":
                nuevaX--;
                break;
            case "DERECHA":
                nuevaX++;
                break;
        }

        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return false;
        }

        // CAMBIO: se usa Mapa.PARED en vez de 1.
        return mapa[nuevaY][nuevaX] != Mapa.PARED;
    }

    private String obtenerDireccionValida(int[][] mapa) {

        List<String> direcciones = new ArrayList<>();

        if (puedeMover(mapa, "ARRIBA")) {
            direcciones.add("ARRIBA");
        }

        if (puedeMover(mapa, "ABAJO")) {
            direcciones.add("ABAJO");
        }

        if (puedeMover(mapa, "IZQUIERDA")) {
            direcciones.add("IZQUIERDA");
        }

        if (puedeMover(mapa, "DERECHA")) {
            direcciones.add("DERECHA");
        }

        if (direcciones.isEmpty()) {
            return direccionActual;
        }

        return direcciones.get(rand.nextInt(direcciones.size()));
    }

    @Override
    public void run() {
        while (activo) {
            mover(mapa);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                activo = false;
                Thread.currentThread().interrupt();
            }
        }
    }

    public void detener() {
        activo = false;
    }
}
