package UT3.TA6;

import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/UT3/TA6/palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir(); 
        LinkedList<String> p = trie.imprimirArray();
        System.out.println("---------------------------------");
        for(String s : p){
            System.out.println(s);
        }
        System.out.println("---------------------------------");
        int i = 0;
        String[] palabras = new String[p.size()];
        for(String s : p){
            palabras[i] = s;
            i++;
        }
        
        for(int t : trie.posicionPalabra("per",palabras)){
            System.out.println(t);
        }
        
        //Se pueden encontrar más pruebas del arbol de sufijos en los tests
        TArbolSufijos trieDeSufijos = new TArbolSufijos("panamabananas");
        trieDeSufijos.crearTrie();
        LinkedList<int[]> posicionesDeBanana = trieDeSufijos.buscar("banana");
        System.out.println("Las posiciones de banana son");
        for (int[] posicion : posicionesDeBanana) {
            System.out.println(posicion[0]);
        }
    }
}