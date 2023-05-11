package com.mycompany.pronosticosdeportivos3;

import java.sql.*;
import java.util.ArrayList;

/**
 * Pronosticos Deportivos - Entrega 3
 * @author dd
 * Java 11 (LTS)
 * Suposiciones / bases:
 * - Se supone que el orden en que se indican los dos equipos en un partido es el mismo tanto para los resultados de ese partido como para el pronóstico (condición local-visitante). 
 * - Los archivos de resultados y pronósticos incluyen varias rondas y una fase.
 * - Para el cálculo de los puntos extra por ronda o fase acertadas, se supone que en el archivo pronostico.csv los pronosticos están ordenados (agrupados) por fase y por ronda.
 *  - Por igual motivo se supone que las rondas y las fases tienen una cantidad fija de partidos, dadas en el archivo de configuracion.
 *  Archivos de prueba en src/test/resources
 */
public class PronosticosDeportivos3 {
    
    enum ResultadoEnum{
        GANADO,
        EMPATADO,
        PERDIDO
    }
    
    //En Netbeans, los valores de los argumentos se colocan en File---Project Properties --- Categories: Run ---- Arguments  y van separados por espacios.
    public static void main(String[] args) throws Exception {

        //Lee la configuracion de archivo hacia objeto estatico

        Configuracion.leerConfiguracion( args[0] );

        //Crea objeto ronda con todos los partidos jugados, leidos de archivo
        Rondas ronda = new Rondas( args[1] );
        
        //Crea objeto Participantes con todos los pronosticos, leidos de archivo
        Participantes participantes = new Participantes( ronda );
        
        participantes.evaluarPronosticosParticipantes();
        
        participantes.imprimirParticipantesYpuntajes();
         
    }
}
