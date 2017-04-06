/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Soria
 */
public class Partido {
    ArrayList <Jugador> jugadores;
    ArrayList <Vuelta> vueltas;
    
    public boolean partidoTerminado(){
        boolean termino = false;
        for(Jugador jugador : jugadores){
            if(jugador.getPuntos() == 10) termino = true;
        }
        return termino;
    }
    public ArrayList <Jugador> getJugadores(){
        return jugadores;
    }
    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
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
    public Vuelta getUltimaVuelta(){
        int pos = vueltas.size(); 
        return vueltas.get(pos-1);
    }
    public void agregarVuelta(Vuelta vuelta){
        vueltas.add(vuelta);
    }
    public Partido(){
        jugadores = new ArrayList<>();
        vueltas =  new ArrayList<>();
    }

}
