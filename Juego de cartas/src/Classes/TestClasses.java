/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rodrigo Soria
 */
public class TestClasses {
    public static void main(String args[]){
        /* TEST CARTA
        Carta primera = new Carta(12, "oro");
        System.out.println(primera);
        Carta segunda = new Carta(1, "espada");
        System.out.println(segunda);
        boolean validate = primera.validarPalo();
        System.out.println(validate);
        int PrimeraEsMayor = primera.compareTo(segunda);
        System.out.println(PrimeraEsMayor);
       */
        /* TEST BARAJA Y JUGADOR
        Jugador player1 = new Jugador("Soria");
        BarajaEspañola miMazo = new BarajaEspañola();
        miMazo.mezclar();
        for(int i = 0; i < 48; i++){
            player1.setCarta(miMazo.darLaCartaDeArriba());
            miMazo.guardarCartaUsada(player1.devolverCarta());
        }
        System.out.println(miMaz
        */
        
        Carta cartita = new Carta(7, "copa");
        Carta cartita2 = new Carta(12, "basto");
        Partido partidito = new Partido();
        Jugador player1 = new Jugador("Jaime");
        Jugador player2 = new Jugador("Soria");
        Jugador player3 = new Jugador("Philips");
        Vuelta vueltita1 = new Vuelta();
        Vuelta vueltita2 = new Vuelta();
        partidito.agregarJugador(player1);
        partidito.agregarJugador(player2);
        partidito.agregarJugador(player3);
        partidito.agregarVuelta(vueltita1);
        player1.setCarta(cartita);
        vueltita1.agregarMano(player1, cartita);
        vueltita1.agregarMano(player2, cartita2);
        partidito.agregarVuelta(vueltita1);
        for(int i = 0; i<10; i++)player2.sumaUnPunto();
        
        if(partidito.partidoTerminado())
            System.out.println(partidito.getUltimaVuelta().verCartaDelJugador(partidito.getGanador()));
        System.out.println(vueltita1.verCartaDelJugador(player2));
        
        
    }
}
