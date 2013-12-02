
import java.util.ArrayList;

public class MensajeriaUrgente
{
    ArrayList<String> contenidoArchivo;
    boolean traza;      // true si queremos mostrar traza de ejecucion
    String salida;      // nombre del archivo en el que queremos la salida
    int[] solucion; // 
    Algoritmo algoritmo;

    public MensajeriaUrgente(boolean traza, boolean ayuda, String entrada, String salida)
    {
        if (ayuda == true) {
            mostrarAyuda();
            System.exit(0); 
        } else {
            if (entrada == null) {
                System.out.println("Falta el parámetro con el archivo de entrada");
                System.exit(0);
            }
        }
        this.traza = traza;
        if (salida != null) this.salida = salida;
        
        contenidoArchivo = ManejadorFicheros.getInstancia().leerFichero(entrada);
        // imprime contenido del archivo
        System.out.println("Contenido: " + contenidoArchivo);
        
        invocarAlgoritmo();
        devolverSolucion(algoritmo.ejecutarAlgoritmo());
    }

    private  void mostrarAyuda()
    {
        // Imprime la ayuda y sale del programa
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println("Invoque el programa con los siguientes argumentos:");
        System.out.println("");
        System.out.println("\t -t -h fichero_entrada fichero_salida");
        System.out.println("");
        System.out.println("-t: muetra traza de ejecución");        
        System.out.println("-h: muestra esta ayuda");
        System.out.println("fichero_entrada: nombre del fichero con datos del vehículo,nº de gasolineras y distancias. Obligatorio.");
        System.out.println("fichero_salida: almacena la salida. Si se omite, salida por pantalla.");  
        System.out.println("*****************************************************");
    }
    
    private void invocarAlgoritmo() {
        try {
            int kilometros    = Integer.parseInt(contenidoArchivo.get(0));
            int gasolineras   = Integer.parseInt(contenidoArchivo.get(1));
            int [] distancias = new int[gasolineras-1];
            for (int i=0; i<gasolineras; i++) {
                distancias[i] = Integer.parseInt(contenidoArchivo.get(2+i));
            }
            algoritmo = new Algoritmo(distancias, kilometros, gasolineras, traza);
        } catch (NumberFormatException e) {
            System.out.println("El archivo de entrada sólo puede contener números");
        }       
    }
    
    private void devolverSolucion (boolean[] respuesta) {
        for (int i=0; i<respuesta.length; i++) {
            System.out.println("Paramos en " + (i+1) + ": " + respuesta[i]);
        }
    }
}
