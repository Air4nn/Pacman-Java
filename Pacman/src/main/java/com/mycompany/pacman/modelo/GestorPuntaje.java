// Archivo GestorPuntaje java del paquete modelo
// Este archivo representa datos reglas y comportamiento interno del juego

package com.mycompany.pacman.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorPuntaje {

    private static final String ARCHIVO = "highscore.txt";

    public int cargarHighScore() {

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));

            int puntaje = Integer.parseInt(lector.readLine());

            lector.close();

            return puntaje;

        } catch (Exception e) {

            return 0;
        }
    }

    public void guardarHighScore(int puntaje) {

        try {
            FileWriter escritor = new FileWriter(ARCHIVO);

            escritor.write(String.valueOf(puntaje));

            escritor.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
