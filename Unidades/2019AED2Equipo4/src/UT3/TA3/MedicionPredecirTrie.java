package UT3.TA3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author administrador
 */
public class MedicionPredecirTrie extends Medible{
    private TArbolTrie arbolito;

    public MedicionPredecirTrie(TArbolTrie arbolito) {
        this.arbolito = arbolito;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                arbolito.predecir(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arbolito;
    }
}
