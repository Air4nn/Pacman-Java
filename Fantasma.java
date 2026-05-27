import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fantasma extends Entidad implements Runnable {

    private boolean activo;
    private String direccionActual;
    private Random rand;

    public Fantasma(int x, int y) {
        super(x, y, 1);
        this.activo = true;
        this.rand = new Random();

        // dirección inicial aleatoria
        String[] dirs = {"ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA"};
        this.direccionActual = dirs[rand.nextInt(4)];
    }

    @Override
    public void mover(int[][] mapa) {

        // si no puede seguir, cambiar dirección
        if (!puedeMover(mapa, direccionActual)) {
            direccionActual = obtenerDireccionValida(mapa);
        }

        // cambio aleatorio ocasional (para que no sea muy predecible)
        if (rand.nextDouble() < 0.2) {
            direccionActual = obtenerDireccionValida(mapa);
        }

        int nuevaX = x;
        int nuevaY = y;

        switch (direccionActual) {
            case "ARRIBA": nuevaY--; break;
            case "ABAJO": nuevaY++; break;
            case "IZQUIERDA": nuevaX--; break;
            case "DERECHA": nuevaX++; break;
        }

        if (puedeMover(mapa, direccionActual)) {
            x = nuevaX;
            y = nuevaY;
        }
    }

    // validar si puede moverse
    private boolean puedeMover(int[][] mapa, String direccion) {

        int nuevaX = x;
        int nuevaY = y;

        switch (direccion) {
            case "ARRIBA": nuevaY--; break;
            case "ABAJO": nuevaY++; break;
            case "IZQUIERDA": nuevaX--; break;
            case "DERECHA": nuevaX++; break;
        }

        // validar límites
        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return false;
        }

        return mapa[nuevaY][nuevaX] != 1;
    }

    // obtener dirección válida aleatoria
    private String obtenerDireccionValida(int[][] mapa) {

        List<String> direcciones = new ArrayList<>();

        if (puedeMover(mapa, "ARRIBA")) direcciones.add("ARRIBA");
        if (puedeMover(mapa, "ABAJO")) direcciones.add("ABAJO");
        if (puedeMover(mapa, "IZQUIERDA")) direcciones.add("IZQUIERDA");
        if (puedeMover(mapa, "DERECHA")) direcciones.add("DERECHA");

        if (direcciones.isEmpty()) return direccionActual;

        return direcciones.get(rand.nextInt(direcciones.size()));
    }

    @Override
    public void run() {
        while (activo) {
            mover(Game.mapa);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void detener() {
        activo = false;
    }
}