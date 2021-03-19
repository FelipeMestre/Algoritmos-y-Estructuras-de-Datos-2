/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package UT3.TA6;

import java.util.LinkedList;
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
public class TArbolSufijosTest {

    TArbolSufijos trieVacio;
    TArbolSufijos trieUnString;

    public TArbolSufijosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        trieUnString = new TArbolSufijos("nacional");
        trieUnString.crearTrie();
        trieVacio = new TArbolSufijos("");
    }

    @After
    public void tearDown() {
        trieUnString = new TArbolSufijos("nacional");
        trieUnString.crearTrie();
        trieVacio = new TArbolSufijos("");
    }

    @Test
    public void testCrearTrie() {
        trieUnString.imprimir();
    }

    @Test
    public void testImprimir() {
        System.out.println("imprimir");
        trieUnString.imprimir();
    }

    @Test
    public void testPredecirTrieConUnString() {
        String prefijo = "nac";
        LinkedList<String> expResult = new LinkedList<>();
        expResult.add("nacional");
        LinkedList<String> result = trieUnString.predecir(prefijo);
        
        String prefijo2 = "a";
        LinkedList<String> expResult2 = new LinkedList<>();
        expResult2.add("acional");
        expResult2.add("al");
        LinkedList<String> result2 = trieUnString.predecir(prefijo2);
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testPredecirTrieVacio(){
        String prefijo = "al";
        LinkedList<String> expResult = new LinkedList<>();
        LinkedList<String> result = trieVacio.predecir(prefijo);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuscarPrefijoConUnaOcurrecia() {
        String prefijo = "cio";
        LinkedList<int[]> result = trieUnString.buscar(prefijo);
        int[] resultado = {2,7};
        assertEquals(resultado[0], result.get(0)[0]);
        assertEquals(resultado[1], result.get(0)[1]);
    }
    
    @Test
    public void testBuscarPrefijoDosOcurrecias() {
        String prefijo = "a";
        LinkedList<int[]> result = trieUnString.buscar(prefijo);
        int[] resultado = {1,7};
        int[] resultado2 = {6,7};
        assertEquals(resultado[0], result.get(0)[0]);
        assertEquals(resultado2[0], result.get(1)[0]);
        assertEquals(resultado[1], result.get(0)[1]);
        assertEquals(resultado2[1], result.get(1)[1]);
    }

    
}
