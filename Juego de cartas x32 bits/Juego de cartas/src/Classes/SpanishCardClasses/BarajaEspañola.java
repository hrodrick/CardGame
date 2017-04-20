package Classes.SpanishCardClasses;

import Classes.*;
import java.util.ArrayList;


public class BarajaEspañola extends Baraja {

    public BarajaEspañola(){
        super();
    }
    
    public ArrayList<Carta> generarMazo(){
        ArrayList<Carta> mazo = crearCartas();
        
        return mazo;
    }
    
    @Override
    protected ArrayList<Carta> crearCartas() {

        ArrayList<Carta> mazo = new ArrayList<>();
        Carta cardToAdd = null;
        int i;
        for (i = 0; i < 12; i++) {
            cardToAdd = new Copa(i);
            mazo.add(cardToAdd);
            cardToAdd = new Basto(i);
            mazo.add(cardToAdd);
            cardToAdd = new Oro(i);
            mazo.add(cardToAdd);
            cardToAdd = new Espada(i);
            mazo.add(cardToAdd);
        }
        return mazo;
    }
    
}
