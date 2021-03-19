
import java.util.Collection;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TGrafoAerolinea extends TGrafoDirigido implements IGrafoAerolinea {

    public TGrafoAerolinea(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    /**
     * Para obtener el camino con menos escalas se realiza una busqueda en amplitud a traves del grafo
     * @param origen Etiqueta de origen
     * @param destino Etiqueta de destino
     * @return Retorna una lista con cada escala empezando por el origen y terminando por el destino
     */
    @Override
    public LinkedList<TVertice> menosEscalas(Comparable origen, Comparable destino) {
        this.desvisitarVertices();
        TVertice verticeOrigen = this.getVertices().get(origen);
        TVertice verticeDestino = this.getVertices().get(destino);
        LinkedList<TVertice> menorEscala = new LinkedList<>();
        if (verticeOrigen == null || verticeDestino == null) {
            return menorEscala;
        }
        verticeOrigen.menorEscala(destino);
        menorEscala.addFirst(verticeDestino);
        TVertice camino = verticeDestino.getPredecesor();
        while (camino != null){
            menorEscala.addFirst(camino);
            camino = camino.getPredecesor();
        }
        return menorEscala;
    }

    
}