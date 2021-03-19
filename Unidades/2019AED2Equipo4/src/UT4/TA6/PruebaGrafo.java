package UT4.TA6;
import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/UT4/TA6/aeropuertos_1.txt", "src/UT4/TA6/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();
   
        if (gd.tieneCiclo()) {
            System.out.println("tiene ciclos");
        } else {
            System.out.println("no tiene ciclos");
        }
        
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "Floyd");
        
        System.out.println("Excen");
        System.out.println(gd.obtenerExcentricidad("Asuncion"));
        System.out.println(gd.centroDelGrafo());
        //// calcular todos los caminos, buscar el camino crítico, etc etc
        
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gd.getVertices()), gd.getVertices(), "costos");
        TCaminos caminos = gd.todosLosCaminos("Asuncion", "Montevideo");
        TCamino elMenorCamino = new TCamino(null);
        elMenorCamino.setCostoTotal(Double.MAX_VALUE);
        for (TCamino camino : caminos.getCaminos()){
            if (camino.getCostoTotal() < elMenorCamino.getCostoTotal()){
                elMenorCamino = camino;
            }
        }
        System.out.println("el menor camino es "+ elMenorCamino.imprimirEtiquetas() + "costo " + elMenorCamino.getCostoTotal());
    }
}
