package UT5.TA3;

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
    public TGrafoNoDirigido prim() {
        int costoTotal = 0;
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        LinkedList<TVertice> U = new LinkedList<>();
        if (this.getVertices().isEmpty()) {
            return new TGrafoNoDirigido(U, aristasAAM);
        }
        LinkedList<TVertice> vertices = this.copiarTodosLosVertices();
        U.add(vertices.pop());
        while (!vertices.isEmpty()) {
            TArista ari = lasAristas.buscarMin(U, vertices);
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
    public TGrafoNoDirigido kruskal() {
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

    public Collection<TVertice> bea() {
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

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        this.desvisitarVertices();
        TVertice vertice = getVertices().get(etiquetaOrigen);
        if (vertice != null) {
            vertice.bea(vertices);
        }
        return vertices;
    }

    private TGrafoDirigido grafoOpuesto() {
        LinkedList<TArista> aristas = new LinkedList<>();
        for (TVertice v : super.getVertices().values()) {
            for (TAdyacencia adyacente : (LinkedList<TAdyacencia>) v.getAdyacentes()) {
                aristas.add(new TArista(adyacente.getEtiqueta(), v.getEtiqueta(), adyacente.getCosto()));
            }
        }
        return new TGrafoDirigido(super.getVertices().values(), aristas);
    }

    private LinkedList<TVertice> bpfPostorden() {
        desvisitarVertices();
        LinkedList<TVertice> resultado = new LinkedList<>();
        for (TVertice vertice : super.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bpfPostorden(resultado);
            }
        }
        desvisitarVertices();
        return resultado;
    }

    public Collection<Collection<TVertice>> componentesConexos() {
        Collection<Collection<TVertice>> componentes = new LinkedList<>();

        LinkedList<TVertice> bpfTotal = bpfPostorden();

        TGrafoDirigido grafoInverso = grafoOpuesto();
        Collection<TVertice> arbol = new LinkedList<>();
        for (TVertice vertice : bpfTotal) {
            TVertice vEnOpuesto = grafoInverso.getVertices().get(vertice.getEtiqueta());
            if (!vEnOpuesto.getVisitado()) {
                vEnOpuesto.setVisitado(true);
                vEnOpuesto.bpf(arbol);
                componentes.add(arbol);
                arbol = new LinkedList<>();
            }
        }
        return componentes;
    }
}
