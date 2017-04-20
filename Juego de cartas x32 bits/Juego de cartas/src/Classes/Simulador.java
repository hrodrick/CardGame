
package Classes;

import java.util.Scanner;
import Classes.SpanishCardClasses.*;

public class Simulador {
    
    Partido partido;
    
    public Simulador(Partido partido) {
        this.partido = partido;
    }
    
    public void simularPartido(boolean automatico) {
        Scanner userIntervention = new Scanner(System.in);
        BarajaEspañola mazo = new BarajaEspañola();
        mazo.generarMazo();
        while (!partido.partidoTerminado()) {
            
            waitForInput(automatico, userIntervention, "Se repartiran la cartas entre los jugadores");
            reparteCartas(mazo);
            waitForInput(automatico, userIntervention, "cartas repartidas. Jugar?");
            simularVuelta();
            waitForInput(automatico, userIntervention, "Vuelta concluida, presione cualquier tecla y enter para ver puntuaciones");
            imprimirPuntuaciones();
            waitForInput(automatico, userIntervention, "Se quitarán las cartas a los jugadores y serán almacenadas en un mazo aparte.");
            recuperaCartas(mazo);
        }
        
        Jugador ganador = partido.getGanador();
        System.out.println();
        System.out.println("El ganador es: " + ganador.getNombre() + "!");
    }
    private void waitForInput(boolean automatico, Scanner userIntervention, String message){
        if(!automatico){
                System.out.println("\n"+message);
                userIntervention.next();
            }
    }
    
    private void reparteCartas(BarajaEspañola mazo) {
        for(Jugador jugador : partido.jugadores){
            if (!mazo.hayCartas()) {
                System.out.println("\nMazo vacio. Repartiendo nuevas cartas...");
                
                mazo.mezclar();
            }
            jugador.setCarta(mazo.darLaCartaDeArriba());
        }
    }

    private void recuperaCartas(BarajaEspañola mazo) {
        for(Jugador jugador : partido.jugadores){
            mazo.guardarCartaUsada(jugador.devolverCarta());
        }
    }

    public void simularVuelta() {
        //establezco la vuelta.
        //juego.
        //guardo las vueltas.
        Vuelta vuelta = new Vuelta();
       partido.jugarUnaVuelta();
        imprimirVuelta();
        
    }

    public void imprimirVuelta() {
        int ronda = partido.vueltas.size();
        System.out.println("\nRonda " + ronda + ": ");
        for(Jugador jugador : partido.jugadores)
        {
            System.out.println(jugador.getNombre() + ": " + jugador.getCarta().toString());
        }
    }

    private void imprimirGanadorDeMano(Jugador winner) {
        System.out.println();
        System.out.print("Ganador de la ronda: " + winner.getNombre());
    }

    public void imprimirPuntuaciones() {
        System.out.println();
        System.out.println("Puntuaciones: ");
        for(Jugador jugador : partido.jugadores){
            System.out.print(jugador.getNombre() + ": " + jugador.getPuntos() + " || ");
        }
    }

    public void limpiarConsola() {
        for(int i = 0; i < 50; i++)
            System.out.println(" ");
        
    }

    public void controlarSimulacion() {
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

    private int setCantidadDeJugadores(Scanner entradaTeclado) {
        int cantJugadores = 0;
        System.out.println("Cuantos jugadores hay en la mesa? (de 2 a 6)");
        do {
            cantJugadores = Integer.parseInt(entradaTeclado.nextLine());
            
            if (cantJugadores < 2 || cantJugadores > 6) {
                System.out.println("Cantidad incorrecta, inserte 2 a 6 jugadores");
            }
        } while (cantJugadores < 2 || cantJugadores > 6);
        
        return cantJugadores;
    }

    private void agregarJugadoresAlPartido(Scanner entradaTeclado, int cantJugadores) {
        Jugador jugador = null;
        String nombre;
        
        for (int i = 0; i < cantJugadores; i++) {
            System.out.println("Ingrese nombre del jugador " + (i + 1));
            nombre = entradaTeclado.nextLine();
            jugador = new Jugador(nombre);
            partido.jugadores.add(jugador);
        }
    }

    private boolean setControlDelJuego(Scanner entradaTeclado) {
        boolean automatico = true;
        System.out.println("Desea controlar la simulacion del juego? 1 = si / 0 = no");
        int resp = 0;
        
        do {
            resp = entradaTeclado.nextInt();
            if (resp != 1 && resp != 0) {
                System.out.println("Cantidad incorrecta, ingrese 1(si) o 0(no)");
            }
        } while (resp != 1 && resp != 0);
        
        if (resp == 1) {
            automatico = false;
        }
        return automatico;
    }

    private void startMessage(Scanner entradaTeclado) {
        System.out.println("presione cualquier tecla y enter para comenzar.");
        entradaTeclado.next();
    }
    public void start(){
        controlarSimulacion();
    }
}
