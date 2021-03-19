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
public class TTrieHashMapTest {
    
    TTrieHashMap trieVacio;
    TTrieHashMap trieUnString;
    TTrieHashMap trieMuchosString;
    
    public TTrieHashMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trieVacio = new TTrieHashMap();
        trieUnString = new TTrieHashMap();
        trieUnString.insertar("nacional");
        trieMuchosString = new TTrieHashMap();
        trieMuchosString.insertar("ala");
        trieMuchosString.insertar("alimania");
        trieMuchosString.insertar("alabastro");
        trieMuchosString.insertar("perro");
        trieMuchosString.insertar("pera");
        trieMuchosString.insertar("alimento");
        trieMuchosString.insertar("casa");
        trieMuchosString.insertar("casada");
        trieMuchosString.insertar("cazar");
        trieMuchosString.insertar("programa");
        trieMuchosString.insertar("programacion");
        trieMuchosString.insertar("programar");
    }
    
    @After
    public void tearDown() {
        trieVacio = new TTrieHashMap();
        trieUnString = new TTrieHashMap();
        trieUnString.insertar("nacional");
        trieMuchosString = new TTrieHashMap();
        trieMuchosString.insertar("ala");
        trieMuchosString.insertar("alimania");
        trieMuchosString.insertar("alabastro");
        trieMuchosString.insertar("perro");
        trieMuchosString.insertar("pera");
        trieMuchosString.insertar("alimento");
        trieMuchosString.insertar("casa");
        trieMuchosString.insertar("casada");
        trieMuchosString.insertar("cazar");
        trieMuchosString.insertar("programa");
        trieMuchosString.insertar("programacion");
        trieMuchosString.insertar("programar");
    }

    @Test
    public void testInsertar() {
        System.out.println("Test de insertar");
        trieVacio.insertar("nacional");
        trieVacio.insertar("nacion");
        trieVacio.insertar("nativo");
        trieVacio.insertar("noche");
        trieVacio.insertar("negro");
        trieVacio.insertar("naranja");
        trieVacio.imprimir();
        System.out.println("---------------------------------");
    }

    @Test
    public void testImprimir() {
        System.out.println("Test de imprimir");
        System.out.println("Muchos string");
        trieMuchosString.imprimir();
        System.out.println("Un String");
        trieMuchosString.imprimir();
        System.out.println("------------------------------------");
    }

    @Test
    public void testPredecirTrieVacio() {
        LinkedList<String> result = trieVacio.predecir("arbol");
        assertEquals(0,result.size());
    }
    
    @Test
    public void testPredecirTrieUnString() {
        LinkedList<String> result = trieUnString.predecir("nac");
        assertEquals("nacional",result.get(0));
    }
    
    @Test
    public void testPredecirTrieVariosString(){
        LinkedList<String> result = trieMuchosString.predecir("prog");
        assertEquals(3,result.size());
        assertEquals("programa",result.get(0));
        assertEquals("programacion",result.get(2));
        assertEquals("programar",result.get(1));
    }
    
}
