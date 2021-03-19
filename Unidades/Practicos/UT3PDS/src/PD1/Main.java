package PD1;

import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        TTrieHashMap trie2 = new TTrieHashMap();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/PD1/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src/PD1/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
            // insertar la palabra p en el trie
            trie.insertar(p);
            trie2.insertar(p);
        }
        Medible[] medibles = new Medible[2];
        medibles[0] = new MedicionBuscarTrie(trie);
        medibles[1] = new MedicionBuscarHashTrie(trie2);

        Medicion mi;

        Object[] params = {REPETICIONES, palabrasBuscar};
        for (Medible m : medibles) {
            mi = m.medir(params);
            mi.print();
        }
    }
}
