/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package pd6;

import java.util.LinkedList;

/**
 *
 * @author estudiante.fit
 */
public class TNodoSufijos {
    
    private TNodoSufijos[] hijos;
    private static final int CANT_CHR_ABECEDARIO = 4;
    private boolean esPalabra;
    private int[] locacion;

    public TNodoSufijos() {
        this.hijos = new TNodoSufijos[CANT_CHR_ABECEDARIO];
        this.esPalabra = false;
    }
    
    
    public void insertar(String unaPalabra, int[] indices) {
        TNodoSufijos nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = getIndiceDeCaracter(unaPalabra.charAt(c));
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoSufijos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.locacion = indices;
    }
    
    private int getIndiceDeCaracter(Character caracter){
        if (caracter.equals('a')) {
            return 0;
        }
        if (caracter.equals('c')) {
            return 1;
        }
        if (caracter.equals('g')) {
            return 2;
        }
        if (caracter.equals('t')) {
            return 3;
        }
        return 0;
    }
    
    private char getCaracterSegunIndice(int indice){
        if (indice == 0) {
            return 'a';
        }
        if (indice == 1) {
            return 'c';
        }
        if (indice == 2) {
            return 'g';
        }
        if (indice == 3) {
            return 't';
        }
        return 'a';
    }

    private void imprimir(String s, TNodoSufijos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + getCaracterSegunIndice(c), nodo.hijos[c]);
                }
            }
        }
    }

    public void imprimir() {

        imprimir("", this);
    }

    private void buscarIntervalos(LinkedList<int[]> indices, TNodoSufijos nodo) {
        if (nodo.esPalabra) {
            indices.add(nodo.locacion);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                buscarIntervalos(indices, nodo.hijos[c]);
            }
        }
    }
    
    public LinkedList<int[]> buscar(String s) {
        TNodoSufijos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndiceDeCaracter(s.charAt(c));
            if (nodo.hijos[indice] != null) {
                nodo = nodo.hijos[indice];
            } else {
                return null;
            }
        }
        LinkedList<int[]> indices = new LinkedList<>();
        buscarIntervalos(indices, nodo);
        return indices;
    }
    
    private TNodoSufijos buscarNodoTrie(String s) {
        TNodoSufijos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = getIndiceDeCaracter(s.charAt(c));
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoSufijos nodo) {
        if (nodo.esPalabra) {
            palabras.add(prefijo + s);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                predecir(s + (getCaracterSegunIndice(c)), prefijo, palabras, nodo.hijos[c]);
            }
        }
    }

    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoSufijos nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }
    
    
}
