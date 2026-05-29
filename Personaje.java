package com.mycompany.pacman;

public abstract class Personaje {

    protected int x;
    protected int y;
    protected int velocidad;

    // CAMBIO: antes solo había "direccion".
    // Ahora se usan dos direcciones para controlar mejor el movimiento.
    protected String direccionActual;
    protected String direccionDeseada;

    public Personaje(int x, int y, int velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.direccionActual = "QUIETO";
        this.direccionDeseada = "QUIETO";
    }

    // Cada personaje se mueve de forma distinta.
    public abstract void mover(int[][] mapa);

    // CAMBIO: se corrigió "rerutn" por "return".
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setDireccionDeseada(String direccion) {
        this.direccionDeseada = direccion;
    }

    public String getDireccionActual() {
        return direccionActual;
    }
}
