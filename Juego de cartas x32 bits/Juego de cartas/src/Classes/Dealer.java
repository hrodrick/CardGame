package Classes;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Soria
 */
public class Dealer extends Jugador{

    Baraja baraja;

    public Dealer(String nombre) {
        super(nombre);
        this.baraja = null;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public void darCarta(Jugador jugador) {
        if (quedanCartas()) {
            jugador.setCarta(baraja.desapilarUnaCarta());
        } else {
            mezclarCartas();
        }

    }

    public void guardarCarta(Carta carta) {
        baraja.agregarCartaUsada(carta);
    }

    public boolean quedanCartas() {
        return baraja.quedanCartas();
    }

    public void mezclarCartas() {
        ArrayList<Carta> cartasAmezclar = new ArrayList<>();
        if (!quedanCartas()) {
            cartasAmezclar = baraja.getCartasUsada();
            baraja.getCartasUsada().clear();
        } else {
            while(baraja.quedanCartas()){
               cartasAmezclar.add(baraja.desapilarUnaCarta());
            }
        }
        cartasAmezclar = cartasMezcladas(cartasAmezclar);
        baraja.apilarCartas(cartasAmezclar);
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
    
    
}
