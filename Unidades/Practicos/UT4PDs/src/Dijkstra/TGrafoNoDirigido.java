package Dijkstra;

import java.util.Collection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {

        TGrafoNoDirigido arbolAbarcador = new TGrafoNoDirigido(this.getVertices().values(), new TAristas());

        Collection<Comparable> clavesVertices = this.getVertices().keySet();

        TAristas ConjuntoSeleccion = (TAristas) this.lasAristas.clone();

        boolean existeCamino;
        TArista aristaMinima;

        while (arbolAbarcador.lasAristas.size() < this.getVertices().size() - 1) {

            aristaMinima = ConjuntoSeleccion.buscarMin(clavesVertices, clavesVertices);

            ConjuntoSeleccion.remove(aristaMinima);

            existeCamino = arbolAbarcador.todosLosCaminos(aristaMinima.etiquetaOrigen, aristaMinima.etiquetaDestino).getCaminos().size() > 0;

            if (!existeCamino) {
                arbolAbarcador.insertarArista(aristaMinima);
                arbolAbarcador.lasAristas.add(aristaMinima);
            }

        }
        return arbolAbarcador;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void numerar(Comparable etiquetaOrigen) {
        Comparable raiz = this.lasAristas.peek().etiquetaOrigen;
        TVertice vertRaiz = this.getVertices().get(raiz);
        
        LinkedList<TVertice> listaAuxiliar = new LinkedList<>();
        vertRaiz.setNumBp(0);
     
        listaAuxiliar.add(vertRaiz);
        vertRaiz.numerar(listaAuxiliar, vertRaiz);
        
        this.desvisitarVertices();
//        LinkedList<TVertice> aux =(LinkedList<TVertice>) this.bpf(vertRaiz);
//        for (TVertice c : aux){
//            System.out.println(c.getEtiqueta() + "--"+ c.getNumBajo());
//        }
     
    }
    
    
    public LinkedList<Comparable> ptosArticulacion(){
       
        Comparable raiz = this.lasAristas.peek().etiquetaOrigen;
        this.numerar(raiz);
        TVertice vertRaiz = this.getVertices().get(raiz);
        
        LinkedList<Comparable> puntosA = new LinkedList<>();
        vertRaiz.ptosArticulacion(puntosA);
        puntosA.remove(raiz);
        
        return puntosA;
    } 
    
     @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        this.desvisitarVertices();

        if (vertice != null) {
            vertice.bpf(visitados);
        }

        return visitados;
    }
}
