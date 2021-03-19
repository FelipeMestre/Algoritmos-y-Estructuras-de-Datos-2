package ut3pd5;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String archivoAbonados = "src/ut3pd5/abonados.txt";
        TArbolTrieHash trie = new TArbolTrieHash();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] arrayAbonados = ManejadorArchivosGenerico.leerArchivo(archivoAbonados);
        for (String linea : arrayAbonados) {
            String[] abonadoS = linea.split(",");
            TAbonado abonado = new TAbonado(abonadoS[1], abonadoS[0]);
            trie.insertar(abonado);
        }
        
        
        System.out.println((trie.buscarNodo("05490123685")));
        String codigoPais = "054"; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90";// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        
        TAbonado[] arrayAbonado = new TAbonado[ab.size()];
        ab.toArray(arrayAbonado);
        String[] arrayString = new String[ab.size()];
        for (int i = 0; i < arrayAbonado.length; i++) {
            System.out.println(arrayAbonado[i].getNombre());
            arrayString[i] = arrayAbonado[i].getNombre() + "," + arrayAbonado[i].getTelefono();

        }
        Arrays.sort(arrayString);

        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", arrayString);
    }
}
