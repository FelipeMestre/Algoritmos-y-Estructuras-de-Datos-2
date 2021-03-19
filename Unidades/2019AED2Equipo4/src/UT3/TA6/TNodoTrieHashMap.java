package UT3.TA6;


import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie {

    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            TNodoTrieHashMap hijo = nodo.hijos.get(unaPalabra.charAt(c));
            if (hijo == null) {
                hijo = new TNodoTrieHashMap();
                nodo.hijos.put(unaPalabra.charAt(c), hijo);
            }
            nodo = hijo;
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (Character character : nodo.hijos.keySet()) {
                imprimir(s + character, nodo.hijos.get(character));
            }
        }
    }

    
    private LinkedList<String> imprimirArray(String s, TNodoTrieHashMap nodo,LinkedList<String> palabras) {
        
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (Character character : nodo.hijos.keySet()) {
                imprimirArray(s + character, nodo.hijos.get(character),palabras);
            }
        }
        
        return palabras;
    }
    
    
    @Override
    public void imprimir() {

        imprimir("", this);
    }
    
    public void imprimirArray(LinkedList<String> palabras) {

        palabras = imprimirArray("", this,palabras);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            TNodoTrieHashMap hijo = nodo.hijos.get(s.charAt(c));
            if (hijo == null) {
                return null;
            }
            nodo = hijo;
        }
        return nodo;
    }

    private void predecir(String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        // implementar
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo);
            }
            for (Character character : nodo.hijos.keySet()) {
                predecir(prefijo + character, palabras, nodo.hijos.get(character));
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            nodo.predecir(prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;
        int contador = 0;
        for (int c = 0; c < s.length(); c++) {
            TNodoTrieHashMap hijo = nodo.hijos.get(s.charAt(c));
            if (hijo == null) {
                return -1;
            }
            contador++;
            nodo = hijo;
        }
        if (nodo.esPalabra) {
            return contador;
        }
        return -1;
    }
    
     public int[] posicionPalabra(String patron, String[] sufijos){
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < patron.length(); c++) {
            TNodoTrieHashMap hijo = nodo.hijos.get(patron.charAt(c));
            if (hijo == null) {
                return null;
            }
            nodo = hijo;
        }
        LinkedList<String> palabras = new LinkedList<>();
        predecir(patron, palabras);
        int[] posiciones = new int[palabras.size()];
        int contador = 0;
        for(String s : palabras ){
            for(int i = 0; i < sufijos.length;i++){
                if(s.equals(sufijos[i])){
                    posiciones[contador] = i;
                    contador++;
                }
            }
        }
        return posiciones;
    }
    
    
}
