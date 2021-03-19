package UT5.TA6;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

       @Override
    public TGrafoNoDirigido Prim() {
        int costoTotal = 0;
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        LinkedList<TVertice> U = new LinkedList<>();
        if (this.getVertices().isEmpty()) {
            return new TGrafoNoDirigido(U, aristasAAM);
        }
        LinkedList<TVertice> vertices = this.copiarTodosLosVertices();
        U.add(vertices.pop());
        while (!vertices.isEmpty()) {
            TArista ari = lasAristas.buscarMin(U,  vertices);
            TVertice v = this.getVertices().get(ari.getEtiquetaDestino());
            vertices.remove(v);
            U.add(v);
            aristasAAM.add(ari);
            costoTotal += ari.getCosto();
        }
        System.out.println("el costo es: " + costoTotal);
        return new TGrafoNoDirigido(U, aristasAAM);  
    }
    
    private LinkedList<TVertice> copiarTodosLosVertices() {
        LinkedList<TVertice> verticescopiados = new LinkedList<>();
        verticescopiados.addAll(this.getVertices().values());
        return verticescopiados;
    }
    
    @Override
    public TGrafoNoDirigido Kruskal() {
        TAristas aristasAAM = new TAristas();
        TAristas aristasSinElegir = new TAristas();
        HashSet<TVertice> verticesElegidos = new HashSet<>();
        HashSet<TVertice> verticesSinElegir = new HashSet<>();

        for (TVertice aux : super.getVertices().values()) {
            verticesSinElegir.add(aux);
        }
        for (TArista aux : lasAristas) {
            aristasSinElegir.add(aux);
        }

        while (!verticesSinElegir.isEmpty()) {
            TArista tempArista = aristasSinElegir.buscarMin();
            if (tempArista != null) {
                TVertice tempOrigen = getVertices().get(tempArista.getEtiquetaOrigen());
                TVertice tempDestino = getVertices().get(tempArista.getEtiquetaDestino());

                if (!(verticesElegidos.contains(tempOrigen) && verticesElegidos.contains(tempDestino))) {
                    verticesElegidos.add(tempOrigen);
                    verticesElegidos.add(tempDestino);
                    verticesSinElegir.remove(tempOrigen);
                    verticesSinElegir.remove(tempDestino);
                    aristasAAM.add(tempArista);
                }
                aristasSinElegir.remove(tempArista);
            }
        }
        return new TGrafoNoDirigido(verticesElegidos, aristasAAM);
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> listaBea = new LinkedList<TVertice>();

        if (getVertices().isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : getVertices().values()) {
                if (!vertV.getVisitado()) {
                    vertV.bea(listaBea);
                }
            }
        }
        return listaBea;
    }

    public LinkedList<TVertice> puntoArticulacion() {
        LinkedList<TVertice> puntosArticulacion = new LinkedList<>();
        LinkedList<TVertice> visitados = new LinkedList<>();
        if (!this.getVertices().isEmpty()) {
            LinkedList<TVertice> vertices = new LinkedList<>();
            vertices.addAll(getVertices().values());
            vertices.getFirst().puntoArticulacion(visitados, puntosArticulacion, 0);
        }
        this.desvisitarVertices();
        return puntosArticulacion;
    }
    
    
    public double getCostoTotal(){
        double cont = 0;
        for(TArista ari : lasAristas){
            cont += ari.getCosto();
        }
        return cont/2;
    }
    
    public boolean tieneCiclo() {
        desvisitarVertices();
        if (getVertices().isEmpty()) {
            return false;
        } else {
            for (TVertice v : getVertices().values()) {
                if (!v.getVisitado()) {
                    TCamino camino = new TCamino(v);
                        if (v.tieneCicloNoDirigido(camino)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public boolean conectados(Comparable origen, Comparable destino){
        TCaminos caminos = this.todosLosCaminos(origen, destino);
        for(TCamino camino : caminos.getCaminos()){
            LinkedList<Comparable> vertices = new LinkedList<>();
            vertices.add(camino.getOrigen().getEtiqueta());
            vertices.addAll(camino.getOtrosVertices());
            if(vertices.contains(origen)&&vertices.contains(destino)){
                return true;
            }
        }return false;
    }

}
