/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author Rodrigo Soria
 */
public class Simulador {
    
    Partido partido;
    
    public Simulador(Partido partido) {
        this.partido = partido;
    }
    
    public void simularPartido(boolean automatico) {
        Scanner userIntervention = new Scanner(System.in);
        BarajaEspañola mazo = new BarajaEspañola();
        mazo.mezclar();
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
        partido.jugadores.forEach((jugador) -> {
            if (!mazo.hayCartas()) {
                System.out.println("\nMazo vacio. Repartiendo nuevas cartas...");
                
                mazo.mezclar();
            }
            jugador.setCarta(mazo.darLaCartaDeArriba());
        });
    }

    private void recuperaCartas(BarajaEspañola mazo) {
        partido.jugadores.forEach((jugador) -> {
            mazo.guardarCartaUsada(jugador.devolverCarta());
        });
    }

    public void simularVuelta() {
        //establezco la vuelta.
        //juego.
        //guardo las vueltas.
        Vuelta vuelta = new Vuelta();
        for (int i = 0; i < partido.jugadores.size(); i++) {
            vuelta.agregarMano(partido.jugadores.get(i), partido.jugadores.get(i).getCarta());
        }
        
        Jugador ganador = compareAndGetWinner();
        imprimirVuelta();
        imprimirGanadorDeMano(ganador);
        ganador.sumaUnPunto();
        partido.vueltas.add(vuelta);
        
    }

    private Jugador compareAndGetWinner() {
        Jugador ganador = null;
        Jugador next = null;
        int i = 0;
        ganador = partido.jugadores.get(i);
        for (i = 1; i < partido.jugadores.size(); i++) {
            next = partido.jugadores.get(i);
            if (ganador.getCarta().compareTo(next.getCarta()) == -1) {
                ganador = next;
            }
        }
        return ganador;
    }

    public void imprimirVuelta() {
        int ronda = partido.vueltas.size();
        System.out.println("\nRonda " + ronda + ": ");
        partido.jugadores.forEach((jugador) -> {
            System.out.println(jugador.getNombre() + ": " + jugador.getCarta().toString() + " puntos: " + jugador.getPuntos());
        });
    }

    private void imprimirGanadorDeMano(Jugador winner) {
        System.out.println();
        System.out.print("Ganador de la ronda: " + winner.getNombre());
    }

    public void imprimirPuntuaciones() {
        System.out.println();
        System.out.println("Puntuaciones: ");
        partido.jugadores.forEach((jugador) -> {
            System.out.print(jugador.getNombre() + ": " + jugador.getPuntos() + " || ");
        });
    }

    public void limpiarConsola() {
        //System.out.close();
        
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
            cantJugadores = entradaTeclado.nextInt();
            
            if (cantJugadores < 2 || cantJugadores > 6) {
                System.out.println("Cantidad incorrecta, inserte 2 a 6 jugadores");
            }
        } while (cantJugadores < 2 || cantJugadores > 6);
        
        return cantJugadores;
    }

    private void agregarJugadoresAlPartido(Scanner entradaTeclado, int cantJugadores) {
        Jugador jugador = null;
        String nombre;
        nombre = entradaTeclado.nextLine(); // El buffer debía ser limpiado?? - ignorará esta linea.
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
