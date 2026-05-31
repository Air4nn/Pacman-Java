package com.mycompany.pacman;

public class Mapa {

    // CAMBIO: el mapa solo guarda elementos fijos del escenario.
    // Se quitaron PACMAN y FANTASMAS de la matriz.
    public static final int VACIO = 0;
    public static final int PARED = 1;
    public static final int COMIDA = 2;

    private int[][] matriz;

    public Mapa() {
        matriz = new int[][] {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,1,1,2,1,2,2,2,1,2,1,1,2,1},
            {1,2,2,2,2,1,1,0,1,1,2,2,2,2,1},
            {1,1,1,2,1,1,0,0,0,1,1,2,1,1,1},
            {0,0,1,2,1,0,0,0,0,0,1,2,1,0,0},
            {1,1,1,2,1,1,1,1,1,1,1,2,1,1,1},
            {1,2,2,2,2,2,2,1,2,2,2,2,2,2,1},
            {1,2,1,1,2,1,2,1,2,1,2,1,1,2,1},
            {1,2,2,1,2,2,2,0,2,2,2,1,2,2,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public boolean esPared(int fila, int columna) {
        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {
            return true;
        }

        return matriz[fila][columna] == PARED;
    }

    // CAMBIO: se agregó para saber si Pac-Man está sobre comida.
    public boolean hayComida(int fila, int columna) {
        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {
            return false;
        }

        return matriz[fila][columna] == COMIDA;
    }
    // Verifica si todavía queda comida en el mapa
    public boolean quedaComida() {

            // Recorre todas las filas
            for (int fila = 0; fila < matriz.length; fila++) {

                // Recorre todas las columnas
                for (int columna = 0; columna < matriz[fila].length; columna++) {

                    // Si encuentra una comida, todavía no ha terminado el juego
                    if (matriz[fila][columna] == COMIDA) {
                    return true;
                    }
                }
            }

            // Si no encontró comida, el jugador ganó
            return false;
    }

    // CAMBIO: se agregó para eliminar comida cuando Pac-Man la come.
    public void comerComida(int fila, int columna) {
        if (hayComida(fila, columna)) {
            matriz[fila][columna] = VACIO;
        }
    }

    public int getFilas() {
        return matriz.length;
    }

    public int getColumnas() {
        return matriz[0].length;
    }
}
