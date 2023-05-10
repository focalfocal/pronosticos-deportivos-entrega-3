package com.mycompany.pronosticosdeportivos3;

import java.io.File;  // operaciones con archivos. Version mas moderna java.nio
//java.io.readLine() visto en teoría con Carlos está deprecado en Java 11
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; // lectura de archivos de texto
import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class LectorArchivos {

    //Supone que todos los renglones de un archivo (luego del primero), hasta el final del archivo, son útiles.
    //IMPORTANTE: Omite primer renglon
    public static ArrayList<String[]> leerArchivo(String ruta){ //leerTablaBD
        
        ArrayList<String[]> renglonesParseados = new ArrayList();
        Scanner miLector = null;
        
        try {
            //  Al instanciar o crear el objeto, abrimos el archivo.
            //File objetoMiArchivo = new File( ruta );
            File objetoMiArchivo = new File( ruta );
            miLector = new Scanner(objetoMiArchivo);

            String renglon;
            int nroRenglon = 0;
            
            while (miLector.hasNextLine()) {
                renglon = miLector.nextLine();
                //System.out.println(renglon);
                //omite renglon inicial de titulos
                if (nroRenglon > 0){
                    //parsea los campos de un renglon y los guarda
                    renglonesParseados.add(renglon.split(";"));
                    //System.out.println(renglon.split(";"));
//                    String[] abc = renglon.split(";");
//                    for (int i = 0; i<abc.length; i++){
//                        System.out.print(abc[i] + "\t");
//                        System.out.println();
                    //}
                }
                nroRenglon++;
            }

            //  Cerramos el archivo.
            miLector.close();
            
            return renglonesParseados;
            
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
        
        return renglonesParseados;
        
    } //end leerArchivo   
}
