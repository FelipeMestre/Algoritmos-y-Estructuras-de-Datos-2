package UT5.TA6;

import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBp;
    private int numBajo;
    private boolean esHoja= false;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
         this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    copia.setCostoTotal(caminoPrevio.getCostoTotal()+adyacencia.getCosto());
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                   caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        this.setVisitado(true);
        LinkedList<TVertice> cola = new LinkedList<>();
        cola.add(this);
        visitados.add(this);        
        while (!cola.isEmpty()){
            TVertice x = cola.pop();
            for (TAdyacencia y : (LinkedList<TAdyacencia>)x.getAdyacentes()){
                if(!y.getDestino().getVisitado()){
                    cola.add(y.getDestino());
                    visitados.add(y.getDestino());
                    y.getDestino().setVisitado(true);
                }
            }
        }
    }



    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        camino.add(this.getEtiqueta());
        this.setVisitado(true);
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice w = adyacencia.getDestino();
            if (!w.getVisitado()) {
                if (w.tieneCiclo(camino)){
                    return true;
                }
            }else {
                if( camino.contains(w.getEtiqueta())) {
                    return true;
                }
            }
        }return false;
    }
    
    public boolean tieneCicloNoDirigido(TCamino camino) {
        this.setVisitado(true);
        boolean salir = false;
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            camino.agregarAdyacencia(adyacencia);
            if (!salir) {
                if (!adyacencia.getDestino().getVisitado()) {
                    salir = adyacencia.getDestino().tieneCicloNoDirigido(camino);
                } else if (camino.getOtrosVertices().size() > 2 && adyacencia.getDestino().getEtiqueta().equals(camino.getOrigen())) {
                    return true;
                }
            }
        }
        return salir;
    }
   public int puntoArticulacion(LinkedList<TVertice> visitados, LinkedList<TVertice> puntosArticulacion, int bpAntecesor){
        //en el bajo se se ira guardando el minimo entre un vertice y el bajo de sus hijos y entre el bp del vertice y sus antecesores
        this.setVisitado(true);
        visitados.add(this);
        this.setNumBp(visitados.size());
        this.setNumBajo(this.getNumBp());
        int bajoHijo=0;
        int mayorBajoHijo=0;
        int auxRaiz=0;
        for(TAdyacencia w : this.getAdyacentes() ){
            TVertice destino = w.getDestino();
            if (!destino.getVisitado()){
                if(visitados.contains(this)){
                    //auxiliar para saber si un nodo raiz tiene mas de 1 hijo
                    auxRaiz++;
                }
                bajoHijo = destino.puntoArticulacion(visitados,puntosArticulacion,this.getNumBp());
                //eligo minimo entre bajo del vertice actual y el bajo del hijo:
                if(this.getNumBp()!=1 && this.getNumBp()<= bajoHijo && !puntosArticulacion.contains(this) ){
                    puntosArticulacion.add(this);
                    
                }
                mayorBajoHijo =Math.max(this.getNumBajo(), bajoHijo);
                this.setNumBajo(Math.min(this.getNumBajo(), bajoHijo));
                //System.out.println("etiq "+this.getEtiqueta()+" thisBP "+this.getBP()+" thisBajo "+this.getBajo()+" bajoHijo "+bajoHijo);
            }else{
                if(bpAntecesor!=destino.getNumBp()&& destino.getNumBp()<this.getNumBp()){
                    //eligo minimo entre bajo del vertice actual y el bp de un antecesor:
                    this.setNumBajo(Math.min(this.getNumBajo(), destino.getNumBp()));    
                    bajoHijo = destino.getNumBajo();
                } else if(bajoHijo == 0){
                    //cuando llega a un vertice que no tiene hijo
                    this.setNumBajo(this.getNumBp());
                    this.setHoja();
                } 
            }
        }
        //System.out.println(this.etiqueta+" "+this.bp+" "+this.bajo);
        if(auxRaiz>1 && !puntosArticulacion.contains(this)){
            //se agrega la raiz, cuya cantidad de hijos es mayor a 1
            puntosArticulacion.add(this);
        }
        else if (this.esHoja()){
            return this.getNumBajo();
        }
        return this.getNumBajo();

    }

    /**
     * @return the numBp
     */
    public int getNumBp() {
        return numBp;
    }

    /**
     * @param numBp the numBp to set
     */
    public void setNumBp(int numBp) {
        this.numBp = numBp;
    }

    /**
     * @return the numBajo
     */
    public int getNumBajo() {
        return numBajo;
    }

    /**
     * @param numBajo the numBajo to set
     */
    public void setNumBajo(int numBajo) {
        this.numBajo = numBajo;
    }
    public void setHoja(){
        this.esHoja=true;
    }
    public boolean esHoja(){
        return this.esHoja;
    }
    
    public void clasificacionTopologica(){
        setVisitado(true);
        for( TAdyacencia w : getAdyacentes()){
            if(!w.getDestino().getVisitado()){
                w.getDestino().clasificacionTopologica();
            }
        }
        System.out.println(getEtiqueta());
    }
    
    public int clasificacionTopologicaSemestral(int contador){
        setVisitado(true);
        
        for( TAdyacencia w : getAdyacentes()){
            if(!w.getDestino().getVisitado()){
                return w.getDestino().clasificacionTopologicaSemestral(contador+1);
            }
        }
        System.out.println(getEtiqueta());
        return contador;
    }


}
