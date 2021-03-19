import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        
        TArbolTrie trieDeAbonados = new TArbolTrie();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/abonados.txt");
        for (String abonado : lineas) {
            
            String[] splitDeLinea = abonado.split(",");
            
            TAbonado abonadoAInsertar = new TAbonado(splitDeLinea[1], splitDeLinea[0]);
            
            trieDeAbonados.insertar(abonadoAInsertar);
        }
        
        
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        Collection<TAbonado> ab = trieDeAbonados.buscarTelefonos(codigoPais, codigoArea);
        
       
        TAbonado[] arrayDeAbonados = ab.toArray(new TAbonado[ab.size()]);
        String[] arrayDeDatosDeAbonados = new String[arrayDeAbonados.length];
        for (int i = 0; i < arrayDeAbonados.length; i++){
            
            arrayDeDatosDeAbonados[i] = arrayDeAbonados[i].getNombre() + " , " + arrayDeAbonados[i].getTelefono();
        
        }
        
        
        Arrays.sort(arrayDeDatosDeAbonados);
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        ManejadorArchivosGenerico.escribirArchivo( "./src/salida.txt", arrayDeDatosDeAbonados);
       
        
                
    }
}