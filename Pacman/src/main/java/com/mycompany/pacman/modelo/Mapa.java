package com.mycompany.pacman.modelo;

public class Mapa {

    // CAMBIO: el mapa solo guarda elementos fijos del escenario.
    // Se quitaron PACMAN y FANTASMAS de la matriz.
    public static final int VACIO = 0;
    public static final int PARED = 1;
    public static final int COMIDA = 2;
    // Representa una vida extra en el mapa
    public static final int VIDA_EXTRA = 3;
    // Super bolita que permite comer fantasmas
    public static final int SUPER_BOLITA = 4;

    private int[][] matriz;

    public Mapa() {
        matriz = new int[][] {
            
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,2,1,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,1,2,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,2,2,2,1,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,1},
            {1,1,1,2,1,1,1,0,0,0,0,0,0,0,1,1,1,2,1,1,1},
            {1,0,0,2,2,2,1,0,1,1,0,1,1,0,1,2,2,2,0,0,1},
            {1,3,0,2,1,2,1,0,1,0,0,0,1,0,1,2,1,2,0,3,1},
            {1,0,0,2,2,2,1,0,1,1,1,1,1,0,1,2,2,2,0,0,1},
            {1,1,1,2,1,1,1,0,0,0,0,0,0,0,1,1,1,2,1,1,1},
            {1,2,2,2,1,2,2,2,2,2,1,2,2,2,2,2,1,2,2,2,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,2,1,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,1,2,1},
            {1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
            {1,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
            
            
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
    
    // Verifica si en una posición hay una vida extra
    public boolean hayVidaExtra(int fila, int columna) {
        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {
            return false;
        }

        return matriz[fila][columna] == VIDA_EXTRA;
    }
    // Verifica si hay una super bolita
    public boolean haySuperBolita(int fila, int columna) {

        if (fila < 0 || fila >= matriz.length ||
            columna < 0 || columna >= matriz[0].length) {

            return false;
        }

        return matriz[fila][columna] == SUPER_BOLITA;
    }
    
    // Elimina cualquier poder especial del mapa
    public void quitarPoder(int fila, int columna) {
        if (fila >= 0 && fila < matriz.length &&
            columna >= 0 && columna < matriz[0].length) {

            matriz[fila][columna] = VACIO;
        }
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