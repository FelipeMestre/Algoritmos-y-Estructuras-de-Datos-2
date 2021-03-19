/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT5.TA6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Agroa
 */
public class TGrafoNoDirigidoTest {
    
    public TGrafoNoDirigidoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarArista method, of class TGrafoNoDirigido.
     */
    @Test
    public void testPuntosArticulacion() {
        List<TVertice> verticesList = new ArrayList<TVertice>();
        List<TArista> aristasList = new ArrayList<TArista>();
        verticesList.add(new TVertice("a"));
        verticesList.add(new TVertice("b"));
        verticesList.add(new TVertice("c"));
        verticesList.add(new TVertice("d"));
        verticesList.add(new TVertice("e"));
        verticesList.add(new TVertice("f"));
        verticesList.add(new TVertice("g"));
        
        aristasList.add(new TArista("a", "b", 3));
        aristasList.add(new TArista("a", "c", 4));
        aristasList.add(new TArista("a", "d", 1));
        aristasList.add(new TArista("a", "e", 1));
        
        aristasList.add(new TArista("b", "d", 1));
        aristasList.add(new TArista("b", "e", 1));
        
        aristasList.add(new TArista("d", "e", 1));
        
        aristasList.add(new TArista("f", "c", 1));
        aristasList.add(new TArista("g", "c", 1));
        
        aristasList.add(new TArista("g", "f", 1));
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(verticesList, aristasList);

        
       UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gnd.getVertices()), gnd.getVertices(), "costos"); 
        
         assertTrue(gnd.existeConexion("g", "f"));
         assertEquals(gnd.puntoArticulacion().size(), 2);
    }
    
    @Test
    public void tieneCiclo(){
        List<TVertice> verticesList = new ArrayList<TVertice>();
        List<TArista> aristasList = new ArrayList<TArista>();
        verticesList.add(new TVertice("a"));
        verticesList.add(new TVertice("b"));
        verticesList.add(new TVertice("c"));
        //verticesList.add(new TVertice("f"));
        
        aristasList.add(new TArista("a", "b", 1));
        aristasList.add(new TArista("b", "c", 1));
        aristasList.add(new TArista("c", "a", 1));
        //aristasList.add(new TArista("b", "c", 1));
        
        
        
        TGrafoDirigido gd = new TGrafoDirigido(verticesList, aristasList);
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(verticesList, aristasList);
        
        //assertFalse(gd.tieneCiclo());
        assertFalse(gnd.tieneCiclo());
        
    }
    
    @Test
    public void testPrim() {
        System.out.println("Prim");
        List<TVertice> verticesList = new ArrayList<TVertice>(3);
        List<TArista> aristasList = new ArrayList<TArista>(2);
        verticesList.add(new TVertice("1"));
        verticesList.add(new TVertice("2"));
        verticesList.add(new TVertice("3"));
        verticesList.add(new TVertice("4"));
        verticesList.add(new TVertice("5"));
        verticesList.add(new TVertice("6"));
        
        aristasList.add(new TArista("1", "2", 3));
        aristasList.add(new TArista("1", "3", 5));
        aristasList.add(new TArista("1", "4", 1));
        aristasList.add(new TArista("1", "5", 7));
        aristasList.add(new TArista("1", "6", 2));
        aristasList.add(new TArista("2", "3", 1));
        aristasList.add(new TArista("2", "4", 3));
        aristasList.add(new TArista("2", "5", 5));
        aristasList.add(new TArista("2", "6", 6));
        aristasList.add(new TArista("3", "4", 2));
        aristasList.add(new TArista("3", "5", 3));
        aristasList.add(new TArista("3", "5", 3));
        aristasList.add(new TArista("4", "5", 7));
        aristasList.add(new TArista("4", "6", 1));
        aristasList.add(new TArista("5", "6", 4));
        
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(verticesList, aristasList);
        TGrafoNoDirigido prim = gnd.Prim();
        TGrafoNoDirigido krus = gnd.Kruskal();
        
        System.out.println(prim.getCostoTotal());
        System.out.println(krus.getCostoTotal());
        
    }

    
}
