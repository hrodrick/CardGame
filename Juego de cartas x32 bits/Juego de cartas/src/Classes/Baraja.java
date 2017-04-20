/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.SpanishCardClasses.*;
import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * @author Rodrigo Soria
 */
public abstract class Baraja {

    private Stack<Carta> cartasEnJuego;
    private ArrayList<Carta> cartasUsadas;
    
    protected abstract ArrayList<Carta> crearCartas(); 
    
    /*
    public void mezclar() {
        if (!hayCartas()) {
            cartasEnJuego.addAll(cartasUsadas);
            cartasUsadas.clear();
        }
        ArrayList<Carta> cartasAmezclar = new ArrayList<>();
        while (this.hayCartas()) {
            cartasAmezclar.add(cartasEnJuego.pop());
        }
        cartasAmezclar = cartasMezcladas(cartasAmezclar);
        cartasEnJuego.addAll(cartasAmezclar);
    }
    
    */
    public Carta desapilarUnaCarta() {
        return cartasEnJuego.pop();
    }

    public void agregarCartaUsada(Carta usada) {
        cartasUsadas.add(usada);
    }
    
    public ArrayList getCartasUsada(){
        return cartasUsadas;
    }
    
    public void apilarCartas(ArrayList<Carta> cartas){
        cartasEnJuego.addAll(cartas);
    }
    public boolean quedanCartas() {
        return !cartasEnJuego.isEmpty();
    }

    public Baraja() {
        this.cartasEnJuego = new Stack<>();
        this.cartasUsadas = new ArrayList<>();
    }
}
