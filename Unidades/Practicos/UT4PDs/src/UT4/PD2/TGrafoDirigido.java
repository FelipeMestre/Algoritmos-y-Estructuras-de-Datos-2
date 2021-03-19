package UT4.PD2;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private Double[][] matrizPredecesoresGrafo;
    private Boolean[][] matrizWarshall;
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el vertice, retorna falso. En caso de que la etiqueta sea
     * invalida, retorna false.
     *
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        double menorExcentricidad = Integer.MAX_VALUE;
        Comparable centro = null;
        for (Comparable etiqueta : this.getVertices().keySet()) {
            double excentricidadDelVertice = (double) this.obtenerExcentricidad(etiqueta);
            if (excentricidadDelVertice != -1.0 && excentricidadDelVertice < menorExcentricidad) {
                menorExcentricidad = excentricidadDelVertice;
                centro = etiqueta;
            }
        }
        return centro;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizFloyd = UtilGrafos.obtenerMatrizCostos(vertices);
        matrizPredecesoresGrafo = inicializarMatriz(matrizFloyd.length);
        for (int i = 0; i < matrizFloyd.length; i++) {
            matrizFloyd[i][i] = 0.0;
        }
        for (int k = 0; k < matrizFloyd.length; k++) {
            for (int i = 0; i < matrizFloyd.length; i++) {
                for (int j = 0; j < matrizFloyd.length; j++) {
                    if ((matrizFloyd[i][k] + matrizFloyd[k][j]) < matrizFloyd[i][j]) {
                        matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                        matrizPredecesoresGrafo[i][j] = k + 0d;
                    }
                }
            }
        }
        return matrizFloyd;
        
    }

    private Double[][] inicializarMatriz(int largoMatriz) {
        Double[][] matrizInicializada = new Double[largoMatriz][largoMatriz];
        for (int i = 0; i < matrizInicializada.length; i++) {
            for (int j = 0; j < matrizInicializada.length; j++) {
                matrizInicializada[i][j] = -1d;
            }
        }
        return matrizInicializada;
    }
    
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        if (this.vertices.get(etiquetaVertice) == null) {
            return Double.MAX_VALUE;
        }
        Double[][] floyd = this.floyd();
        double excentricidad = Integer.MIN_VALUE;
        int indiceDeEtiqueta;
        Object[] etiquetas = this.getVertices().keySet().toArray();
        for (int indiceArray = 0; indiceArray < etiquetas.length; indiceArray++) {
            if (((etiquetas[indiceArray])).equals(etiquetaVertice)) {
                indiceDeEtiqueta = indiceArray;
                for (int i = 0; i < floyd.length; i++) {
                    if ( i != indiceDeEtiqueta && floyd[i][indiceDeEtiqueta] > excentricidad) {
                        excentricidad = floyd[i][indiceDeEtiqueta];
                    }
                }
                if (excentricidad == Double.MAX_VALUE) {
                    return -1.0;
                } else {
                    return excentricidad;
                }
            }
        }
        return Double.MAX_VALUE;        
    }

    @Override
    public Boolean[][] warshall() {
        Double[][] costos = UtilGrafos.obtenerMatrizCostos(vertices);
        Boolean[][] w = new Boolean[vertices.size()][vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                if (costos[i][j] == Double.MAX_VALUE || costos[i][j] <= 0) {
                    w[i][j] = false;
                } else {
                    w[i][j] = true;
                }
            }
        }
        for (int k = 0; k < w.length; k++) {
            for (int i = 0; i < w.length; i++) {
                for (int j = 0; j < w.length; j++) {
                    if (i == j) {
                        w[i][j] = false;
                    } else if (w[i][j] == false) {
                        w[i][j] = w[i][k] && w[k][j];
                    }
                }
            }
        }
        matrizWarshall = w;
        return w;
    }

}
