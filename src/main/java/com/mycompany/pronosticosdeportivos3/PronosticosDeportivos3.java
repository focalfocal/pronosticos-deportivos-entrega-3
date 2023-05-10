package com.mycompany.pronosticosdeportivos3;

import java.sql.*;
import java.util.ArrayList;

/**
 * Pronosticos Deportivos - Entrega 3
 * @author dd
 * Java 11 (LTS)
 * Suposiciones / bases:
 * - Se supone que el orden en que se indican los dos equipos en un partido es el mismo tanto para los resultados de ese partido como para el pronóstico (condición local-visitante). 
 * - Los archivos de resultados y pronósticos incluyen varias rondas. También incluyen las columnas de fase (par etapa 3), pero no se utilizan aquí todavía.
 *
 */
public class PronosticosDeportivos3 {
    
    enum ResultadoEnum{
        GANADO,
        EMPATADO,
        PERDIDO
    }
    
    //En Netbeans, los valores de los argumentos se colocan en File---Project Properties --- Categories: Run ---- Arguments  y van separados por espacios
    public static void main(String[] args) throws Exception {
        //ArrayList<String[]> filas = new ArrayList<>();
        

//        String nombreTabla =  "pronostico_separador_coma";
//        
//        String url = "jdbc:mysql://localhost:3306/pronosticos_pron_deportivos";
//        String username = "root";
//        String password = ""; //default de Xampp Mysql
//        
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        // Crea objeto statement para ejecutar queries SQL
//        Statement statement = connection.createStatement();
//
//        // Ejecuta un query para leer los contenidos de la tabla
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
//
//        // Obtiene el numero de columnas en el objeto resultSet
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int numColumnas = metaData.getColumnCount();
//
//        // Recorre cada fila en los resultados (objeto resultSet)
//        while (resultSet.next()) {
//            
//            String[] valores = new String[numColumnas];
//
//            for (int i = 1; i <= numColumnas; i++) {
//                valores[i - 1] = resultSet.getString(i);
//            }
//
//            // Add the row to the ArrayList
//            filas.add(valores);
//        }
//
//        // Cierrra el conjunto de resultados (resultSet), la sentencia SQL y la conexion
//        resultSet.close();
//        statement.close();
//        connection.close();
        
     
        //filas = LectorBD.leerTabla("pronostico_separador_coma");
        
        //....................................................................
        // Recorre e imprime valores
        //    for (String[] fila : filas) {
        //        for (String valor : fila) {
        //            System.out.print(valor + "\t");
        //        }
        //        System.out.println();
        //    }
            
        //System.exit(8);    
        
        //###################################################################
        //Lee la configuracion de archivo hacia objeto estatico
        //Configuracion configuracion = new Configuracion( args[0] );
        Configuracion.leerConfiguracion( args[0] );
        //System.out.println(Configuracion.configuracion.size());
        //System.out.println("leida config txt");
        //Crea objeto ronda con todos los partidos jugados, leidos de archivo
        Rondas ronda = new Rondas( args[1] );
        
        //Crea objeto Participantes con todos los pronosticos, leidos de archivo
        Participantes participantes = new Participantes( ronda );
        
        participantes.evaluarPronosticosParticipantes();
        
        participantes.imprimirParticipantesYpuntajes();
         
    }
}
