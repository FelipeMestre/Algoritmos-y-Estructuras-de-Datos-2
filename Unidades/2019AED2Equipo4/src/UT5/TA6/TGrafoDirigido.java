package UT5.TA6;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
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
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
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
     * @param nombreVertice
     * @return
     */
    @Override
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
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
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
    @Override
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
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
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


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        this.desvisitarVertices();
        Collection<TVertice> coleccionDeVertices = new LinkedList<>();
        if (vertice != null) {
            vertice.bpf(coleccionDeVertices);
        }
        return coleccionDeVertices;
    }

    

    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf() {
        desvisitarVertices();
        Collection<TVertice> listaBpf = new LinkedList<>();

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


    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<TVertice> listaBpf = new LinkedList<>();
        TVertice origen = vertices.get(etiquetaOrigen);
        if (origen != null) {
            origen.bpf(listaBpf);
        }
        return listaBpf;
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

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        desvisitarVertices();
        if (vertices.isEmpty()) {
            return false;
        } else {
                    TVertice vert = buscarVertice(etiquetaOrigen);
                     LinkedList<Comparable> camino = new LinkedList<>();
                    if (vert.tieneCiclo(camino)) {
                        return true;
                    }
        }
        return false;
    }


    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
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

    public Double todosLosCaminosEficientes(TVertice emisor) {
        desvisitarVertices();
        TCaminos caminos;
        if (!getVertices().isEmpty()) {
            Double contador = 0.0;
            for (TVertice vert : getVertices().values()) {
                if (!vert.getEtiqueta().equals(emisor.getEtiqueta())) {
                    caminos = todosLosCaminos(emisor.getEtiqueta(), vert.getEtiqueta());
                    Double  min = Double.MAX_VALUE;
                    for(TCamino cam : caminos.getCaminos()){
                        if(min > cam.getCostoTotal()){
                            min = cam.getCostoTotal();
                        }
                    }
                    contador += min;
                }

            }
            return contador;
        } else {
            return -1.0;
        }
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
                if(vert.getAdyacentes().isEmpty()){
                    ultimo = vert;
                }
            }
            nGrafo = new TGrafoDirigido(vertices.values(), adyacenciasInv);
            nGrafo.buscarVertice(ultimo.getEtiqueta()).clasificacionTopologica();

        } else {
            System.out.println("El grafo esta vacio");
        }
    }

    
    
    public int clasificacionTopologicaSemestral() {
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
                if(vert.getAdyacentes().isEmpty()){
                    ultimo = vert;
                }
            }
            nGrafo = new TGrafoDirigido(vertices.values(), adyacenciasInv);
            return nGrafo.buscarVertice(ultimo.getEtiqueta()).clasificacionTopologicaSemestral(1);

        } else {
            return 0;
        }
    }
    public boolean llegaATodos(Comparable etiquetaOrigen) { 
        TVertice origen = getVertices().get(etiquetaOrigen);
        Collection<Comparable> listaBpf = new LinkedList<Comparable>();
        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            desvisitarVertices();
            listaBpf.clear();
            origen.bpf(listaBpf);
            if(listaBpf.size()!=getVertices().size()){
                return false;
            }
        }
        return true;
    }


    

   
}
