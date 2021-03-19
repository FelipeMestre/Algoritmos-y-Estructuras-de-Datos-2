/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT4.PD3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
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
public class TGrafoDirigidoTest {
    
    private TGrafoDirigido grafoCincoVertices;
    private TGrafoDirigido grafoCuatroVertices;
    private TGrafoDirigido grafoTresVertices;
    private TGrafoDirigido grafoDosVertices;
    private TGrafoDirigido grafoUnVertice;
    
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
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");
        
        TArista a1 = new TArista("a","d",4);
        TArista a2 = new TArista("a","c",1);
        TArista a3 = new TArista("b","a",6);
        TArista a4 = new TArista("b","e",3);
        TArista a5 = new TArista("c","b",2);
        TArista a6 = new TArista("c","e",1);
        TArista a7 = new TArista("d","c",5);
        TArista a8 = new TArista("e","a",3);
        
        
        LinkedList<TVertice> cincoVertices = new LinkedList<>();
        cincoVertices.add(a);
        cincoVertices.add(b);
        cincoVertices.add(c);
        cincoVertices.add(d);
        cincoVertices.add(e);
        
        LinkedList<TVertice> cuatroVertices = new LinkedList<>();
        cuatroVertices.add(a);
        cuatroVertices.add(b);
        cuatroVertices.add(c);
        cuatroVertices.add(e);
        
        LinkedList<TVertice> tresVertices = new LinkedList<>();
        tresVertices.add(a);
        tresVertices.add(b);
        tresVertices.add(c);
        
        LinkedList<TVertice> dosVertices = new LinkedList<>();
        dosVertices.add(a);
        dosVertices.add(b);
        
        LinkedList<TVertice> unVertice = new LinkedList<>();
        unVertice.add(a);               
        
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        
        
        //Siempre se crean con la misma coleccion de aristas porque se ignoran las adyacencias que
        //No sean posibles de crear
        grafoCincoVertices = new TGrafoDirigido(cincoVertices, aristas);
        grafoCuatroVertices = new TGrafoDirigido(cuatroVertices, aristas);
        grafoTresVertices = new TGrafoDirigido(tresVertices, aristas);
        grafoDosVertices = new TGrafoDirigido(dosVertices, aristas);
        
    }
    
    @After
    public void tearDown() {
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");
        
        TArista a1 = new TArista("a","d",4);
        TArista a2 = new TArista("a","c",1);
        TArista a3 = new TArista("b","a",6);
        TArista a4 = new TArista("b","e",3);
        TArista a5 = new TArista("c","b",2);
        TArista a6 = new TArista("c","e",1);
        TArista a7 = new TArista("d","c",5);
        TArista a8 = new TArista("e","a",3);
        
        
        LinkedList<TVertice> cincoVertices = new LinkedList<>();
        cincoVertices.add(a);
        cincoVertices.add(b);
        cincoVertices.add(c);
        cincoVertices.add(d);
        cincoVertices.add(e);
        
        LinkedList<TVertice> cuatroVertices = new LinkedList<>();
        cuatroVertices.add(a);
        cuatroVertices.add(b);
        cuatroVertices.add(c);
        cuatroVertices.add(d);
        
        LinkedList<TVertice> tresVertices = new LinkedList<>();
        tresVertices.add(a);
        tresVertices.add(b);
        tresVertices.add(c);
        
        LinkedList<TVertice> dosVertices = new LinkedList<>();
        dosVertices.add(a);
        dosVertices.add(b);
        
        LinkedList<TVertice> unVertice = new LinkedList<>();
        unVertice.add(a);               
        
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        
        
        //Siempre se crean con la misma coleccion de aristas porque se ignoran las adyacencias que
        //No sean posibles de crear
        grafoCincoVertices = new TGrafoDirigido(cincoVertices, aristas);
        grafoCuatroVertices = new TGrafoDirigido(cuatroVertices, aristas);
        grafoTresVertices = new TGrafoDirigido(tresVertices, aristas);
        grafoDosVertices = new TGrafoDirigido(dosVertices, aristas);
        grafoUnVertice = new TGrafoDirigido(unVertice, aristas);
    }

    @Test
    public void testTodosLosCaminosCincoVertices() {
        Comparable etiquetaOrigen = "a";
        Comparable etiquetaDestino = "b";
        TCaminos result = grafoCincoVertices.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        Collection<TCamino> caminos = result.getCaminos();
        TCamino[] caminosArray = new TCamino[caminos.size()];
        caminos.toArray(caminosArray);
        LinkedList<Comparable> camino1 = caminosArray[0].getOtrosVertices();
        LinkedList<Comparable> camino2 = caminosArray[1].getOtrosVertices();
        
        result.imprimirCaminosConsola();
        
        assertEquals("d",camino1.get(0));
        assertEquals("c",camino1.get(1));
        assertEquals("b",camino1.get(2));
        
        assertEquals("c",camino2.get(0));
        assertEquals("b",camino2.get(1));
    }
    
    @Test
    public void testTodosLosCaminosCuatroVertices(){
        Comparable etiquetaOrigen = "a";
        Comparable etiquetaDestino = "e";
        TCaminos result = grafoCuatroVertices.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        result.imprimirCaminosConsola();
        Collection<TCamino> caminos = result.getCaminos();
        TCamino[] caminosArray = new TCamino[caminos.size()];
        caminos.toArray(caminosArray);
        LinkedList<Comparable> camino1 = caminosArray[0].getOtrosVertices();
        LinkedList<Comparable> camino2 = caminosArray[1].getOtrosVertices();
        
        result.imprimirCaminosConsola();
        
        assertEquals("c",camino1.get(0));
        assertEquals("b",camino1.get(1));
        assertEquals("e",camino1.get(2));
        
        assertEquals("c",camino2.get(0));
        assertEquals("e",camino2.get(1));
    }
    
    @Test
    public void testTodosLosCaminosTresVertices(){
        Comparable etiquetaOrigen = "a";
        Comparable etiquetaDestino = "c";
        TCaminos result = grafoTresVertices.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        result.imprimirCaminosConsola();
        Collection<TCamino> caminos = result.getCaminos();
        TCamino[] caminosArray = new TCamino[caminos.size()];
        caminos.toArray(caminosArray);
        LinkedList<Comparable> camino1 = caminosArray[0].getOtrosVertices();
        
        result.imprimirCaminosConsola();
        
        assertEquals("c",camino1.get(0));
        
    }
    
    @Test
    public void testTodosLosCaminosDosVertices(){
        Comparable etiquetaOrigen = "b";
        Comparable etiquetaDestino = "a";
        TCaminos result = grafoDosVertices.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        result.imprimirCaminosConsola();
        Collection<TCamino> caminos = result.getCaminos();
        TCamino[] caminosArray = new TCamino[caminos.size()];
        caminos.toArray(caminosArray);
        LinkedList<Comparable> camino1 = caminosArray[0].getOtrosVertices();
        
        assertEquals("a",camino1.get(0));
    }
    
    
}
