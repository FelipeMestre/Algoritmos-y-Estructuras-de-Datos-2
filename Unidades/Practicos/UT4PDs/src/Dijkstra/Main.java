/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra;

import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");
        
        TArista a1 = new TArista("a","b",1);
        TArista a2 = new TArista("a","c",2);
        TArista a3 = new TArista("a","d",7);
        TArista a4 = new TArista("b","a",7);
        TArista a5 = new TArista("b","c",1);
        TArista a6 = new TArista("b","d",2);
        TArista a7 = new TArista("c","d",3);
        TArista a8 = new TArista("e","b",2);
        TArista a9 = new TArista("e","d",8);
        TArista a10 = new TArista("d","a",6);
        TArista a11 = new TArista("d","c",4);
        TArista a12 = new TArista("d","e",4);
        
        LinkedList<TVertice> cincoVertices = new LinkedList<>();
        cincoVertices.add(a);
        cincoVertices.add(b);
        cincoVertices.add(c);
        cincoVertices.add(d);
        cincoVertices.add(e);
        
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);
        
        TGrafoDirigido grafoDeDijkstra = new TGrafoDirigido(cincoVertices, aristas);
        Double[] matrizDijkstra = grafoDeDijkstra.dijkstra("e");
        java.util.Arrays.toString(matrizDijkstra);
        for (Double numero : matrizDijkstra) {
            System.out.println(numero);
        }        
    }    
}
