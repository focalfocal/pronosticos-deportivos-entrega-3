package com.mycompany.pronosticosdeportivos3;

import com.mycompany.pronosticosdeportivos3.PronosticosDeportivos3.ResultadoEnum;

/**
 *
 * @author jul
 */
public class UnPronostico {
    
    private String idCombinadaRondaEquipos; //Para identificar los partidos de forma unívoca para su correcto procesamiento
    private String idRonda;
    private String idEquipo1;
    private String idEquipo2;
    private PronosticosDeportivos3.ResultadoEnum pronosticoEquipo1; //Los resultados del equipo 2 se deducen inmediatamente en base al pronostico para equipo1
    
    UnPronostico (String idRonda, String idEquipo1, String idEquipo2, String gana, String empata, String pierde){
        this.idCombinadaRondaEquipos = idRonda + "+" + idEquipo1 + "+" + idEquipo2;
        this.idRonda = idRonda;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        if (gana.equals("X")){
            this.pronosticoEquipo1 = ResultadoEnum.GANADO;
        } else if (empata.equals("X")){
            this.pronosticoEquipo1 = ResultadoEnum.EMPATADO;
        } else {
            this.pronosticoEquipo1 = ResultadoEnum.PERDIDO;
        }
    }

    /**
     * @return the idCombinadaRondaEquipos
     */
    public String getIdCombinadaRondaEquipos() {
        return idCombinadaRondaEquipos;
    }

    /**
     * @param idCombinadaRondaEquipos the idCombinadaRondaEquipos to set
     */
    public void setIdCombinadaRondaEquipos(String idCombinadaRondaEquipos) {
        this.idCombinadaRondaEquipos = idCombinadaRondaEquipos;
    }

    /**
     * @return the idEquipo1
     */
    public String getIdEquipo1() {
        return idEquipo1;
    }

    /**
     * @param idEquipo1 the idEquipo1 to set
     */
    public void setIdEquipo1(String idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    /**
     * @return the idEquipo2
     */
    public String getIdEquipo2() {
        return idEquipo2;
    }

    /**
     * @param idEquipo2 the idEquipo2 to set
     */
    public void setIdEquipo2(String idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    /**
     * @return the pronosticoEquipo1
     */
    public PronosticosDeportivos3.ResultadoEnum getPronosticoEquipo1() {
        return pronosticoEquipo1;
    }

    /**
     * @param pronosticoEquipo1 the pronosticoEquipo1 to set
     */
    public void setPronosticoEquipo1(PronosticosDeportivos3.ResultadoEnum pronosticoEquipo1) {
        this.pronosticoEquipo1 = pronosticoEquipo1;
    }


}
