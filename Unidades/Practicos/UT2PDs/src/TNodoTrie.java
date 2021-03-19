/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */


import java.util.LinkedList;

public class TNodoTrie implements INodoTrie{
    
    private static final int CANT_CHR_ABECEDARIO = 10;
    private TNodoTrie[] hijos;
    private boolean esFinalDePalabra;
    private TAbonado Dato;

    public void setDato(TAbonado unDato) {
        this.Dato = unDato;
    }

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esFinalDePalabra = false;
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    @Override
    public void buscarTelefonos(String  digitosIniciales, LinkedList<TAbonado> listaDeAbonados) {
        TNodoTrie nodo = buscarNodoTrie( digitosIniciales);
        if(nodo != null){
            
            buscarTelefonos("", digitosIniciales, listaDeAbonados, nodo);
        
        }
    }
    
    public void buscarTelefonos(String s,String primerosDigitos, LinkedList<TAbonado> listaDeAbonados,TNodoTrie nodo){
        if (nodo != null) {
            
            if (nodo.esFinalDePalabra) {
                listaDeAbonados.add(nodo.Dato); 
            }
            
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    buscarTelefonos(s+(char)(c + '0'),primerosDigitos,listaDeAbonados, nodo.hijos[c]);
                }
            }
        }
    }

    
    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrie nodo = this;
        String telefono = unAbonado.getTelefono();
        for (int c = 0; c < telefono.length(); c++) {
            int indice = telefono.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.setDato(unAbonado);
        nodo.esFinalDePalabra = true;
    }
    
    
}
