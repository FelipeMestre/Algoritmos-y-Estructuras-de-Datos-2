/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD5;

import java.io.Serializable;
import java.util.LinkedList;


public class TArbolTrieHash implements Serializable{
    private TNodoTrieHash raiz;
    
    public TArbolTrieHash(){
    }
    public void insertar(TAbonado abonado){
        if (raiz==null){
            raiz= new TNodoTrieHash();
        }
        raiz.insertar(abonado);
    }
    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public TNodoTrieHash buscarNodo(String numero){
        if (raiz!= null){
            return raiz.buscarNodo(numero);
            
        }
        return null;
    }
    
    /**
     * Retorna una linkedList con todos los abonados de ese pais y area
     * @param pais String pais
     * @param area String area
     * @return Linked List
     */
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> listaAbonados = new LinkedList<>();
        if (raiz != null){
            raiz.buscarTelefonos(pais + area, listaAbonados);
        }
        return listaAbonados;
    }
    
}
