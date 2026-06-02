package com.mycompany.pacman;

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

    // CAMBIO: ahora recibe el mapa como parámetro.
    // Antes usaba "mapa" sin estar definido dentro de la clase.
    @Override
    public void mover(int[][] mapa) {

        if (puedeMover(mapa, direccionDeseada)) {
            direccionActual = direccionDeseada;
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

        // Comer puntos (Agregado nuevo)
        if (mapa[y][x] == Mapa.PUNTO) {
            sumarPuntos(10);
            mapa[y][x] = Mapa.VACIO;
        }

        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return false;
        }

        // CAMBIO: se usa Mapa.PARED en vez del número 1.
        return mapa[nuevaY][nuevaX] != Mapa.PARED;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public void perderVida() {
        this.vidas--;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
