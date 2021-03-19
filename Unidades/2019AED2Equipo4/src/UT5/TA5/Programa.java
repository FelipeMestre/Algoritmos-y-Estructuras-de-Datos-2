package UT5.TA5;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cargar grafo con actores y relaciones

        numBaconAmplitud gnd = (numBaconAmplitud) UtilGrafos.cargarGrafo("src/UT5/TA5/actores.csv",
                "src/UT5/TA5/en_pelicula.csv",
                false, numBaconAmplitud.class);

        // invocar a numBacon como indica la letra y mostrar en consola el resultado
        System.out.println(gnd.numBacon("Lukas_Haas"));
        
        //Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());

        //UtilGrafos.imprimirMatriz(matrizCostos, gnd.getVertices());

        System.out.println(gnd.numBaconProfundidad("John_Goodman"));
        System.out.println(gnd.numBaconProfundidad("Tom_Cruise"));
        System.out.println(gnd.numBaconProfundidad("Jason_Statham"));
        System.out.println(gnd.numBaconProfundidad("Lukas_Haas"));
        System.out.println(gnd.numBaconProfundidad("Djimon_Hounsou"));
        System.out.println(gnd.numBaconProfundidad("Morgan_Freeman"));
    }

}
