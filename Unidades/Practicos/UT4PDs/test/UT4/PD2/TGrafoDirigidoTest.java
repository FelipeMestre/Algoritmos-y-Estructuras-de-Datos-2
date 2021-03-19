/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT4.PD2;

import UT4.PD2.TArista;
import UT4.PD2.TGrafoDirigido;
import UT4.PD2.UtilGrafos;
import UT4.PD2.TVertice;
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
    public void testCentroDelGrafoCincoVertices() {
        Comparable etiquetaCentro = grafoCincoVertices.centroDelGrafo();
        assertEquals("e",etiquetaCentro);
    }
    
    @Test
    public void testCentroDelGrafoCuatroVertices(){
        Comparable etiquetaCentro = grafoCuatroVertices.centroDelGrafo();
        assertEquals("b",etiquetaCentro);
    }
    
    @Test
    public void testCentroDelGrafoTresVertices(){
        Comparable etiquetaCentro = grafoTresVertices.centroDelGrafo();
        assertEquals("b",etiquetaCentro);
    }
    
    @Test
    public void testCentroDelGrafoDosVertices(){
        Comparable etiquetaCentro = grafoDosVertices.centroDelGrafo();
        assertEquals("a",etiquetaCentro);
    }
    
    @Test
    public void testCentroDelGrafoUnVertice(){
        Comparable etiquetaCentro = grafoUnVertice.centroDelGrafo();
        assertEquals("a",etiquetaCentro);
    }

    @Test
    public void testFloydCincoVertices() {
        Double[][] floyd = grafoCincoVertices.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoCincoVertices.getVertices(),"Floyd Cinco Vertices");
        
        assertEquals(3.0, floyd[0][1],0);
        assertEquals(1.0, floyd[0][2],0);
        assertEquals(4.0, floyd[0][3],0);
        assertEquals(2.0, floyd[0][4],0);
        
        assertEquals(6.0, floyd[1][0],0);
        assertEquals(7.0, floyd[1][2],0);
        assertEquals(10.0, floyd[1][3],0);
        assertEquals(3.0, floyd[1][4],0);
        
        assertEquals(4.0, floyd[2][0],0);
        assertEquals(2.0, floyd[2][1],0);
        assertEquals(8.0, floyd[2][3],0);
        assertEquals(1.0, floyd[2][4],0);
        
        assertEquals(9.0, floyd[3][0],0);
        assertEquals(7.0, floyd[3][1],0);
        assertEquals(5.0, floyd[3][2],0);
        assertEquals(6.0, floyd[3][4],0);
        
        assertEquals(3.0, floyd[4][0],0);
        assertEquals(6.0, floyd[4][1],0);
        assertEquals(4.0, floyd[4][2],0);
        assertEquals(7.0, floyd[4][3],0);
        
        assertEquals(0.0, floyd[0][0],0);
        assertEquals(0.0, floyd[1][1],0);
        assertEquals(0.0, floyd[2][2],0);
        assertEquals(0.0, floyd[3][3],0);
        assertEquals(0.0, floyd[4][4],0);
        
    }
    
    @Test
    public void testFloydCuatroVertices(){
        Double[][] floyd = grafoCuatroVertices.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoCuatroVertices.getVertices(),"Floyd Cuatro Vertices");
        
        assertEquals(3.0, floyd[0][1],0);
        assertEquals(1.0, floyd[0][2],0);
        assertEquals(4.0, floyd[0][3],0);
        
        assertEquals(6.0, floyd[1][0],0);
        assertEquals(7.0, floyd[1][2],0);
        assertEquals(10.0, floyd[1][3],0);
        
        assertEquals(8.0, floyd[2][0],0);
        assertEquals(2.0, floyd[2][1],0);
        assertEquals(12.0, floyd[2][3],0);
        
        assertEquals(13.0, floyd[3][0],0);
        assertEquals(7.0, floyd[3][1],0);
        assertEquals(5.0, floyd[3][2],0);
        
        assertEquals(0.0, floyd[0][0],0);
        assertEquals(0.0, floyd[1][1],0);
        assertEquals(0.0, floyd[2][2],0);
        assertEquals(0.0, floyd[3][3],0);
    }
    
    @Test
    public void testFloydTresVertices(){
        Double[][] floyd = grafoTresVertices.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoTresVertices.getVertices(),"Floyd Tres Vertices");
        
        assertEquals(3.0, floyd[0][1],0);
        assertEquals(1.0, floyd[0][2],0);
        
        assertEquals(6.0, floyd[1][0],0);
        assertEquals(7.0, floyd[1][2],0);
        
        assertEquals(8.0, floyd[2][0],0);
        assertEquals(2.0, floyd[2][1],0);
        
        assertEquals(0.0, floyd[0][0],0);
        assertEquals(0.0, floyd[1][1],0);
        assertEquals(0.0, floyd[2][2],0);
    }
    
    @Test
    public void testFloydDosVertices(){
        Double[][] floyd = grafoDosVertices.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoDosVertices.getVertices(),"Floyd Dos Vertices");
        
        assertEquals(Double.MAX_VALUE, floyd[0][1],0);
        
        assertEquals(6.0, floyd[1][0],0);
        
        assertEquals(0.0, floyd[0][0],0);
        assertEquals(0.0, floyd[1][1],0);
        
    }
    
    @Test
    public void testFloydUnVertice(){
        Double[][] floyd = grafoUnVertice.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoUnVertice.getVertices(),"Floyd Un Vertices");
        assertEquals(0.0, floyd[0][0],0);        
    }

    @Test
    public void testObtenerExcentricidadCincoVertices() {
        Comparable excentricidadA = grafoCincoVertices.obtenerExcentricidad("a");
        Comparable excentricidadB = grafoCincoVertices.obtenerExcentricidad("b");
        Comparable excentricidadC = grafoCincoVertices.obtenerExcentricidad("c");
        Comparable excentricidadD = grafoCincoVertices.obtenerExcentricidad("d");
        Comparable excentricidadE = grafoCincoVertices.obtenerExcentricidad("e");
        
        assertEquals(9.0,excentricidadA);
        assertEquals(7.0,excentricidadB);
        assertEquals(7.0,excentricidadC);
        assertEquals(10.0,excentricidadD);
        assertEquals(6.0,excentricidadE);
    }
    
    @Test
    public void testObtenerExcentricidadCuatroVertices() {
        Comparable excentricidadA = grafoCuatroVertices.obtenerExcentricidad("a");
        Comparable excentricidadB = grafoCuatroVertices.obtenerExcentricidad("b");
        Comparable excentricidadC = grafoCuatroVertices.obtenerExcentricidad("c");
        Comparable excentricidadD = grafoCuatroVertices.obtenerExcentricidad("d");
        
        assertEquals(13.0,excentricidadA);
        assertEquals(7.0,excentricidadB);
        assertEquals(7.0,excentricidadC);
        assertEquals(12.0,excentricidadD);
    }
    
    @Test
    public void testObtenerExcentricidadTresVertices() {
        Comparable excentricidadA = grafoTresVertices.obtenerExcentricidad("a");
        Comparable excentricidadB = grafoTresVertices.obtenerExcentricidad("b");
        Comparable excentricidadC = grafoTresVertices.obtenerExcentricidad("c");
        
        assertEquals(8.0,excentricidadA);
        assertEquals(3.0,excentricidadB);
        assertEquals(7.0,excentricidadC);
    }
    
    @Test
    public void testObtenerExcentricidadDosVertices() {
        Comparable excentricidadA = grafoDosVertices.obtenerExcentricidad("a");
        Comparable excentricidadB = grafoDosVertices.obtenerExcentricidad("b");
        
        assertEquals(6.0,excentricidadA);
        assertEquals(-1.0,excentricidadB);
    }
    

    @Test
    public void testWarshallCincoVertices() {
        Boolean[][] warshall = grafoCincoVertices.warshall();
        assertEquals(true, warshall[0][1]);
        assertEquals(true, warshall[0][2]);
        assertEquals(true, warshall[0][3]);
        assertEquals(true, warshall[0][4]);
        
        assertEquals(true, warshall[1][0]);
        assertEquals(true, warshall[1][2]);
        assertEquals(true, warshall[1][3]);
        assertEquals(true, warshall[1][4]);
        
        assertEquals(true, warshall[2][0]);
        assertEquals(true, warshall[2][1]);
        assertEquals(true, warshall[2][3]);
        assertEquals(true, warshall[2][4]);
        
        assertEquals(true, warshall[3][0]);
        assertEquals(true, warshall[3][1]);
        assertEquals(true, warshall[3][2]);
        assertEquals(true, warshall[3][4]);
        
        assertEquals(true, warshall[4][0]);
        assertEquals(true, warshall[4][1]);
        assertEquals(true, warshall[4][2]);
        assertEquals(true, warshall[4][3]);
        
        assertEquals(false, warshall[0][0]);
        assertEquals(false, warshall[1][1]);
        assertEquals(false, warshall[2][2]);
        assertEquals(false, warshall[3][3]);
        assertEquals(false, warshall[4][4]);
    }  
    
    @Test
    public void testWarshallCuatroVertices() {
        Boolean[][] warshall = grafoCuatroVertices.warshall();
        assertEquals(true, warshall[0][1]);
        assertEquals(true, warshall[0][2]);
        assertEquals(true, warshall[0][3]);
        
        assertEquals(true, warshall[1][0]);
        assertEquals(true, warshall[1][2]);
        assertEquals(true, warshall[1][3]);
        
        assertEquals(true, warshall[2][0]);
        assertEquals(true, warshall[2][1]);
        assertEquals(true, warshall[2][3]);
        
        assertEquals(true, warshall[3][0]);
        assertEquals(true, warshall[3][1]);
        assertEquals(true, warshall[3][2]);
        
        assertEquals(false, warshall[0][0]);
        assertEquals(false, warshall[1][1]);
        assertEquals(false, warshall[2][2]);
        assertEquals(false, warshall[3][3]);
    }

    @Test
    public void testWarshallTresVertices() {
        Boolean[][] warshall = grafoTresVertices.warshall();
        assertEquals(true, warshall[0][1]);
        assertEquals(true, warshall[0][2]);
        
        assertEquals(true, warshall[1][0]);
        assertEquals(true, warshall[1][2]);
        
        assertEquals(true, warshall[2][0]);
        assertEquals(true, warshall[2][1]);
        
        
        assertEquals(false, warshall[0][0]);
        assertEquals(false, warshall[1][1]);
        assertEquals(false, warshall[2][2]);
    }
    
    @Test
    public void testWarshallDosVertices() {
        Boolean[][] warshall = grafoDosVertices.warshall();
        assertEquals(false, warshall[0][1]);
        
        assertEquals(true, warshall[1][0]);
        
        assertEquals(false, warshall[0][0]);
        assertEquals(false, warshall[1][1]);
    }
    
    
}
