package com.mycompany.pacman;

public class Mapa {
    
    // Constantes públicas para identificar los elementos del juego
    public static final int VACIO = 0;
    public static final int PARED = 1;
    public static final int COMIDA = 2;
    public static final int PACMAN = 3;
    public static final int FANTASMAS = 4;

    // Matriz encapsulada que representa el laberinto
    private int[][] matriz;

    public Mapa() {
        // Inicializamos la matriz de forma dinámica utilizando tus constantes textualmente
        matriz = new int[][] {
            {PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED},
            {PARED, PACMAN, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, PARED, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, FANTASMAS, PARED},
            {PARED, COMIDA, PARED, PARED, COMIDA, PARED, COMIDA, PARED, COMIDA, PARED, COMIDA, PARED, PARED, COMIDA, PARED},
            {PARED, COMIDA, PARED, PARED, COMIDA, PARED, COMIDA, COMIDA, COMIDA, PARED, COMIDA, PARED, PARED, COMIDA, PARED},
            {PARED, COMIDA, COMIDA, COMIDA, COMIDA, PARED, PARED, VACIO, PARED, PARED, COMIDA, COMIDA, COMIDA, COMIDA, PARED},
            {PARED, PARED, PARED, COMIDA, PARED, PARED, VACIO, FANTASMAS, VACIO, PARED, PARED, COMIDA, PARED, PARED, PARED},
            {VACIO, VACIO, PARED, COMIDA, PARED, VACIO, VACIO, VACIO, VACIO, VACIO, PARED, COMIDA, PARED, VACIO, VACIO},
            {PARED, PARED, PARED, COMIDA, PARED, PARED, PARED, PARED, PARED, PARED, PARED, COMIDA, PARED, PARED, PARED},
            {PARED, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, PARED, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, COMIDA, PARED},
            {PARED, COMIDA, PARED, PARED, COMIDA, PARED, COMIDA, PARED, COMIDA, PARED, COMIDA, PARED, PARED, COMIDA, PARED},
            {PARED, FANTASMAS, COMIDA, PARED, COMIDA, COMIDA, COMIDA, PACMAN, COMIDA, COMIDA, COMIDA, PARED, COMIDA, FANTASMAS, PARED},
            {PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED, PARED}
        };
    }

    // Getter para obtener la matriz desde el renderizador gráfico u otra lógica de tu juego
    public int[][] getMatriz() {
        return matriz;
    }

    // Método de validación actualizado para usar la constante PARED en lugar del número 1
    public boolean esPared(int fila, int columna) {
        // Control de desbordamiento: si las coordenadas están fuera de la matriz, actúa como pared
        if (fila < 0 || fila >= matriz.length || columna < 0 || columna >= matriz[0].length) {
            return true;
        }
        return matriz[fila][columna] == PARED;
    }
}
