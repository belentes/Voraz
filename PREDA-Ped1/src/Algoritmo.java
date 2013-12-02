
public class Algoritmo
{
    int n;   // kilómetros máximos que se pueden recorrer sin repostar
    int G;   // número de gasolineras existentes
    int[] DG;  // distancia entre gasolineras, siendo DG[i] la distancia entre i-1 e i
    boolean trazaActivada;  // true si queremos que se imprima la traza del algoritmo

    public Algoritmo(int[] DG, int n, int G, boolean trazaActivada)
    {
        this.DG = DG;
        this.n = n;
        this.G = G;   
        this.trazaActivada = trazaActivada;
    }

    public boolean[] ejecutarAlgoritmo()
    {
        boolean[] solucion = new boolean[G-1];
        
        for (int j=0 ; j<solucion.length; j++) {
            solucion[j] = false;
        }
        
        int i      = 0;
        int contKm = 0;
        
        while ( i < G-1) {
            
            while ( (contKm <= n) && (i < G-1)) {
                contKm = contKm + DG[i];
                i += 1;
                if (trazaActivada) {
                    System.out.println("Bucle dentro: i = " + i + " - contKm = " + contKm);
                }
            }
            if (contKm > n) {
                i -= 1;
                solucion[i] = true;
                contKm = 0;
            }
            
            if (trazaActivada) {
                System.out.println("Tras bucle: i = " + i + " - contKm = " + contKm);
            }
        }
        
        if (trazaActivada) {
            for (int j=0; j<solucion.length; j++) {
                System.out.println("Paramos en " + (j) + ": " + solucion[j]);
            }
        }
        
        return solucion;
    }
}
