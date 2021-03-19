/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT6.TA4;

/**
 *
 * @author Jotacé
 */
public class MainCascara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int INSERCION_DIRECTA = 1;
        final int SHELLSORT = 2;
        final int BURBUJA = 3;
        final int QUICK_SORT = 4;

//        Long baseTiempo = 10000000L;
//        double precision = 0.01;
//        Long tiempoResolucion = (baseTiempo/precision);

        //ALEATORIO 300
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        TClasificador clasificador = new TClasificador();
        int[] vectorOriginal = gdg.generarDatosAleatorios(300);

        Long tiempoMedioAlgoritmoBase = calculoDeTiempos(vectorOriginal, clasificador, 1, false);
        Long tiempoMedioCascara = calculoDeTiempos(vectorOriginal, clasificador, 1 , true);
        Long tiempoMedioAlgoritmo = tiempoMedioAlgoritmoBase - tiempoMedioCascara;
        System.out.println("Tiempo medio algoritmo INSERCION DIRECTA: " + tiempoMedioAlgoritmo);
        
        Long tiempoMedioAlgoritmoBase2 = calculoDeTiempos(vectorOriginal, clasificador, 2, false);
        Long tiempoMedioCascara2 = calculoDeTiempos(vectorOriginal, clasificador, 2 , true);
        Long tiempoMedioAlgoritmo2 = tiempoMedioAlgoritmoBase2 - tiempoMedioCascara2;
        System.out.println("Tiempo medio algoritmo SHELLSORT: " + tiempoMedioAlgoritmo2);
        
        Long tiempoMedioAlgoritmoBase3 = calculoDeTiempos(vectorOriginal, clasificador, 3, false);
        Long tiempoMedioCascara3 = calculoDeTiempos(vectorOriginal, clasificador, 3 , true);
        Long tiempoMedioAlgoritmo3 = tiempoMedioAlgoritmoBase3 - tiempoMedioCascara3;
        System.out.println("Tiempo medio algoritmo BURBUJA: " + tiempoMedioAlgoritmo3);
        
        Long tiempoMedioAlgoritmoBase4 = calculoDeTiempos(vectorOriginal, clasificador, 4, false);
        Long tiempoMedioCascara4 = calculoDeTiempos(vectorOriginal, clasificador, 4 , true);
        Long tiempoMedioAlgoritmo4 = tiempoMedioAlgoritmoBase4 - tiempoMedioCascara4;
        System.out.println("Tiempo medio algoritmo QUICLSORT: " + tiempoMedioAlgoritmo4);
        
    }

    private static Long calculoDeTiempos(int[] vectorOriginal, TClasificador clasificador, int numeroAlgoritmoClasificador, boolean cascara) {
        Long t1 = System.nanoTime();
        Long total = 0L;
        Long baseTiempo = 10000000L;
        Double presicion = 0.01;
        
        Long tiempoResolucion = 1000000000L;
        int cantidadLlamadas = 0;

        while (total < tiempoResolucion) {
            cantidadLlamadas += 1;
            int[] datosCopia = copiarVector(vectorOriginal);
            clasificador.clasificar(datosCopia, numeroAlgoritmoClasificador, cascara);
            Long t2 = System.nanoTime();
            total = t2 - t1;
        }

        return total / cantidadLlamadas;
    }

    public static int[] copiarVector(int[] aOrigen) {
        int[] aDestino = new int[aOrigen.length];
        for (int x = 0; x < aOrigen.length; x++) {
            aDestino[x] = aOrigen[x];
        }
        return aDestino;
    }
}
