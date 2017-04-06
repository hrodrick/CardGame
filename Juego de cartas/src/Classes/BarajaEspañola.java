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
            while (this.hayCartas()) {
                cartasAmezclar.add(cartasEnJuego.pop());
            }
            cartasAmezclar = cartasMezcladas(cartasAmezclar);
            cartasEnJuego.addAll(cartasAmezclar);
        }
    }
    private ArrayList<Carta> cartasMezcladas(ArrayList<Carta> cartasAmezclar) {
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
        return cartasAmezclar;
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
        this.cartasEnJuego = new Stack<Carta>();
        ArrayList<Carta> mazo = new ArrayList<>();
        mazo = crearMazo();
        this.cartasEnJuego.addAll(mazo);
        this.cartasUsadas = new ArrayList<>();
    }
    private ArrayList<Carta> crearMazo() {
        Carta cardToAdd = null;
        String paloDeCarta = null;
        ArrayList<Carta> mazo = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 0:
                    paloDeCarta = "copa";
                    break;
                case 1:
                    paloDeCarta = "basto";
                    break;
                case 2:
                    paloDeCarta = "oro";
                    break;
                case 3:
                    paloDeCarta = "espada";
                    break;
                default:
                    break;
            }
            for (int j = 1; j < 13; j++) {
                cardToAdd = new Carta(j, paloDeCarta);
                mazo.add(cardToAdd);
            }
        }
        return mazo;
    }

}
