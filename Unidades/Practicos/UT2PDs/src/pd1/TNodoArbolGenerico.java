/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package pd1;

/**
 *
 * @author estudiante.fit
 */
public class TNodoArbolGenerico <T> {
    
    private TNodoArbolGenerico<T> hermanoDer;
    
    private TNodoArbolGenerico<T> primerHijo;
    
    private Comparable etiqueta;
    
    private T dato;

    public TNodoArbolGenerico(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        if (this.etiqueta.equals(unaEtiqueta)) {
            return false;
        }
        if (this.etiqueta.equals(etiquetaPadre)) {
            TNodoArbolGenerico<T> aux = new TNodoArbolGenerico<>(unaEtiqueta,null);
            aux.setHermanoDer(primerHijo);
            this.primerHijo = aux;
            return true;
        }
        TNodoArbolGenerico<T> aux = this.primerHijo;
        while (aux != null){
            if (aux.insertar(unaEtiqueta, etiquetaPadre) == true) {
                return true;
            } else {
                aux = aux.getHermanoDer();
            }
        }
        return false;
    }
    
    public TNodoArbolGenerico<T> buscar(Comparable etiqueta){
        if (this.etiqueta.equals(etiqueta)) {
            return this;
        }
        TNodoArbolGenerico<T> aux = this.primerHijo;
        while (aux != null){
            TNodoArbolGenerico<T> resultado = aux.buscar(etiqueta);
            if(resultado != null){
                return resultado;
            } else {
                aux = aux.getHermanoDer();
            }
        }
        return null;
    }
    
    public void listarIdentado(int contador){
        int contadorAux = contador;
        String resultado = "";
        while (contadorAux != 0){
            resultado = "\t" + resultado;
            contadorAux--;
        }
        resultado = resultado + (String) this.etiqueta;
        System.out.println(resultado);
        
        TNodoArbolGenerico<T> aux = this.primerHijo;
        while (aux != null){
            aux.listarIdentado(contador + 1);
            aux = aux.hermanoDer;
        }
    }
    
    public TNodoArbolGenerico<T> getHermanoDer() {
        return hermanoDer;
    }

    public void setHermanoDer(TNodoArbolGenerico<T> hermanoDer) {
        this.hermanoDer = hermanoDer;
    }

    public TNodoArbolGenerico<T> getPrimerHijo() {
        return primerHijo;
    }

    public void setPrimerHijo(TNodoArbolGenerico<T> primerHijo) {
        this.primerHijo = primerHijo;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
