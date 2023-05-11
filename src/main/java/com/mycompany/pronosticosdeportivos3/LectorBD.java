package com.mycompany.pronosticosdeportivos3;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class LectorBD {
    
    public static ArrayList<String[]> leerTabla ( String nombreDeTabla ) {
        ArrayList<String[]> filas = new ArrayList<>();
        
        try{

            String direccionBD = Configuracion.configuracion.get("direccionBD");
            String username = Configuracion.configuracion.get("username");
            String password = Configuracion.configuracion.get("password");

            Connection connection = DriverManager.getConnection(direccionBD, username, password);

            // Crea objeto statement para ejecutar queries SQL
            Statement statement = connection.createStatement();

            // Ejecuta un query para leer los contenidos de la tabla
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreDeTabla);

            // Obtiene el numero de columnas en el objeto resultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumnas = metaData.getColumnCount();

            // Recorre cada fila en los resultados (objeto resultSet)
            while (resultSet.next()) {

                String[] valores = new String[numColumnas];

                for (int i = 1; i <= numColumnas; i++) {
                    valores[i - 1] = resultSet.getString(i);
                }

                // Add the row to the ArrayList
                filas.add(valores);
            }

            // Cierrra el conjunto de resultados (resultSet), la sentencia SQL y la conexion
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(7); 
        }
        
        return filas;
    }
}
