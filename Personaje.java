public abstract class Personaje{
    // cordenadas para que el personaje se pueda mover dentro del mapa 
    protected int x;
    protected int y;
    // que tan rapido se puede mover el personaje 
    protected int velocidad;
    // direccion del personaje 
    protected String direccion;

    // constructor
    public Personaje(int x, int y, int velocidad){
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.direccion = "QUIETO";
    }

    // metodo abstracto ya que todos los personajes deben moverse
    public abstract void mover(int[][] mapa);

    // getters y setters 
    public int getx(){
        rerutn x;
    }
    public int gety(){
        rerutn y;
    }
    public void setdireccion(String direccion){
        this.direccion = direccion;
    }
}