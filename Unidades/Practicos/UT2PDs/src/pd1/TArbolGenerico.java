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
public class TArbolGenerico <T> {

    private TNodoArbolGenerico<T> raiz;

    public TArbolGenerico() {
    }
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre){
        if (esVacio()) {
            TNodoArbolGenerico<T> aux = new TNodoArbolGenerico<>(unaEtiqueta,null);
            this.raiz = aux;
            return true;
        } else {
            if (etiquetaPadre.equals("")) {
                TNodoArbolGenerico<T> aux = new TNodoArbolGenerico<>(unaEtiqueta,null);
                aux.setPrimerHijo(raiz);
                this.raiz = aux;
                return true;
            } else {
                return raiz.insertar(unaEtiqueta, etiquetaPadre);
            }
        }
    }
    
    public TNodoArbolGenerico<T> buscar(Comparable etiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(etiqueta);
        }
    }
    
    public void listarIdentado(){
        if (esVacio()) {
            
        } else {
            raiz.listarIdentado(0);
        }
    }
    
    private boolean esVacio(){
        return raiz == null;
    }

    public TNodoArbolGenerico<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TNodoArbolGenerico<T> raiz) {
        this.raiz = raiz;
    }
    
    
    
}
