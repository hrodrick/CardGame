package Classes;

/**
 *
 * @author Rodrigo Soria
 */
public class Carta {

    private String palo;
    private int numero;

    public String getPalo() {
        return palo;
    }
    public int getNumero() {
        return numero;
    }
    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    public boolean validarPalo() {
        boolean resp;
        if (palo.equalsIgnoreCase("basto")
                || palo.equalsIgnoreCase("copa")
                || palo.equalsIgnoreCase("oro")
                || palo.equalsIgnoreCase("espada")) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }
    public boolean validarNumero() {
        boolean resp = false;
        if (numero <= 12 && numero > 0) {
            resp = true;
        }
        return resp;
    }
    public int compareTo(Carta anotherCard) {
        int resp = 0; // 1: Esta es mayor. (que anotherCard) | -1: esta es menor (que anotherCard).
        int priorAnother = prioridadCarta(anotherCard);
        int priorThis = prioridadCarta();
        //(prior represents palo in an int format)
        resp = comparePriorities(priorThis, priorAnother);
        if (resp == 0) {
            if (this.numero < anotherCard.numero) {
                resp = -1;
            } else {
                resp = 1;
            }
        }
        return resp;
    }
    private int prioridadCarta() {
        int prior = 0;
        if (palo.equalsIgnoreCase("copa")) {
            prior = 1;
        }
        if (palo.equalsIgnoreCase("basto")) {
            prior = 2;
        }
        if (palo.equalsIgnoreCase("oro")) {
            prior = 3;
        }
        if (palo.equalsIgnoreCase("espada")) {
            prior = 4;
        }

        return prior;
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
     @Override
    public String toString() {
        return "Carta{" + "palo=" + palo + ", numero=" + numero + '}';
    }
}
