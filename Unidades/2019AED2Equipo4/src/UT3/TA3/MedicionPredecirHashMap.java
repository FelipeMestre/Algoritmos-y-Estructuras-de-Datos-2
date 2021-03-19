/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA3;

import java.util.HashMap;

/**
 *
 * @author administrador
 */
public class MedicionPredecirHashMap extends Medible {

    private HashMapConPredecir<String, String> hashMap;

    public MedicionPredecirHashMap(HashMapConPredecir hashmap) {
        this.hashMap = hashmap;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];

        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                hashMap.predecir(hashMap, palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
}
