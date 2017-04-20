
package Classes;

 
public class Jugador {
    private String nombre;
    private int puntos;
    private Carta carta; 
    
    public Jugador(String nombre){
        this.nombre = nombre;
        puntos = 0;
        carta = null;
    }
    public void setCarta(Carta carta){
        this.carta = carta;
    }
    public Carta getCarta(){
        return carta;
    }
    public void sumaUnPunto(){
        this.puntos++;
    }
    public int getPuntos(){
        return puntos;
    }
    public Carta tirarCarta(){
        Carta Adevolver = carta;
        carta = null;
        return Adevolver;
    }
   
    public String getNombre(){
        return nombre;
    }
    
}
