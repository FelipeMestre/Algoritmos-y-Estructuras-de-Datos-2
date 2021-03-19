package UT5.TA5;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class numBaconAmplitud extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public numBaconAmplitud(Collection<TVertice> vertices, Collection<TArista> aristas) {
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
    public numBaconAmplitud Prim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public numBaconAmplitud Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numBacon(Comparable actor) {
        int numeroBacon = -1;
        this.desvisitarVertices();
        TVertice vertice = getVertices().get("Kevin_Bacon");
        boolean existeBacon = this.existeVertice("Kevin_Bacon");
        if (existeBacon){            
            numeroBacon = vertice.numBacon(actor);
        }
        return numeroBacon;
    }
    
    public int numBaconProfundidad(Comparable actor){
        this.desvisitarVertices();
        TVertice kevin = this.getVertices().get("Kevin_Bacon");
        TVertice verticeActor = this.getVertices().get(actor);
        if (kevin == null || verticeActor == null) {
            return Integer.MAX_VALUE;
        }
        kevin.numBaconEnProfundidad(actor);
        return verticeActor.getBacon();
    }
}
