
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cargar grafo aerolínea con aeropuertos y vuelos
        TGrafoAerolinea aerolinea = UtilGrafos.cargarGrafo("src/aeropuertos.txt","src/vuelos.txt", false, TGrafoAerolinea.class);
        
        String elOrigen = "A";
        String elDestino = "J";
        
        LinkedList<TVertice> lasEscalas = aerolinea.menosEscalas(elOrigen, elDestino);
        
      
        
        System.out.println();
        
        System.out.println("itinerario mejor para vuelo entre "+ elOrigen+ " y "+ elDestino +": ");
        
        String[] etiquetasParaImprimir = new String[lasEscalas.size()];
        int i = 0;
        for (TVertice v : lasEscalas) {
            etiquetasParaImprimir[i] = (String) v.getEtiqueta();
             System.out.println(v.getEtiqueta());
             i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/escalas.txt", etiquetasParaImprimir);
        
    }
}
