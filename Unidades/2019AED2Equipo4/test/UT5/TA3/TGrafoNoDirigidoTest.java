/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT5.TA3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante.fit
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

     @Test
    public void testKruskal() {
        System.out.println("Kruskal");
        List<TVertice> verticesList = new ArrayList<TVertice>();
        List<TArista> aristasList = new ArrayList<TArista>();
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
        TGrafoNoDirigido krus = gnd.kruskal();
        int costo = 0;
        for(TArista a : krus.getLasAristas()){
            costo += a.getCosto();
        }
        assertEquals(costo/2, 8);
        
    }
    
    @Test
    public void testPrim() {
        System.out.println("Prim");
        List<TVertice> verticesList = new ArrayList<TVertice>();
        List<TArista> aristasList = new ArrayList<TArista>();
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
        TGrafoNoDirigido prim = gnd.prim();
        for(TArista ar : prim.getLasAristas()){
            System.out.println(ar.getEtiquetaOrigen() + " " + ar.getEtiquetaDestino());
        }
        int costo = 0;
        for(TArista a : prim.getLasAristas()){
            costo += a.getCosto();
        }
        System.out.println(costo);
        assertEquals(costo/2, 8);
        
    }
    
   

    

    
}
