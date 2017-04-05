
package Classes;

/**
 *
 * @author Rodrigo Soria
 */
public class Carta {
    private String palo;
    private int numero;
    
    public String getPalo(){
        return palo;
    }
    public int getNumero(){
        return numero;
    }
    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }
    boolean validarPalo(){
        boolean resp;
        if(palo.equalsIgnoreCase("basto") || 
           palo.equalsIgnoreCase("copa") ||
           palo.equalsIgnoreCase("oro") ||
           palo.equalsIgnoreCase("espada")){
            resp = true; 
        }else{
            resp = false;
        }
        return resp;
    }
    boolean validarNumero(){
        boolean resp = false;
        if(numero <= 12 && numero >0) resp = true;
        return resp;
    }
    @Override
    public String toString() {
        return "Carta{" + "palo=" + palo + ", numero=" + numero + '}';
    }
}
