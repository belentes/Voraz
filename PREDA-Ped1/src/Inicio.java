
public class Inicio
{
    public static void main(String[] args)
    {
        boolean traza = false;
        boolean ayuda = false;
        String entrada = null;
        String salida = null;
        
        if (args.length == 0 || args.length >4) {
            System.out.println("Número de parámetros incorrecto. -h para ayuda");
            System.exit(0);
        }
        
        for (int j=0; j<args.length; j++) {
            
            if (args[j].startsWith("-") ){
                if (args[j].equals("-t")) traza = true;
                if (args[j].equals("-h")) ayuda = true;
            } else {
                if (entrada == null) {
                    entrada = args[j];
                } else {
                    salida = args[j];
                }
            }            
        }
        new MensajeriaUrgente(traza, ayuda, entrada, salida);
        
        /*
        System.out.println ("Traza: " + traza);
        System.out.println ("Ayuda: " + ayuda);
        System.out.println ("Entrada: " + archivoEntrada);
        System.out.println ("Salida: " + archivoSalida);
        */
    }
}