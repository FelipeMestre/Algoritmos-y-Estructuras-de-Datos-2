package UT4.PD4;
import UT4.PD3.*;
import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T>  implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

 
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
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
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }
    
      @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }


       public T getDatos() {
        return datos; 
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        visitados.add(this);
        this.visitado = true;
        for (TAdyacencia adyacencia : this.adyacentes) {
            TVertice adyacente = adyacencia.getDestino();
            if (adyacente.visitado == false) {
                adyacente.bpf(visitados);
            }
        }
    }
    
    public void imprimirEnBpf(){
        this.setVisitado(true);
        System.out.println(this.etiqueta);
        for (TAdyacencia adyacencia: this.adyacentes) { //O(A)
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                destino.imprimirEnBpf();
            }
        }
    }
    
    /**
     * Devuelve un TCaminos con todos los caminos posibles de un vertice a otro
     * @param etVertDest
     * @param caminoPrevio
     * @param todosLosCaminos
     * @return 
     */
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
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
}
