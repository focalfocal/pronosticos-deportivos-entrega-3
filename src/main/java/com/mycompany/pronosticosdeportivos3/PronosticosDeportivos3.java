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
        ArrayList<String[]> rows = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/pronosticos_pron_deportivos";
        String username = "root";
        String password = ""; //default de Xampp Mysql
        String tableName =  "pronostico_separador_coma";
        
        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM pronostico_separador_coma");
//        statement.setInt(1, 18);
//        ResultSet resultSet = statement.executeQuery();
//        
//        while (resultSet.next()) {
//            System.out.println("1 fila");
//            //int id = resultSet.getInt("id");
//            //String name = resultSet.getString("name");
//            //int age = resultSet.getInt("age");
//            
//           // System.out.println(id + "\t" + name + "\t" + age);
//        }
//        
//        resultSet.close();
//        statement.close();
//        connection.close();
//        System.exit(9999);
        
        //-------------------------------------------------------------------
        // Create a statement object to execute SQL queries
        Statement statement = connection.createStatement();

        // Execute a query to retrieve the contents of the table
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

        // Retrieve the number of columns in the result set
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numColumns = metaData.getColumnCount();

        // Loop through each row of the result set
        while (resultSet.next()) {
            // Create a String array to hold the values for this row
            String[] values = new String[numColumns];

            // Loop through each column of the row and retrieve its value
            for (int i = 1; i <= numColumns; i++) {
                values[i - 1] = resultSet.getString(i);
            }

            // Add the row to the ArrayList
            rows.add(values);
        }

        // Close the result set, statement, and connection
        resultSet.close();
        statement.close();
        connection.close();
        //....................................................................
        // Loop through each row and print its values
            for (String[] row : rows) {
                for (String value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
            
        System.exit(9999);    
        
        //###################################################################
        //Crea objeto ronda con todos los partidos jugados, leidos de archivo
        Rondas ronda = new Rondas(args[0]);
        
        //Crea objeto Participantes con todos los pronosticos, leidos de archivo
        Participantes participantes = new Participantes(args[1], ronda);
        
        participantes.evaluarPronosticosParticipantes();
        
        participantes.imprimirParticipantesYpuntajes();
         
    }
}
