/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package pd6;

import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class PD6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] cadena = ManejadorArchivosGenerico.leerArchivo("src\\pd6\\secuencia.txt");
        TArbolSufijos arbolSufijos = new TArbolSufijos(cadena[0]);
        arbolSufijos.crearTrie();

        System.out.println("Cadenas de ccta");
        LinkedList<String> cadenas = arbolSufijos.predecir("ccta");
        for (String prediccion : cadenas) {
            System.out.println(prediccion);
        }

        System.out.println("Indices de ccta");
        LinkedList<int[]> indices = arbolSufijos.buscar("ccta");
        for (int[] indice : indices) {
            System.out.println(indice[0] + "," + indice[1]);
        }

        System.out.println("");

        System.out.println("Cadenas de ggtca");
        cadenas = arbolSufijos.predecir("ggtca");
        for (String prediccion : cadenas) {
            System.out.println(prediccion);
        }

        System.out.println("Indices de ggtca");
        indices = arbolSufijos.buscar("ggtca");
        for (int[] indice : indices) {
            System.out.println(indice[0] + "," + indice[1]);
        }

        System.out.println("");

        System.out.println("Indices de aacct");
        indices = arbolSufijos.buscar("aacct");
        if (indices != null) {
            for (int[] indice : indices) {
                System.out.println(indice[0] + "," + indice[1]);
            }
        }

        System.out.println("Cadenas de aacct");
        cadenas = arbolSufijos.predecir("aacct");
        for (String prediccion : cadenas) {
            System.out.println(prediccion);
        }

        System.out.println("");

    }

}
