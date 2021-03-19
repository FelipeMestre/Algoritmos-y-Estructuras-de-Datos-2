/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA5;

import java.util.*;

/**
 *
 * @author Agroa
 */
public class Main {

    public static void main(String[] args) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/UT3/TA5/libro.txt");
        Map<String, Integer> ocurrencias = new HashMap<>();

        for (String linea : lineas) {

            String[] palabras = linea.split(" ");
            for (String palabraConCaracteres : palabras) {
                String palabra = palabraConCaracteres.replaceAll("[^a-zA-Z]", "");
                if (!ocurrencias.containsKey(palabra)) {
                    ocurrencias.put(palabra, 1);
                } else {
                    Integer frecuencia = ocurrencias.get(palabra);
                    ocurrencias.put(palabra, frecuencia + 1);
                }
            }
        }
        // 1. Convertir el map a lista
        List<Map.Entry<String, Integer>> list = new LinkedList<>(ocurrencias.entrySet());

        // 2. Ordenar la lista, para ello creamos un comparador
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                    Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. La lista la ponemos en un LinkedHashMap, ya que se guarda por orden de inserción
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        //Imprimimos las claves con los valores en orden descendiente
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "," + value);
        }
    }
}
