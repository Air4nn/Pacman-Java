package com.mycompany.pacman.modelo;

import java.util.Random;

public class Fantasma extends Personaje {

    private Random random = new Random();

    public Fantasma(int x, int y) {
        super(x, y, 1);
        this.direccionActual = "IZQUIERDA";
        this.direccionDeseada = "IZQUIERDA";
    }

    public void mover(int[][] mapa, Fantasma[] fantasmas) {

        int nuevaX = x;
        int nuevaY = y;

        int direccion = (int)(Math.random() * 4);

        // Arriba
        if (direccion == 0) {
            nuevaY--;
        }

        // Abajo
        if (direccion == 1) {
            nuevaY++;
        }

        // Izquierda
        if (direccion == 2) {
            nuevaX--;
        }

        // Derecha
        if (direccion == 3) {
            nuevaX++;
        }

        // Validar límites antes de revisar el mapa
        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return;
        }

        // Validar pared
        if (mapa[nuevaY][nuevaX] != Mapa.PARED) {

            boolean ocupado = false;

            // Validar choque con otros fantasmas
            for (int i = 0; i < fantasmas.length; i++) {

                if (fantasmas[i] != this) {

                    if (fantasmas[i].getX() == nuevaX &&
                        fantasmas[i].getY() == nuevaY) {

                        ocupado = true;
                    }
                }
            }

            // Si no está ocupado se mueve
            if (ocupado == false) {
                x = nuevaX;
                y = nuevaY;
            }
        }
    }

    @Override
    public void mover(int[][] mapa) {
        mover(mapa, new Fantasma[0]);
    }

    private void moverEnDireccion() {

        if (direccionActual.equals("ARRIBA")) {
            y = y - 1;
        }

        if (direccionActual.equals("ABAJO")) {
            y = y + 1;
        }

        if (direccionActual.equals("IZQUIERDA")) {
            x = x - 1;
        }

        if (direccionActual.equals("DERECHA")) {
            x = x + 1;
        }
    }

    private void cambiarDireccionAleatoria() {

        int opcion = random.nextInt(4);

        if (opcion == 0) {
            direccionActual = "ARRIBA";
        }

        if (opcion == 1) {
            direccionActual = "ABAJO";
        }

        if (opcion == 2) {
            direccionActual = "IZQUIERDA";
        }

        if (opcion == 3) {
            direccionActual = "DERECHA";
        }
    }

    private boolean puedeMover(int[][] mapa, String direccion, Fantasma[] fantasmas) {

        int nuevaX = x;
        int nuevaY = y;

        if (direccion.equals("ARRIBA")) {
            nuevaY = nuevaY - 1;
        }

        if (direccion.equals("ABAJO")) {
            nuevaY = nuevaY + 1;
        }

        if (direccion.equals("IZQUIERDA")) {
            nuevaX = nuevaX - 1;
        }

        if (direccion.equals("DERECHA")) {
            nuevaX = nuevaX + 1;
        }

        // Limites
        if (nuevaY < 0) {
            return false;
        }

        if (nuevaY >= mapa.length) {
            return false;
        }

        if (nuevaX < 0) {
            return false;
        }

        if (nuevaX >= mapa[0].length) {
            return false;
        }

        // Pared
        if (mapa[nuevaY][nuevaX] == Mapa.PARED) {
            return false;
        }

        // Metodo para que no choque con otros fantasmas
        for (int i = 0; i < fantasmas.length; i++) {

            Fantasma f = fantasmas[i];

            if (f != this) {

                if (f.getX() == nuevaX) {

                    if (f.getY() == nuevaY) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Reinicia la posición del fantasma
    // Se usa cuando Pac-Man pierde una vida
    public void reiniciarPosicion(int nuevaX, int nuevaY) {
        x = nuevaX;
        y = nuevaY;
    }
}