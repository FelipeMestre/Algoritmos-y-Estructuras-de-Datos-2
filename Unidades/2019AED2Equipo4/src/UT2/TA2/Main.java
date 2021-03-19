/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2.TA2;

/**
 *
 * @author Agroa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ejemplo de uso del trie
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("arbol");
        trie.insertar("grito");
        trie.imprimir();
        
        System.out.println(trie.buscar("casamiento"));
        
    }
    
}
