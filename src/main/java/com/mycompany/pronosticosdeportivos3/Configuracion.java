package com.mycompany.pronosticosdeportivos3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jul
 */
public class Configuracion {
    
    public static HashMap<String, String> configuracion;
    
    //lee archivo con parametros de configuracion
    public static void leerConfiguracion ( String ruta ){
        //crea objeto a retornar
        HashMap<String, String> filas = new HashMap();
        ArrayList<String[]> filasParseadas = new ArrayList();
        
        filasParseadas = LectorArchivos.leerArchivo(ruta);
        
        String clave;
        String valor;
        
        int contador = 2; //contador de filas. Fila 1: titulos
        //cantidad maxima de campos en cada fila del archivo de oonfiguracion
        final int  maxCampos = 2;
        
        for (String[] i : filasParseadas){

            //chequeo de que cada linea tenga la cantidad correcta de campos
            if ( i.length != maxCampos) {
                
                System.err.println( "La fila numero " + contador + " del archivo tiene " + i.length +" campos. Deberia tener " + maxCampos + " campos");
                System.err.println( "Revisar el origen del problema");
                System.err.println( "ruta del archivo: " + ruta);
                
                System.exit(2);
            }
            
            filas.put( i[0], i[1] );
            
        } //for
        
        Configuracion.configuracion = filas;
    } //leerConfiguraion
    
}
