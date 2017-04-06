/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;

/**
 *
 * @author Rodrigo Soria
 */
public class Vuelta {
    HashMap<Jugador,Carta> vuelta;
    
    public void agregarMano(Jugador player, Carta card){
       vuelta.put(player, card);
    }
    public Carta verCartaDelJugador(Jugador player){
        return vuelta.get(player);
    }
    public Vuelta(){
        vuelta = new HashMap<>();
    }
}
