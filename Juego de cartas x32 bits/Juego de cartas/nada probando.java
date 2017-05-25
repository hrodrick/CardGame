/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.*;
import Classes.SpanishCardClasses.*;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Soria
 */
public class LaCartaMasAlta extends Partido{
    
    public LaCartaMasAlta(ArrayList<Jugador> jugadores){
        super(jugadores);
        
    }
    
    @Override
    public boolean partidoTerminado() {
        boolean termino  = false;
        for(Jugador jugador : super.getJugadores()){
            if(jugador.getPuntos() == 10) termino = true;
        }
        return termino;
    }

    @Override
    public Vuelta jugarUnaVuelta() {
        Vuelta vuelta = new Vuelta();
        for (int i = 0; i < super.getJugadores().size(); i++) {
            vuelta.agregarMano(super.getJugadores().get(i), super.getJugadores().get(i).getCarta());
        }
        Jugador ganador = compareAndGetWinner();
        ganador.sumaUnPunto();
        super.agregarVuelta(vuelta);
        
        return vuelta;    
    }
    
    private Jugador compareAndGetWinner() {
        Jugador ganador = null;
        Jugador next = null;
        int i = 0;
        ganador = super.getJugadores().get(i);
        for (i = 1; i < super.getJugadores().size(); i++) {
            next = super.getJugadores().get(i);
            if (compareCards(ganador.getCarta(), next.getCarta()) == -1) {
                ganador = next;
            }
        }
        return ganador;
    }
    
    public int compareCards(Carta cardOne,Carta cardTwo){
        int resp = 0;
        int priorOne = prioridadCarta(cardOne);
        int priorTwo = prioridadCarta(cardTwo);
        int priorResult = comparePriorities(priorOne, priorTwo);
        resp = compareValues(priorResult, cardOne, cardTwo);
        
        return resp;
    }
    
    private int prioridadCarta(Carta card) {
        int prior = 0;
        if (card instanceof Copa) {
            prior = 1;
        }
        if (card instanceof Basto) {
            prior = 2;
        }
        if (card instanceof Oro) {
            prior = 3;
        }
        if (card instanceof Espada) {
            prior = 4;
        }
        return prior;
    }
    
    private int comparePriorities(int priorThis, int priorAnother) {
        int resp = 0; // 1: this > another | 0: equals | -1: this < another
        if (priorThis > priorAnother) {
            resp = 1;
        } else if (priorThis < priorAnother) {
            resp = -1;
        } else {
            resp = 0;
        }
        return resp;
    }
    
    private int compareValues(int resp, Carta cardOne, Carta cardTwo){
        //returns 1 if cardOne is higher than cardTwo or -1 on the another case. 
        if (resp == 0) {
            if (cardOne.getNumero() < cardTwo.getNumero()) {
                resp = -1;
            } else {
                resp = 1;
            }
        }
        return resp;
    }
    
    public static void main(String args[]){
        
        Carta carta1 = new Copa(5);
        Carta carta2 = new Espada(3);
        
        /*System.out.println("Bienvenido a la carta mas alta");
        Partido partido = new Partido();
        Simulador game = new Simulador(partido);
        game.start();
        System.out.println("Juego terminado");
        */
    }
}
