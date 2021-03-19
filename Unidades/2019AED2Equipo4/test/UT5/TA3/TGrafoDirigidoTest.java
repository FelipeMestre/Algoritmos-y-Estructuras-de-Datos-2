/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT5.TA3;

import java.util.Collection;
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
    public void testEliminarArista() {
        System.out.println("eliminarArista");
        Comparable nomVerticeOrigen = null;
        Comparable nomVerticeDestino = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.eliminarArista(nomVerticeOrigen, nomVerticeDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarVertice() {
        System.out.println("eliminarVertice");
        Comparable nombreVertice = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.eliminarVertice(nombreVertice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testExisteArista() {
        System.out.println("existeArista");
        Comparable etiquetaOrigen = null;
        Comparable etiquetaDestino = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.existeArista(etiquetaOrigen, etiquetaDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testExisteVertice() {
        System.out.println("existeVertice");
        Comparable unaEtiqueta = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.existeVertice(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarArista() {
        System.out.println("insertarArista");
        TArista arista = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.insertarArista(arista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarVertice_Comparable() {
        System.out.println("insertarVertice");
        Comparable unaEtiqueta = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.insertarVertice(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarVertice_TVertice() {
        System.out.println("insertarVertice");
        TVertice vertice = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.insertarVertice(vertice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEtiquetasOrdenado() {
        System.out.println("getEtiquetasOrdenado");
        TGrafoDirigido instance = null;
        Object[] expResult = null;
        Object[] result = instance.getEtiquetasOrdenado();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesvisitarVertices() {
        System.out.println("desvisitarVertices");
        TGrafoDirigido instance = null;
        instance.desvisitarVertices();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        TGrafoDirigido instance = null;
        Map<Comparable, TVertice> expResult = null;
        Map<Comparable, TVertice> result = instance.getVertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_TVertice() {
        System.out.println("bpf");
        TVertice vertice = null;
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf(vertice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTieneCiclo_TCamino() {
        System.out.println("tieneCiclo");
        TCamino camino = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.tieneCiclo(camino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_0args() {
        System.out.println("bpf");
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBpf_Comparable() {
        System.out.println("bpf");
        Comparable etiquetaOrigen = null;
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bpf(etiquetaOrigen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCentroDelGrafo() {
        System.out.println("centroDelGrafo");
        TGrafoDirigido instance = null;
        Comparable expResult = null;
        Comparable result = instance.centroDelGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testFloyd() {
        System.out.println("floyd");
        TGrafoDirigido instance = null;
        Double[][] expResult = null;
        Double[][] result = instance.floyd();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerExcentricidad() {
        System.out.println("obtenerExcentricidad");
        Comparable etiquetaVertice = null;
        TGrafoDirigido instance = null;
        Comparable expResult = null;
        Comparable result = instance.obtenerExcentricidad(etiquetaVertice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testWarshall() {
        System.out.println("warshall");
        TGrafoDirigido instance = null;
        boolean[][] expResult = null;
        boolean[][] result = instance.warshall();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTodosLosCaminos() {
        System.out.println("todosLosCaminos");
        Comparable etiquetaOrigen = null;
        Comparable etiquetaDestino = null;
        TGrafoDirigido instance = null;
        TCaminos expResult = null;
        TCaminos result = instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTieneCiclo_Comparable() {
        System.out.println("tieneCiclo");
        Comparable etiquetaOrigen = null;
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.tieneCiclo(etiquetaOrigen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testTieneCiclo_0args() {
        System.out.println("tieneCiclo");
        TGrafoDirigido instance = null;
        boolean expResult = false;
        boolean result = instance.tieneCiclo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBea() {
        System.out.println("bea");
        TGrafoDirigido instance = null;
        Collection<TVertice> expResult = null;
        Collection<TVertice> result = instance.bea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
