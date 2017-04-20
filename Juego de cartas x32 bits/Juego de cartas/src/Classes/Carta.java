package Classes;


public class Carta {

    private int numero;
    
    public int getNumero() {
        return numero;
    }
    public Carta(int numero) {
        this.numero = numero;
    }
    /*
    public int compareTo(Carta anotherCard) {
        int resp = 0; // 1: Esta es mayor. (que anotherCard) | -1: esta es menor (que anotherCard).
        int priorAnother = prioridadCarta(anotherCard);
        int priorThis = prioridadCarta();
        //(prior represents palo in an int format)
        resp = comparePriorities(priorThis, priorAnother);
        
        return resp;
    }
    
    private int prioridadCarta(Carta anotherCard) {
        int prior = 0;
        if (anotherCard.palo.equalsIgnoreCase("copa")) {
            prior = 1;
        } else if (anotherCard.palo.equalsIgnoreCase("basto")) {
            prior = 2;
        } else if (anotherCard.palo.equalsIgnoreCase("oro")) {
            prior = 3;
        } else if (anotherCard.palo.equalsIgnoreCase("espada")) {
            prior = 4;
        }

        return prior;
    }
    
    */
    }