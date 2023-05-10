package com.mycompany.pronosticosdeportivos3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jul
 */
public class Configuracion {
    
    public static HashMap<String, String> configuracion;
    
    //public Configuracion( String ruta ) {
//        this.configuracion = new HashMap();
//        //lee la configuracion de archivo
//        this.leerConfiguracion ( ruta );
//        Configuracion.configuracion = new HashMap();
//        //lee la configuracion de archivo
//        Configuracion.leerConfiguracion ( ruta );
        
        //lee la configuracion de archivo
    //    this.configuracion = this.leerConfiguracion ( ruta );
    //} 
    
    //public static HashMap<String, String> leerConfiguracion ( String ruta ){
    public static void leerConfiguracion ( String ruta ){
        //crea objeto a retornar
        HashMap<String, String> filas = new HashMap();
        ArrayList<String[]> filasParseadas = new ArrayList();
        
        filasParseadas = LectorArchivos.leerArchivo(ruta);
        //System.out.print("tamanio filas parseadas: " + filasParseadas.size());
        
        String clave;
        String valor;
        
        int contador = 2; //contador de filas. Fila 1: titulos
        //cantidad maxima de campos en cada fila del archivo de oonfiguracion
        final int  maxCampos = 2;
        
        for (String[] i : filasParseadas){
            //System.out.println( "La fila numero " + contador + " del archivo tiene " + i.length +" campos");
            //System.out.println( i.toString());
            //System.out.println();
        
            //chequeo de que cada linea tenga la cantidad correcta de campos
            if ( i.length != maxCampos) {
                
                System.err.println( "La fila numero " + contador + " del archivo tiene " + i.length +" campos. Deberia tener " + maxCampos + " campos");
                System.err.println( "Revisar el origen del problema");
                System.err.println( "ruta del archivo: " + ruta);
                
                System.exit(2);
            }
            
            filas.put( i[0], i[1] );
            
            
//            try{
//                filas.put( i[0], i[1] );
//                
//                golesEquipo1 = Integer.parseInt(i[7]);
//                golesEquipo2 = Integer.parseInt(i[8]);
//                
//                //crea equipo si no existe, y lo agrega al atributo equipos
//                crearEquipoSiNoExiste(i[4], i[5], i[6]); //equipo1
//                crearEquipoSiNoExiste(i[9], i[10], i[11]); //equipo2
//
//                //En etapa 1 un partido contenía los equipos. Ahora solo tiene el id del equipo.
//                PartidoJugado partidoJugado = new PartidoJugado(i[2], i[3], i[4], i[9], golesEquipo1, golesEquipo2);
//
//                this.partidos.add(partidoJugado);
//                
//            } catch (Exception e) {
//                
//                System.err.println( "La fila numero " + contador + " del archivo de resultados tiene algun problema en su formato y no puede ser pasado a String");
//                //System.err.println( "Goles Equipo1: " + i[7]);
//                //System.err.println( "Goles Equipo2: " + i[8]);
//                
//                System.exit(2);
//            }
//            
//            contador++;
            
        } //for
        
        
        //return new HashMap<String, String>();
        //return filas;
        Configuracion.configuracion = filas;
    }
    
}
