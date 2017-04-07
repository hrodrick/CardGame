/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Classes.*;

/**
 *
 * @author Rodrigo Soria
 */
public class LaCartaMasAlta {
    
    public static void main(String args[]){
        System.out.println("Bienvenido a la carta mas alta");
        Partido partido = new Partido();
        Simulador game = new Simulador(partido);
        game.start();
        System.out.println("Juego terminado");
    }
    
}
