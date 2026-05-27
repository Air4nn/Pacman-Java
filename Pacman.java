public class Pacman extends Personaje{
    private int vidas;
    private int puntaje;

    public Pacman(int x, int y){
        super(x,y,1);
        this.vidas = 3;
        this.puntaje = 0;
    }
    
    // metodo que se llama constantemente
    public void mover() {

        // intentar cambiar dirección si es posible
        if (puedeMover(direccionDeseada)) {
            direccionActual = direccionDeseada;
        }

        // mover en la dirección actual si no hay muro
        if (puedeMover(direccionActual)) {
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

    // verifica si puede moverse en cierta dirección
    private boolean puedeMover(String direccion) {

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

        // validar límites del mapa
        if (nuevaY < 0 || nuevaY >= mapa.length ||
            nuevaX < 0 || nuevaX >= mapa[0].length) {
            return false;
        }

        // 1 = pared
        return mapa[nuevaY][nuevaX] != 1;
    }

    // setters y getters 
    public void setDireccionDeseada(String direccion) {
        this.direccionDeseada = direccion;
    }
    public int getX() { 
        return x; 
    }
    public int getY() { 
        return y; 
    }
}
