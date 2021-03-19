/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT4.PD4;

import UT4.PD3.*;

/**
 *
 * @author estudiante.fit
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/UT4/PD3/aeropuertos.txt",
                                                "src/UT4/PD3/conexiones.txt", false, TGrafoDirigido.class);
        Double[][] costosMinimos = grafo.floyd();
        boolean[][] matrizConexiones = grafo.warshall();
        UtilGrafos.imprimirMatrizMejorado(costosMinimos, grafo.getVertices(), "Costos Minimos");
        UtilGrafos.imprimirWarshall(matrizConexiones, grafo.getVertices(), "Conexiones");
        
        System.out.println();
        System.out.println("Centro del grafo:");
        System.out.println(grafo.centroDelGrafo());
        System.out.println();
        
        System.out.println("Etiquetas");
        grafo.imprimirEnBpf();
        System.out.println();
        
        System.out.println("Orden desde Montevideo");
        grafo.imprimirEnBpf("Montevideo");
        System.out.println();
        
        TCaminos mdeoARio = grafo.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        mdeoARio.imprimirCaminosConsola();
    }
    
}
