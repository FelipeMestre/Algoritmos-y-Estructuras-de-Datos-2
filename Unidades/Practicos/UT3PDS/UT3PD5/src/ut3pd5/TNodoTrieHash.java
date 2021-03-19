/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author estudiante.fit
 */
public class TNodoTrieHash implements Serializable{
    private HashMap<Comparable,TNodoTrieHash> hijos;
    private boolean esPalabra;
    private TAbonado abonado;
    
    public TNodoTrieHash() {
        hijos = new HashMap<>();
        esPalabra = false;
    }
    public void insertar(TAbonado unaPalabra){
        TNodoTrieHash nodo = this;
        for (int c = 0; c < unaPalabra.getTelefono().length(); c++) {
            
            if (!nodo.hijos.containsKey(String.valueOf(unaPalabra.getTelefono().charAt(c)))) {
                
                nodo.hijos.put(String.valueOf(unaPalabra.getTelefono().charAt(c)), new TNodoTrieHash());
            }
            nodo = nodo.hijos.get(String.valueOf(unaPalabra.getTelefono().charAt(c)));
        }
        nodo.esPalabra = true;
        nodo.abonado=unaPalabra;
    }
    
    private void imprimir(String s, TNodoTrieHash nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(nodo.abonado.getNombre());
                
            }
            Set<Comparable> claves = nodo.hijos.keySet();
            for (Comparable clave:claves) {
                imprimir(s+clave, nodo.hijos.get(clave));
                
            }
        }
    }

    
    public void imprimir() {
        
        imprimir("", this);
    }
    
    public TNodoTrieHash buscarNodo (String palabra){
        TNodoTrieHash nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            if (!nodo.hijos.containsKey(palabra.charAt(c))){
                return null;
            }
            System.out.println("123");  
            nodo = nodo.hijos.get(String.valueOf(palabra.charAt(c)));
        }
        return nodo;
    }
    
//    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHash nodo) {
//         if (nodo != null) {
//            if (nodo.esPalabra) {
//                palabras.add(prefijo+s);
//            }
//            Set<Comparable> claves = nodo.hijos.keySet();
//            for (Comparable clave:claves) {
//                    predecir(s+clave,prefijo, palabras,nodo.hijos.get(clave));
//                }
//            }
//        }
//    
//
//    
//    public void predecir(String prefijo, LinkedList<String> palabras) {
//        TNodoTrieHash nodo = buscarNodo(prefijo);
//        predecir("",prefijo,palabras,nodo);
//
//    }
    
    private void buscarTelefonos(String s, String primerosDigitos, LinkedList<TAbonado> abonados, TNodoTrieHash nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.abonado);
            }
            Set<Comparable> claves  = nodo.hijos.keySet();
            for (Comparable clave:claves) {
                if (nodo.hijos.get(clave) != null) {
                    buscarTelefonos(s+clave , primerosDigitos, abonados, nodo.hijos.get(clave));
                }
            }
        }
    }

    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieHash nodo = buscarNodo(primerosDigitos);

        buscarTelefonos("", primerosDigitos, abonados, nodo);
    }
    
}
