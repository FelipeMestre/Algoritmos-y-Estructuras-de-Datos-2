package UT3.TA6;

import UT2.TA3.*;
import java.util.LinkedList;


public class TTrieHashMap implements IArbolTrie {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public LinkedList<String> imprimirArray() {
        if (raiz != null) {
           LinkedList<String> palabras = new LinkedList<>();
           raiz.imprimirArray(palabras);
           return palabras;
        }
        else
            return null;
    }

    @Override
    public int buscar(String palabra) {
         return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<String>();
        if (raiz == null) {
            return palabras;
        }
        raiz.predecir(prefijo, palabras);
        return palabras;
    }
    
    public int[] posicionPalabra(String patron, String[] suf){
        if(raiz != null){
            return raiz.posicionPalabra(patron,suf);
        }
        else 
            return null;
    }
    
    
}
