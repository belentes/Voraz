import java.io.*;
import java.util.ArrayList;

/**
 * Write a description of class LeerEscribirFicheros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ManejadorFicheros
{
    // instance variables - replace the example below with your own
    
    private static ManejadorFicheros instancia = new ManejadorFicheros();
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static ManejadorFicheros getInstancia()
    {
        return instancia;
    }
    
    public ArrayList<String> leerFichero(String nombre) 
    {
        ArrayList<String> contenido = new ArrayList<String>();
        String linea = "";
 
        try {
            // crea un BufferedReader para guardar el archivo
            br = new BufferedReader(new FileReader(nombre));
            
            // lee lineas y las guarda en el ArrayList contenido hasta que llega a una vacia
            while (true) {
                linea = br.readLine();
                if (linea != null) {
                    contenido.add(linea);
                } else {
                    break;
                }
            }
                      
            //cierra el BufferedReader tras usarlo
            br.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un problema:" + e);
        }
        
        return contenido;
    } 
    
    public void escribirFichero(String nombreFichero, String lineaAEscribir, boolean sinBorrar)
    {    
        try {
            // crea un BufferedWriter para el archivo
            bw = new BufferedWriter(new FileWriter(nombreFichero, sinBorrar));

            // Escribe la linea en el archivo 
            bw.write(lineaAEscribir);

            // cierra el BufferedWriter
            bw.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un problema:" + e);

        } 
    }
    
    boolean existeArchivo(String archivo)
    {
        if (new File(archivo).exists()) {
            return true;
        }
        return false;
    }
}
