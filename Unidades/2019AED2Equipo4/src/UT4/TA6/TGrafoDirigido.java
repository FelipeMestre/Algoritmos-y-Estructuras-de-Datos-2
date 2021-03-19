package UT4.TA6;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    private Double[][] matrizPredecesoresGrafo;

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
     * etiquetas sean inv�lidas, retorna falso.
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
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
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
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
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
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
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
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
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

    public boolean[][] warshall() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] matrizWarshall = new boolean[matrizCostos.length][matrizCostos.length];
        for (int i = 0; i < matrizCostos.length; i++) {
            for (int j = 0; j < matrizCostos.length; j++) {
                matrizWarshall[i][j] = false;

                if (i != j && matrizCostos[i][j] != Integer.MAX_VALUE) {
                    matrizWarshall[i][j] = true;
                }
            }
        }
        for (int k = 0; k < matrizWarshall.length; k++) {
            for (int i = 0; i < matrizWarshall.length; i++) {
                for (int j = 0; j < matrizWarshall.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!matrizWarshall[i][j]) {
                            matrizWarshall[i][j] = matrizWarshall[i][k] && matrizWarshall[k][j];
                        }
                    }
                }
            }
        }
        return matrizWarshall;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<Comparable> bpf(TVertice vertice) {
        this.desvisitarVertices();
        Collection<Comparable> coleccionDeVertices = new LinkedList<>();
        if (vertice != null) {
            vertice.bpf(coleccionDeVertices);
        }
        return coleccionDeVertices;
    }

    @Override
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        TVertice origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            origen.bpf(listaBpf);
        }
        return listaBpf;
    }

    @Override
    /**
     * BPF del grafo, a partir del primer vértice, para todos los vertices
     */

    public Collection<Comparable> bpf() {
        desvisitarVertices();
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();

        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    vertV.bpf(listaBpf);
                }
            }
        }
        return listaBpf;
    }

    public boolean esConexo() {

        Collection<Comparable> listaBpf = new LinkedList<Comparable>();

        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                desvisitarVertices();
                listaBpf.clear();
                vertV.bpf(listaBpf);
                if (listaBpf.size() != getVertices().size()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param comparadorCaminos
     * @return Un array con las claves de los vertices que componen el mejor
     * camino, en caso de que exista
     */
    @Override
    public boolean tieneCiclo() {
        this.desvisitarVertices();

        if (vertices.isEmpty()) {
            return false;
        } else {
            for (TVertice v : vertices.values()) {
                if (!v.getVisitado()) {
                    LinkedList<Comparable> camino = new LinkedList<>();
                    if (v.tieneCiclo(camino)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public Comparable centroDelGrafo() {
        if (!vertices.isEmpty()) {
            LinkedList<Comparable> excenticidades = new LinkedList<>();
            for (TVertice vertice : getVertices().values()) {
                excenticidades.add(obtenerExcentricidad(vertice.getEtiqueta()));
            }
            Comparable minimo = Double.MAX_VALUE;
            for (Comparable exc : excenticidades) {
                if (exc.compareTo(minimo) < 0) {
                    minimo = exc;
                }
            }
            return minimo;
        } else {
            return -1;
        }

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

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        if (vertices.isEmpty()) {
            return -1;
        } else {
            int contador = 0;
            int nNodo = 0;
            for (TVertice vertice : vertices.values()) {
                if (vertice.getEtiqueta().equals(etiquetaVertice)) {
                    nNodo = contador;
                }
                contador++;
            }
            Double[][] matriz = floyd();
            Double mayor = 0.0;
            for (int i = 0; i < vertices.size(); i++) {
                if (matriz[i][nNodo] > mayor) {
                    mayor = matriz[i][nNodo];
                }
            }
            return mayor;
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice verticeOrigen = buscarVertice(etiquetaOrigen);
        TVertice verticeDestino = buscarVertice(etiquetaDestino);
        if (verticeOrigen != null && verticeDestino != null) {
            TCamino caminoPrevio = new TCamino(verticeOrigen);
            verticeOrigen.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
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

    public boolean existeConexion(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        Double[][] floyd = floyd();
        int origen = 0;
        int destino = 0;
        int contador = 0;
        for (TVertice vertice : this.vertices.values()) {
            if (etiquetaOrigen.equals(vertice.getEtiqueta())) {
                origen = contador;
            }
            if (etiquetaDestino.equals(vertice.getEtiqueta())) {
                destino = contador;
            }
            contador++;
        }
        if (floyd[origen][destino] < Double.MAX_VALUE) {
            return true;
        }
        return false;
    }

    public void clasificacionTopologica() {
        desvisitarVertices();
        if (!tieneCiclo()) {
            LinkedList<TArista> adyacenciasInv = new LinkedList<>();
            TGrafoDirigido nGrafo = this;
            TVertice ultimo = new TVertice("");
            for (TVertice vert : nGrafo.getVertices().values()) {
                for(TAdyacencia ady : (LinkedList<TAdyacencia>)vert.getAdyacentes()){
                    adyacenciasInv.add(new TArista(ady.getDestino().getEtiqueta(), vert.getEtiqueta(),ady.getCosto()));
                }
            }
            for( TVertice vert : getVertices().values()){
                if(vert.getAdyacentes().size() == 0){
                    ultimo = vert;
                }
            }
            nGrafo = new TGrafoDirigido(vertices.values(), adyacenciasInv);
            nGrafo.buscarVertice(ultimo.getEtiqueta()).clasificacionTopologica();

        } else {
            System.out.println("El grafo esta vacio");
        }
    }

}
