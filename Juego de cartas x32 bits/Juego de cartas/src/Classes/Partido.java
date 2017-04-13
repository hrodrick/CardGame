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
    public Vuelta jugarUnaVuelta(){
        Vuelta vuelta = new Vuelta();
        for (int i = 0; i < jugadores.size(); i++) {
            vuelta.agregarMano(jugadores.get(i), jugadores.get(i).getCarta());
        }
        Jugador ganador = compareAndGetWinner();
        ganador.sumaUnPunto();
        vueltas.add(vuelta);
        
        return vuelta;
    }
    
    private Jugador compareAndGetWinner() {
        Jugador ganador = null;
        Jugador next = null;
        int i = 0;
        ganador = jugadores.get(i);
        for (i = 1; i < jugadores.size(); i++) {
            next = jugadores.get(i);
            if (ganador.getCarta().compareTo(next.getCarta()) == -1) {
                ganador = next;
            }
        }
        return ganador;
    }

    
    public Partido(){
        jugadores = new ArrayList<>();
        vueltas =  new ArrayList<>();
    }

}
