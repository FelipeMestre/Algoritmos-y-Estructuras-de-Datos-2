/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT4.PD2;

import java.util.HashMap;
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
        TVertice artigas = new TVertice("artigas");
        TVertice canelones = new TVertice("canelones");
        TVertice durazno = new TVertice("durazno");
        TVertice florida = new TVertice("florida");
        TVertice montevideo = new TVertice("montevideo");
        TVertice puntadeleste = new TVertice("puntadeleste");
        TVertice rocha = new TVertice<>("rocha");
        TVertice colonia = new TVertice<>("colonia");
        
        TArista a2 = new TArista("canelones","artigas", 500);
        TArista a3 = new TArista("canelones","colonia", 200);
        TArista a4 = new TArista("canelones","durazno", 170);
        TArista a5 = new TArista("canelones","puntadeleste", 90);
        TArista a8 = new TArista("montevideo","artigas",700);
        TArista a9 = new TArista("montevideo","canelones",30);
        TArista a10 = new TArista("montevideo","puntadeleste",130);
        TArista a11 = new TArista("puntadeleste","rocha",90);
        TArista a12 = new TArista("rocha","montevideo",270);
        TArista a1 = new TArista("artigas","rocha", 400);
        TArista a6 = new TArista("colonia","montevideo",180);
        TArista a13 = new TArista("florida","durazno",60);
        TArista a7 = new TArista("florida","durazno",60);
        
        
        LinkedList<TVertice> vertices = new LinkedList<>();
        vertices.add(artigas);
        vertices.add(durazno);
        vertices.add(canelones);
        vertices.add(florida);
        vertices.add(montevideo);
        vertices.add(puntadeleste);
        vertices.add(rocha);
        vertices.add(colonia);
        
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
        aristas.add(a13);
        
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Double[][] gnd = grafo.floyd(); 
        Comparable[][] costos = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(costos, grafo.getVertices(), "Costos");
        UtilGrafos.imprimirMatrizMejorado(gnd, grafo.getVertices(), "Floyd");
        System.out.println("Excentricidad durazno");
        System.out.println(grafo.obtenerExcentricidad("durazno"));
        System.out.println("Centro del grafo");
        System.out.println(grafo.centroDelGrafo());
        
    }
    
}
