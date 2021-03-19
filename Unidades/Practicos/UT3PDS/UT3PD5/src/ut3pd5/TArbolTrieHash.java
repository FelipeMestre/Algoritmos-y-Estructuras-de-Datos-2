/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3pd5;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class TArbolTrieHash implements Serializable{
    private TNodoTrieHash raiz;
    
    public TArbolTrieHash(){
    }
    public void insertar(TAbonado etiqueta){
        if (raiz==null){
            raiz= new TNodoTrieHash();
        }
        raiz.insertar(etiqueta);
    }
    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public TNodoTrieHash buscarNodo(String palabra){
        if (raiz!= null){
            return raiz.buscarNodo(palabra);
            
        }
        return null;
    }
//    public LinkedList<String> predecir(String prefijo) {
//        if(raiz != null){
//            LinkedList lista = new LinkedList();
//            raiz.predecir(prefijo,lista);
//            return lista;
//        }else{
//            return null;
//        }
//    }
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> listaAbonados = new LinkedList<>();
        if (raiz != null){
            raiz.buscarTelefonos(pais+area, listaAbonados);
        }
        return listaAbonados;
    }
    
}
