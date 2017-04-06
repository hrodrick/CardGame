/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author Rodrigo Soria
 */
public class Simulador {
    Partido partido;
    
    public Simulador(Partido partido){
        this.partido = partido;
    }
    public void simularPartido(boolean automatico){
        
         
        
    }
    public void simularVuelta(boolean automatico){
        
    }
    public void imprimirVuelta(){
        
    }
    public void imprimirPuntuaciones(){
        
    }
    public void limpiarConsola(){
        System.out.close();
    }
    public void controlarSimulacion(){
        Scanner entradaTeclado = new Scanner(System.in);
        int cantJugadores = setCantidadDeJugadores(entradaTeclado);
        limpiarConsola();
        agregarJugadoresAlPartido(entradaTeclado, cantJugadores);
        limpiarConsola();
        boolean automatico = setControlDelJuego(entradaTeclado);
        limpiarConsola();
        startMessage(entradaTeclado);
        
        simularPartido(automatico);
        
    }
    private int setCantidadDeJugadores(Scanner entradaTeclado){
        int cantJugadores = 0;
        System.out.println("Cuantos jugadores hay en la mesa? (de 2 a 6)");
        do{
        cantJugadores = entradaTeclado.nextInt();
        
        if(cantJugadores > 1 && cantJugadores < 7) 
            System.out.println("Cantidad incorrecta, inserte 2 a 6 jugadores");
        }while(cantJugadores > 1 && cantJugadores < 7);
       
        return cantJugadores;
    }
    private void agregarJugadoresAlPartido(Scanner entradaTeclado, int cantJugadores){
        Jugador jugador = null;
        String nombre = "";
        
        for(int i = 0; i < cantJugadores; i++){
            System.out.println("Ingrese nombre del jugador " + (i+1));
            nombre = entradaTeclado.nextLine();
            jugador = new Jugador(nombre);
            partido.jugadores.add(jugador);
        }
    }
    private boolean setControlDelJuego(Scanner entradaTeclado){
        boolean automatico = true;
        System.out.println("Desea controlar la simulacion del juego? 1 = si / 0 = no");
        int resp = 0;
        
        do{
            resp = entradaTeclado.nextInt();
            if(resp != 1 && resp != 0) 
            System.out.println("Cantidad incorrecta, ingrese 1(si) o 0(no)");
        }while(resp != 1 || resp != 0);
        
        if(resp == 1) automatico = false;
        return automatico;
    }
    private void startMessage(Scanner entradaTeclado){
        System.out.println("presione cualquier tecla y enter para comenzar.");
        entradaTeclado.next();
    }
}
