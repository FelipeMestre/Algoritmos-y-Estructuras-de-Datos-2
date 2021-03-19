/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie{

    private TNodoTrie raiz;
    
    
    @Override
    public Collection<TAbonado> buscarTelefonos(String codigoPais, String codigoArea) {
        
        LinkedList<TAbonado> listaDeAbonados = new LinkedList<>();
        
        if(raiz != null){
          raiz.buscarTelefonos(codigoPais + codigoArea, listaDeAbonados);
        }
        
        return listaDeAbonados;
    }

    @Override
    public void insertar(TAbonado abonado) {
        
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        
        raiz.insertar(abonado);
    }
    
    public TNodoTrie getRaiz(){
        return this.raiz;
    }
    
}
