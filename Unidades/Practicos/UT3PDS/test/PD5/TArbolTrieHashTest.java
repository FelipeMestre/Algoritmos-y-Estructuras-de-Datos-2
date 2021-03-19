/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD5;

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
public class TArbolTrieHashTest {

    private TArbolTrieHash trieVacio;
    private TArbolTrieHash trieConUnAbonado;
    private TArbolTrieHash trieConMuchosAbonados;

    public TArbolTrieHashTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        trieVacio = new TArbolTrieHash();
        trieConUnAbonado = new TArbolTrieHash();
        trieConMuchosAbonados = new TArbolTrieHash();
        TAbonado abonado1 = new TAbonado("Gonzalo Castro", "5982246589");
        TAbonado abonado2 = new TAbonado("Gonzalo Bergessio", "5982279648");
        TAbonado abonado3 = new TAbonado("Rodrigo Amaral", "5982213549");
        TAbonado abonado4 = new TAbonado("Luis Suarez", "7956446825");
        TAbonado abonado5 = new TAbonado("Diego Godin", "7956428531");
        trieConUnAbonado.insertar(abonado1);
        trieConMuchosAbonados.insertar(abonado1);
        trieConMuchosAbonados.insertar(abonado2);
        trieConMuchosAbonados.insertar(abonado3);
        trieConMuchosAbonados.insertar(abonado4);
        trieConMuchosAbonados.insertar(abonado5);
    }

    @After
    public void tearDown() {
        trieVacio = new TArbolTrieHash();
        trieConUnAbonado = new TArbolTrieHash();
        trieConMuchosAbonados = new TArbolTrieHash();
        TAbonado abonado1 = new TAbonado("Gonzalo Castro", "5982246589");
        TAbonado abonado2 = new TAbonado("Gonzalo Bergessio", "5982279648");
        TAbonado abonado3 = new TAbonado("Rodrigo Amaral", "5982213549");
        TAbonado abonado4 = new TAbonado("Luis Suarez", "7956446825");
        TAbonado abonado5 = new TAbonado("Diego Godin", "7956428531");
        trieConUnAbonado.insertar(abonado1);
        trieConMuchosAbonados.insertar(abonado1);
        trieConMuchosAbonados.insertar(abonado2);
        trieConMuchosAbonados.insertar(abonado3);
        trieConMuchosAbonados.insertar(abonado4);
        trieConMuchosAbonados.insertar(abonado5);
    }

    @Test
    public void testBuscarNodoTrieConUnAbonado() {
        String numero = "5982246589";
        TNodoTrieHash result = trieConUnAbonado.buscarNodo(numero);
        assertEquals("Gonzalo Castro", result.getAbonado().getNombre());
    }

    @Test
    public void testBuscarNodoTrieVacio() {
        String numero = "5982246589";
        TNodoTrieHash result = trieVacio.buscarNodo(numero);
        assertEquals(null, result);
    }
    
    @Test
    public void testBuscarNodoTrieConAbonados(){
        String numero = "5982246589";
        String numero2 = "5982279648";
        String numero3 = "5982213549";
        String numero4 = "7956446825";
        String numero5 = "7956428531";
        TNodoTrieHash result = trieConMuchosAbonados.buscarNodo(numero);
        TNodoTrieHash result2 = trieConMuchosAbonados.buscarNodo(numero2);
        TNodoTrieHash result3 = trieConMuchosAbonados.buscarNodo(numero3);
        TNodoTrieHash result4 = trieConMuchosAbonados.buscarNodo(numero4);
        TNodoTrieHash result5 = trieConMuchosAbonados.buscarNodo(numero5);
        assertEquals("Gonzalo Castro", result.getAbonado().getNombre());
        assertEquals("Gonzalo Bergessio", result2.getAbonado().getNombre());
        assertEquals("Rodrigo Amaral", result3.getAbonado().getNombre());
        assertEquals("Luis Suarez", result4.getAbonado().getNombre());
        assertEquals("Diego Godin", result5.getAbonado().getNombre());
    }

    @Test
    public void testBuscarTelefonosTrieVacio() {
        LinkedList<TAbonado> result = trieVacio.buscarTelefonos("598", "22");
        assertEquals(0,result.size());
    }
    
    @Test
    public void testBuscarTelefonosTrieUnAbonado(){
        LinkedList<TAbonado> result = trieConUnAbonado.buscarTelefonos("598", "22");
        assertEquals(1,result.size());
        assertEquals("Gonzalo Castro",result.get(0).getNombre());
    }
    
    @Test
    public void testBuscarTelefonosVariosAbonados(){
        LinkedList<TAbonado> result = trieConMuchosAbonados.buscarTelefonos("598", "22");
        assertEquals("Rodrigo Amaral",result.get(0).getNombre());
        assertEquals("Gonzalo Castro",result.get(1).getNombre());
        assertEquals("Gonzalo Bergessio",result.get(2).getNombre());
    }

}
