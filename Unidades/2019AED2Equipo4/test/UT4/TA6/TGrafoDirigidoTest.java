/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT4.TA6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fran_
 */
public class TGrafoDirigidoTest {
    
    public TGrafoDirigidoTest() {
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

    @Test
    public void testEsConexo() {
        List<TVertice> verticesList = new ArrayList<TVertice>(3);
        List<TArista> aristasList = new ArrayList<TArista>(2);
        verticesList.add(new TVertice("a"));
        verticesList.add(new TVertice("b"));
        verticesList.add(new TVertice("c"));
        
        aristasList.add(new TArista("a", "b", 5));
        aristasList.add(new TArista("b", "a", 5));
        aristasList.add(new TArista("a", "c", 5));
        aristasList.add(new TArista("c", "a", 5));
       // aristasList.add(new TArista("b", "c", 5));
        //aristasList.add(new TArista("c", "b", 5));
        
        TGrafoDirigido gd = new TGrafoDirigido(verticesList, aristasList);
        
        assertTrue(gd.esConexo());
        
    }
    
    
    
    @Test
    public void testTopologico() {
        List<TVertice> verticesList = new ArrayList<TVertice>(3);
        List<TArista> aristasList = new ArrayList<TArista>(2);
        verticesList.add(new TVertice("c1"));
        verticesList.add(new TVertice("c2"));
        verticesList.add(new TVertice("c3"));
        verticesList.add(new TVertice("c4"));
        verticesList.add(new TVertice("c5"));
        
        aristasList.add(new TArista("c1", "c3", 5));
        aristasList.add(new TArista("c2", "c3", 5));
        aristasList.add(new TArista("c3", "c5", 5));
        aristasList.add(new TArista("c4", "c5", 5));
        
        TGrafoDirigido gd = new TGrafoDirigido(verticesList, aristasList);
        gd.clasificacionTopologica();
    }
    
    
    @Test
    public void testTopologico2() {
        List<TVertice> verticesList = new ArrayList<TVertice>(3);
        List<TArista> aristasList = new ArrayList<TArista>(2);
        verticesList.add(new TVertice("Inicio"));
        verticesList.add(new TVertice("c1"));
        verticesList.add(new TVertice("c2"));
        verticesList.add(new TVertice("c3"));
        verticesList.add(new TVertice("c4"));
        verticesList.add(new TVertice("Fin"));
        
        aristasList.add(new TArista("Inicio", "c1", 5));
        aristasList.add(new TArista("Inicio", "c2", 5));
        aristasList.add(new TArista("Inicio", "c3", 5));
        aristasList.add(new TArista("c1", "c4", 5));
        aristasList.add(new TArista("c2", "c4", 5));
        aristasList.add(new TArista("c3", "c4", 5));
        aristasList.add(new TArista("c4", "Fin", 5));
      
        
        TGrafoDirigido gd = new TGrafoDirigido(verticesList, aristasList);
        gd.clasificacionTopologica();
    }
    
    
    @Test
    public void testTieneCiclo() {
        List<TVertice> verticesList = new ArrayList<TVertice>(3);
        List<TArista> aristasList = new ArrayList<TArista>(2);
        verticesList.add(new TVertice("a"));
        verticesList.add(new TVertice("b"));
        verticesList.add(new TVertice("c"));
        
        
        aristasList.add(new TArista("b", "c", 5));
        aristasList.add(new TArista("a", "c", 5));
        
       // aristasList.add(new TArista("b", "c", 5));
       // aristasList.add(new TArista("c", "b", 5));
        
        TGrafoDirigido gd = new TGrafoDirigido(verticesList, aristasList);
        
        assertTrue(gd.tieneCiclo());
        
    }
}