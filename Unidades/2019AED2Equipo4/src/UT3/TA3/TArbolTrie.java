package UT3.TA3;
import java.io.Serializable;
import java.util.LinkedList;


public class TArbolTrie implements Serializable{

    private TNodoTrie raiz;


    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }


    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }


    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.buscar(palabra);
        }
    }


    public LinkedList<String> predecir(String prefijo) {
        LinkedList palabras = new LinkedList();
        if (raiz == null){
            return null;
        }
        raiz.predecir(prefijo, palabras);
        return palabras;
    }
    
    
}
