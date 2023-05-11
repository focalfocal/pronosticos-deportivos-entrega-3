package com.mycompany.pronosticosdeportivos3;

import java.io.File;  // operaciones con archivos. Version mas moderna java.nio
//java.io.readLine() visto en teoría con Carlos está deprecado en Java 11
import java.io.FileNotFoundException;
import java.util.Scanner; // lectura de archivos de texto
import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class LectorArchivos {

    //Supone que todas las filas de un archivo (luego del primero), hasta el final del archivo, son útiles.
    //IMPORTANTE: Omite primera fila
    public static ArrayList<String[]> leerArchivo(String ruta){ //leerTablaBD
        
        ArrayList<String[]> filasParseados = new ArrayList();
        Scanner miLector = null;
        
        try {
            //  Al instanciar o crear el objeto, abre el archivo.
            File objetoMiArchivo = new File( ruta );
            miLector = new Scanner(objetoMiArchivo);

            String fila;
            int nroFila = 0;
            
            while (miLector.hasNextLine()) {
                fila = miLector.nextLine();

                if (nroFila > 0){
                    //parsea los campos de una fila y los guarda
                    filasParseados.add(fila.split(";"));

                }
                nroFila++;
            }

            //  Cerramos el archivo.
            miLector.close();
            
            return filasParseados;
            
          } //end try

          catch ( FileNotFoundException e ) {
            System.err.println( "Archivo inexistente."
                              + "\nEl programa se cancela." );
            System.exit(8);
          }

          //todo otro tipo de error
          catch ( Exception e ) {
            System.err.println( "Error: " + e
                              + "\nEl programa se cancela." );
            System.exit(9);
          }
        
          finally{
              try {
                    if (miLector != null) {
                        miLector.close();
                    }
                } catch (Exception e) {
                     System.err.println( "Error: " + e
                              + "\nEl programa se cancela." );
                    System.exit(9);
                }
        }
        
        return filasParseados;
        
    } //end leerArchivo   
}
