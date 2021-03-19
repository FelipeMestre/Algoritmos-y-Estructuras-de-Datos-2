/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.TA3;

import java.util.LinkedList;

/**
 *
 * @author administrador
 */
public class MedicionPredecirLinkedList extends Medible{
    
    private LinkedListConPredecir linkedlist;
    
    public MedicionPredecirLinkedList(LinkedListConPredecir<String> linkedList){
        this.linkedlist = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];              
        for(int i = 0; i < repeticion; i++){
            for (String palabra : palabras) {
                linkedlist.predecir(linkedlist,palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.linkedlist;
    
    }
}
