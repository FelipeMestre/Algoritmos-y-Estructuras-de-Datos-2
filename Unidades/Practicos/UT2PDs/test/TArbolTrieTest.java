/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

import java.util.Collection;
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
public class TArbolTrieTest {

    public static TArbolTrie arbol;
    public static TAbonado abonado1;
    public static TAbonado abonado2;
    public static TAbonado abonado3;
    public static TAbonado abonado4;
    public static TAbonado abonado5;

    public TArbolTrieTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        arbol = new TArbolTrie();
        abonado1 = new TAbonado("pedro", "098444432");
        abonado2 = new TAbonado("juan", "0984490889");
        abonado3 = new TAbonado("jose", "098445995");
        abonado4 = new TAbonado("marcos", "238427938");
        abonado5 = new TAbonado("enzo", "02942344");
    }

    @AfterClass
    public static void tearDownClass() {
        arbol = new TArbolTrie();
        abonado1 = new TAbonado("pedro", "098444432");
        abonado2 = new TAbonado("juan", "0984490889");
        abonado3 = new TAbonado("jose", "098445995");
        abonado4 = new TAbonado("marcos", "238427938");
        abonado5 = new TAbonado("enzo", "02942344");
    }

    @Before
    public void setUp() {
        arbol = new TArbolTrie();
        abonado1 = new TAbonado("pedro", "098444432");
        abonado2 = new TAbonado("juan", "0984490889");
        abonado3 = new TAbonado("jose", "098445995");
        abonado4 = new TAbonado("marcos", "238427938");
        abonado5 = new TAbonado("enzo", "02942344");
    }

    @After
    public void tearDown() {
        arbol = new TArbolTrie();
        abonado1 = new TAbonado("pedro", "098444432");
        abonado2 = new TAbonado("juan", "0984490889");
        abonado3 = new TAbonado("jose", "098445995");
        abonado4 = new TAbonado("marcos", "238427938");
        abonado5 = new TAbonado("enzo", "02942344");
    }

    /**
     * Test of insertar method, of class TArbolTrie.
     */
    @Test
    public void testInsertarArbolVacio() {
        assertEquals(null, arbol.getRaiz());
    }

    @Test
    public void testInsertar() {
        arbol.insertar(abonado1);
        Collection<TAbonado> ab = arbol.buscarTelefonos("098", "44");
        TAbonado[] array = ab.toArray(new TAbonado[ab.size()]);
        String[] DaArrayHood = new String[array.length];
        for (int i = 0; i < array.length; i++) {

            DaArrayHood[i] = array[i].getNombre();

        }
        assertEquals("pedro", DaArrayHood[0]);
    }

    @Test
    public void testBuscarTelefonos() {
        arbol.insertar(abonado1);
        arbol.insertar(abonado2);
        arbol.insertar(abonado3);
        arbol.insertar(abonado4);
        arbol.insertar(abonado5);
        Collection<TAbonado> ab = arbol.buscarTelefonos("098", "44");
        TAbonado[] array = ab.toArray(new TAbonado[ab.size()]);
        String[] DaArrayHood = new String[array.length];
        for (int i = 0; i < array.length; i++) {

            DaArrayHood[i] = array[i].getNombre();

        }
        assertEquals(3, DaArrayHood.length);
    }

    @Test
    public void testBuscarTelefonos2() {
        Collection<TAbonado> ab = arbol.buscarTelefonos("098", "44");
        TAbonado[] array = ab.toArray(new TAbonado[ab.size()]);
        String[] DaArrayHood = new String[array.length];
        for (int i = 0; i < array.length; i++) {

            DaArrayHood[i] = array[i].getNombre();

        }
        assertEquals(0, DaArrayHood.length);

    }

    
}
