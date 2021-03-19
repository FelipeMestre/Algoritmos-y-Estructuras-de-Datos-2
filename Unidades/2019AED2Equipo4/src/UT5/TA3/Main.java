package UT5.TA3;


import java.util.Collection;
import java.util.LinkedList;



/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

/**
 *
 * @author estudiante.fit
 */
public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo(
                "src/UT5/TA3/verticesBEA.txt","src/UT5/TA3/aristasBEA.txt",false,TGrafoNoDirigido.class);
        Double[][] matriz;
        matriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gnd.getVertices(), "matriz");
        Collection<TVertice> rec = gnd.bea("a");
        for(TVertice vertice : rec){
            System.out.println(vertice.getEtiqueta());
        }
    }
}
