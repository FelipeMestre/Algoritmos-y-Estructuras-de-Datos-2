/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class TNodoTrieHash implements Serializable{
    private HashMap<Comparable,TNodoTrieHash> hijos;
    private boolean esPalabra;
    private TAbonado abonado;
    
    public TNodoTrieHash() {
        hijos = new HashMap<>();
        esPalabra = false;
    }
    public void insertar(TAbonado unAbonado){
        TNodoTrieHash nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            String caracter = String.valueOf(unAbonado.getTelefono().charAt(c));
            if (!nodo.hijos.containsKey(caracter)) {
                nodo.hijos.put(caracter, new TNodoTrieHash());
            }
            nodo = nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
        nodo.abonado=unAbonado;
    }
    
    private void imprimir(String s, TNodoTrieHash nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(nodo.abonado.getNombre());
                
            }
            Set<Comparable> claves = nodo.hijos.keySet();
            for (Comparable clave:claves) {
                imprimir(s+clave, nodo.hijos.get(clave));
                
            }
        }
    }

    
    public void imprimir() {
        
        imprimir("", this);
    }
    
    public TNodoTrieHash buscarNodo(String palabra){
        TNodoTrieHash nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            String caracter = String.valueOf(palabra.charAt(c));
            if (!nodo.hijos.containsKey(caracter)){
                return null;
            }
            nodo = nodo.hijos.get(caracter);
        }
        return nodo;
    }
    
    private void buscarTelefonos(String s, String primerosDigitos, LinkedList<TAbonado> abonados, TNodoTrieHash nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                abonados.add(nodo.abonado);
            }
            Set<Comparable> claves  = nodo.hijos.keySet();
            for (Comparable clave:claves) {
                if (nodo.hijos.get(clave) != null) {
                    buscarTelefonos(s + clave , primerosDigitos, abonados, nodo.hijos.get(clave));
                }
            }
        }
    }

    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieHash nodo = buscarNodo(primerosDigitos);

        buscarTelefonos("", primerosDigitos, abonados, nodo);
    }

    public TAbonado getAbonado() {
        return abonado;
    }
    
}
