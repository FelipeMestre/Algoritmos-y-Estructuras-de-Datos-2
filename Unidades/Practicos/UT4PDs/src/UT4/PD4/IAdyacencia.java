package UT4.PD4;

import UT4.PD3.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */
public interface IAdyacencia {

    /**
     * Devuelve el costo de la adyacencia
     * @return 
     */
    double getCosto();

    /**
     * Retorna el destino de 
     * @return 
     */
    TVertice getDestino();

    Comparable getEtiqueta();
    
}
