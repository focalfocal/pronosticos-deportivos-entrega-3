package com.mycompany.pronosticosdeportivos3;

import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class UnParticipante {
    
    private static final int PTOS_EXTRA_POR_RONDA_ACERTADA = Integer.parseInt(Configuracion.configuracion.get("puntos extra por ronda acertada")); //
    private static final int PTOS_EXTRA_POR_FASE_ACERTADA = Integer.parseInt(Configuracion.configuracion.get("puntos extra por fase acertada")); //
    private static final int PARTIDOS_POR_RONDA = Integer.parseInt(Configuracion.configuracion.get("partidos por ronda")); // uso solo para determinar puntos extra por ronda y fase
    private static final int PARTIDOS_POR_FASE = Integer.parseInt(Configuracion.configuracion.get("partidos por fase")); // uso solo para determinar puntos extra por ronda y fase
    
    private String id;
    private String nombre;
    private ArrayList<UnPronostico> pronosticos; //cada participante tiene todos sus pronosticos
    private int puntaje;
    private int acertados;
    
    public UnParticipante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pronosticos = new ArrayList();  //inicializacion para poder agregar elementos aun estando vacio
        this.puntaje = 0;
        this.acertados = 0;
    }

    public void agregarPronostico (UnPronostico pronostico){
        this.pronosticos.add(pronostico);
    }
    
    //Calcula puntajes de todos los pronosticos de un participante
    public void evaluarPronosticos( Rondas rondas ){
        
        int aciertosEnRonda = 0;
        int noAciertosEnRonda = 0;
        int aciertosEnFase = 0;
        int noAciertosEnFase = 0;
        
        //unPronostico es el de un solo partido
        for (UnPronostico unPronostico : this.pronosticos){
            
            //determina cual es el partido jugado correspondiente a este pronostico de un partido
            PartidoJugado partidoJugadoCorresp = this.determinarPartJugadoCorrespondiente(unPronostico, rondas); 
            
            //determina puntaje correspondiente a este pronostico        
            int[] puntosEtc = partidoJugadoCorresp.evalPronUnPartido(unPronostico);
            
            this.puntaje += puntosEtc[0];
            this.acertados += puntosEtc[1];
            
            //Incrementa contadores
            if (puntosEtc[1] == 1){
                //si hubo un acierto:
                aciertosEnRonda += 1;
                aciertosEnFase += 1;
            } 
            else {
                //si no hubo un acierto
                noAciertosEnRonda += 1;
                noAciertosEnFase += 1;
            }
            
            //si acertó todos los partidos en una ronda, asigna puntos
            if (aciertosEnRonda == PARTIDOS_POR_RONDA){
                this.puntaje += PTOS_EXTRA_POR_RONDA_ACERTADA;
                //el final de ronda es detectado mas abajo y se inicializan contadores
                //aciertosEnRonda = 0;
                //noAciertosEnRonda = 0;
            }
            
            //si acertó todos los partidos en una fase, asigna puntos
            if (aciertosEnFase == PARTIDOS_POR_FASE){
                this.puntaje += PTOS_EXTRA_POR_FASE_ACERTADA;
                //el final de ronda es detectado mas abajo y se inicializan contadores
                //aciertosEnRonda = 0;
                //noAciertosEnRonda = 0;
            }
            
            //si terminó la ronda
            if ((aciertosEnRonda + noAciertosEnRonda) == PARTIDOS_POR_RONDA){
                aciertosEnRonda = 0;
                noAciertosEnRonda = 0;
            }
            
            //si terminó la fase
            if ((aciertosEnFase + noAciertosEnFase) == PARTIDOS_POR_FASE){
                aciertosEnFase = 0;
                noAciertosEnFase = 0;
            }
            
            //si es acertado, sumar acierto a ronda y a fase. Si cambia de ronda o fase, si es cantidad de aciertos igual a partidos por ronda o partidos por fase asignar puntos extra a this.puntaje y resetear contador partidos en ronda o fasse, 
            //acumulara partido ganado, luego recorrer viendo rondas, luego viendo fases
        }
    }

    
    //Dado un pronostico, determina cual es el partido jugado (con correspondencia de ronda y equipos)
    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico, Rondas rondas){
        
        // ids de ronda + ids de equipos
        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaRondaEquipos();
        
        for (PartidoJugado partido : rondas.getPartidos() ){
            //System.out.println("partido.getIdCombinadaEquipos() = " + partido.getIdCombinadaEquipos());
            //System.out.println("idCombinadaEquiposPronost = " + idCombinadaEquiposPronost);
            //System.out.println(".................................................");
 
            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
                return partido;
            }
        }
        
        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
        System.exit(4);
        return new PartidoJugado(); //formalidad para cumplir sintaxis de metodo.
    } 

    
    public void agregarPuntaje (ArrayList<ArrayList<Object>> participantesYpuntajes) {

        ArrayList<Object> datosParticipante = new ArrayList<>();
        datosParticipante.add(this.nombre);
        datosParticipante.add(this.puntaje);
        datosParticipante.add(this.acertados);
        
        participantesYpuntajes.add(datosParticipante);  
    }
    
    
    public void imprimirDatos (ArrayList<ArrayList<Object>> participantesYpuntajes) {
        System.out.println(this.nombre + ": \t" + this.puntaje + "\t"  + this.acertados);
    }
    
    
    //-----------------------------------------------------------------------------------
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pronosticos
     */
    public ArrayList<UnPronostico> getPronosticos() {
        return pronosticos;
    }

    /**
     * @param pronosticos the pronosticos to set
     */
    public void setPronosticos(ArrayList<UnPronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the acertados
     */
    public int getAcertados() {
        return acertados;
    }

    /**
     * @param acertados the acertados to set
     */
    public void setAcertados(int acertados) {
        this.acertados = acertados;
    }
    
}
