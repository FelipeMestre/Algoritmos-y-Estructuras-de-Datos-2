/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PD1;

import java.util.LinkedList;

/**
 *
 * @author administrador
 */
public class LinkedListConPredecir<T> extends LinkedList {
    
    
    
    public static LinkedList<String> predecir(LinkedList<String> palabras,
            String prefijo) {
        LinkedList<String> result = new LinkedList();
        for (String palabra : palabras) {
            if (palabra.startsWith(prefijo)) {
                result.add(palabra);
            }
        }
        return result;
    }
}
