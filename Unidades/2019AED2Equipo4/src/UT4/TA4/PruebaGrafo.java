package UT4.TA4;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/UT4/TA4/aeropuertos_1.txt", "./src/UT4/TA4/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

//        //Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
//        //UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
//        //Double[][] mfloyd = gd.floyd();
//        //UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
//        //for (int i = 0; i < etiquetasarray.length; i++) {
//        //    System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
//        //}
//        System.out.println();
//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        System.out.println("Recorrido entero");
        Collection<TVertice> recorrido = gd.bpf();
        for (TVertice vertice : recorrido) {
            System.out.println(vertice.getEtiqueta());
        }
        System.out.println("Recorrido Asuncao");
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        for (TVertice vertice2 : recorrido_Asuncion) {
            System.out.println(vertice2.getEtiqueta());
        }
       
    }
}
