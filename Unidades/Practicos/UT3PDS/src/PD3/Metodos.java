/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author estudiante.fit
 */
public class Metodos {

    /**
     * Remueve todos los valores en null de un hashMap
     * @param unMap HashMap a pasar por parametro
     */
    public static void eliminarNulls(Map<String, String> unMap) {
        unMap.values().removeAll(Collections.singleton(null));
    }

    public static HashMap<String, String> intercambiarClaves(Map<String, String> unMap) throws Exception {
        HashMap<String, String> mapDadoVuelta = new HashMap<>();
        for (Map.Entry<String, String> entry : unMap.entrySet()) {
            String valor = entry.getValue();
            String clave = entry.getKey();
            if (mapDadoVuelta.containsKey(valor)) {
                throw new Exception();
            } else {
                mapDadoVuelta.put(valor, clave);
            }

        }
        return mapDadoVuelta;
    }

    public static void imprimirClavesOrdenadas(String entrada) {
        String[] palabras = ManejadorArchivosGenerico.leerArchivo(entrada);
        HashMap<Integer,TTrieHashMap> hash = new HashMap<>(); 
        for (String palabra : palabras) {
            if (hash.containsKey(palabra.length())) {
                hash.get(palabra.length()).insertar(palabra);
            } else {
                TTrieHashMap trie = new TTrieHashMap();
                trie.insertar(palabra);
                hash.put(palabra.length(), trie);
            }
        }
        Set<Integer> set = hash.keySet();
        Object[] array = set.toArray();
        Arrays.sort(array);
        for (Object numero : array) {
            int largo = (int) numero;
            hash.get(largo).imprimir();
        }
        
        
    }

    public static void imprimirDeFormaAleatoria(int numeroDeLineas) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese ruta de archivo");

        String ruta = myObj.nextLine();  // Read user input
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(ruta);
        
        File archivo = new File(ruta);
        
        HashMap<String,String> coleccion = new HashMap<>((int) archivo.length());
        for (String linea: lineas) {
            coleccion.put(linea,linea);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, String> entry : coleccion.entrySet()) {
            arrayList.add(entry.getValue());
        }
        Collections.shuffle(arrayList);
        
        int i = 0;
        for (String lineaAImprimir : arrayList) {
            if (i > numeroDeLineas) {
                break;
            } else {
                System.out.println(lineaAImprimir);
            }
            i++;
        }
    }
}
