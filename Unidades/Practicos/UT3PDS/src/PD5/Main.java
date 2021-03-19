package PD5;


import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String archivoAbonados = "src/PD5/abonados.txt";
        TArbolTrieHash trie = new TArbolTrieHash();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] arrayAbonados = ManejadorArchivosGenerico.leerArchivo(archivoAbonados);
        for (String linea : arrayAbonados) {
            String[] abonadoS = linea.split(",");
            TAbonado abonado = new TAbonado(abonadoS[1], abonadoS[0]);
            trie.insertar(abonado);
        }
        
        
        System.out.println((trie.buscarNodo("05490123685")).getAbonado().getNombre());
        String codigoPais = "054"; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90";// utilizar el indicado en el archivo "codigos.txt"
        
        LinkedList<TAbonado> abonados = trie.buscarTelefonos(codigoPais, codigoArea);
        TAbonado[] arrayDeAbonados = new TAbonado[abonados.size()];
        abonados.toArray(arrayDeAbonados);
        
        String[] paraEscribir = new String[abonados.size()];
        for (int i = 0; i < arrayDeAbonados.length; i++) {
            System.out.println(arrayDeAbonados[i].getNombre());
            paraEscribir[i] = arrayDeAbonados[i].getNombre() + "," + arrayDeAbonados[i].getTelefono();
        }
        Arrays.sort(paraEscribir);
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", paraEscribir);
    }
}
