
package Classes;

import java.util.ArrayList;


public abstract class Partido {
    ArrayList <Jugador> jugadores;
    ArrayList <Vuelta> vueltas;

    
    public Partido(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        vueltas =  new ArrayList<>();
    }
    
    public abstract boolean partidoTerminado();
    
    
    public ArrayList <Jugador> getJugadores(){
        return jugadores;
    }
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
    /*
    public Jugador getGanador(){
        Jugador jugador = comprobarPuntos();
        return jugador;
    }
    private Jugador comprobarPuntos(){
        //Returns the player with the 10 points
        boolean encontrado = false;
        int i = 0;
        Jugador jugador = null;
        while(encontrado == false && i < jugadores.size()){
            jugador = jugadores.get(i);
            if(jugador.getPuntos() == 10) encontrado = true;
            i++;
        }
        return jugador;
    }
    */
    public Vuelta getUltimaVuelta(){
        int pos = vueltas.size(); 
        return vueltas.get(pos-1);
    }
    public void agregarVuelta(Vuelta vuelta){
        vueltas.add(vuelta);
    }
    public abstract Vuelta jugarUnaVuelta();
        /*
        
    }
    
    
    */


}
