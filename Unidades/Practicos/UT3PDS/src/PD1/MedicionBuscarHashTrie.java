/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD1;

/**
 *
 * @author estudiante.fit
 */
public class MedicionBuscarHashTrie extends Medible{
    
    private TTrieHashMap arbolTrie;
    public MedicionBuscarHashTrie(TTrieHashMap arbolTrie) {
        this.arbolTrie = arbolTrie;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                arbolTrie.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arbolTrie;
    }
}
