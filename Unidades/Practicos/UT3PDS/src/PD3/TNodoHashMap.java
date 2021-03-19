package PD3;
import PD1.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TNodoHashMap implements Serializable {

    private HashMap<String, TNodoHashMap> hijos;
    private boolean esPalabra;

    public TNodoHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    
    public void insertar(String unaPalabra) {
        TNodoHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            String caracter = String.valueOf(unaPalabra.charAt(c));
            if (!nodo.hijos.containsKey(caracter)) {
                nodo.hijos.put(caracter, new TNodoHashMap());
            }
            nodo = nodo.hijos.get(caracter);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (Map.Entry<String, TNodoHashMap> entry : nodo.hijos.entrySet()) {
                imprimir(s + entry.getKey(), entry.getValue());
            }
        }

    }

    
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoHashMap buscarNodoTrie(String s) {
        TNodoHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            String caracter = String.valueOf(s.charAt(c));;
            if (!nodo.hijos.containsKey(caracter)) {
                return null;
            }
            nodo = nodo.hijos.get(caracter);
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoHashMap nodo) {
        if (nodo.esPalabra) {
            palabras.add(prefijo + s);
        }
        for (Map.Entry<String, TNodoHashMap> entry : nodo.hijos.entrySet()) {
            predecir(s + entry.getKey(), prefijo, palabras, entry.getValue());
        }
    }

    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }

    
    public int buscar(String s) {
        TNodoHashMap nodo = this;
        int contador = 0;
        for (int c = 0; c < s.length(); c++) {
            String caracter = String.valueOf(s.charAt(c));
            if (!nodo.hijos.containsKey(caracter)) {
                return -contador;
            } else {
                nodo = nodo.hijos.get(caracter);
                contador++;
            }
        }
        if (nodo.esPalabra) {
            return contador;
        } else {
            return -contador;
        }

    }

}
