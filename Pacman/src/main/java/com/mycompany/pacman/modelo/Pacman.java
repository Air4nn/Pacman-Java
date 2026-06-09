package com.mycompany.pacman.modelo;

public class Pacman extends Personaje {

    private int vidas;
    private int puntaje;

    public Pacman(int x, int y) {
        super(x, y, 1);
        this.vidas = 3;
        this.puntaje = 0;
        this.direccionActual = "DERECHA";
        this.direccionDeseada = "DERECHA";
    }

    @Override
    public void mover(int[][] mapa) {

        // Intenta cambiar a la dirección deseada
        if (puedeMover(mapa, direccionDeseada)) {
            direccionActual = direccionDeseada;
        }

        // Si puede moverse en la dirección actual, avanza
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

        // Validar límites del mapa
        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return false;
        }

        // Validar que no sea pared
        return mapa[nuevaY][nuevaX] != Mapa.PARED;
    }

    // Suma puntos al puntaje actual
    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    // Resta una vida cuando un fantasma atrapa a Pac-Man
    public void perderVida() {
        this.vidas--;
    }
    
    // Suma una vida a Pac-Man
    public void ganarVida() {
        vidas++;
    }

    // Reinicia la posición de Pac-Man al punto de inicio
    // Se utiliza cuando pierde una vida
    public void reiniciarPosicion() {
        x = 1;
        y = 1;

        direccionActual = "DERECHA";
        direccionDeseada = "DERECHA";
    }

    // Verifica si Pac-Man ya no tiene vidas
    public boolean estaMuerto() {
        return vidas <= 0;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }
}