/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PD1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author administrador
 */
public class HashMapConPredecir<T,E> extends HashMap {

    public static LinkedList predecir(HashMap<String, String> palabras, String palabra) {
        LinkedList result = new LinkedList();
        for (Map.Entry<String, String> entry : palabras.entrySet()) {
            if (entry.getValue().startsWith(palabra)) {
                result.add(entry);
            }
        }
        return result;

    }

}
