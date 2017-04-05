/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Rodrigo Soria
 */
public class BarajaEspañola {

    private Stack<Carta> cartasEnJuego;
    private ArrayList<Carta> cartasUsadas;

    public void mezclar() {
        if (hayCartas()) {
            ArrayList<Carta> cartasAmezclar = new ArrayList<>();
            cartasAmezclar.addAll(cartasEnJuego);
            int lenght = cartasAmezclar.size();
            int extract = lenght - 1;
            int randomPos = 0;
            Carta aux = null;
            while (extract > 0) {
                randomPos = randomBetween(0, extract);
                aux = cartasAmezclar.get(randomPos);
                cartasAmezclar.set(randomPos, cartasAmezclar.get(extract));
                cartasAmezclar.set(extract, aux);
                extract--;
            }
            cartasEnJuego.addAll(cartasAmezclar);
        }
    }
    private int randomBetween(int min, int max) {
        int resultado = (int) (Math.random() * (max - min) + min);
        return resultado;
    }
    public Carta darLaCartaDeArriba() {
        return cartasEnJuego.pop();
    }
    public void guardarCartaUsada(Carta usada) {
        cartasUsadas.add(usada);
    }
    public boolean hayCartas() {
        return !cartasEnJuego.isEmpty();
    }
    public BarajaEspañola() {
        /*
        Creo mazo
        creo pila
        mezclo
         */
    }
}
