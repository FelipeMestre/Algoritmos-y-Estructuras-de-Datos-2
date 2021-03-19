/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD3;

import java.util.HashMap;
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
public class MetodosTest {
    
    public MetodosTest() {
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
    public void testEliminarUnNul() {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("Felipe","Mestre");
        hash.put("Peñarol", null);
        hash.put("Jorge", "Piñeyrua");
        Metodos.eliminarNulls(hash);
        assertEquals(null,hash.get("Peñarol"));
    }
    
    @Test
    public void testEliminarDosNul() {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("Felipe","Mestre");
        hash.put("Peñarol", null);
        hash.put("Jorge", null);
        Metodos.eliminarNulls(hash);
        assertEquals(null,hash.get("Peñarol"));
        assertEquals(null,hash.get("Jorge"));
    }
    
    @Test
    public void testEliminarTresNul() {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("Felipe",null);
        hash.put("Peñarol", null);
        hash.put("Jorge", null);
        Metodos.eliminarNulls(hash);
        assertEquals(0,hash.size());
    }

    @Test
    public void testIntercambiarClaves() throws Exception {
        HashMap<String,String> hash = new HashMap<>();
        hash.put("Felipe","Mestre");
        hash.put("Nacional", "ElMasGrande");
        hash.put("Jorge", "Piñeyrua");
        hash.put("Pink", "Floyd");
        
        HashMap<String,String> hashDadoVuelta = Metodos.intercambiarClaves(hash);
        assertEquals("Felipe",hashDadoVuelta.get("Mestre"));
        assertEquals("Nacional",hashDadoVuelta.get("ElMasGrande"));
        assertEquals("Jorge",hashDadoVuelta.get("Piñeyrua"));
        assertEquals("Pink",hashDadoVuelta.get("Floyd"));
    }

    @Test
    public void testImprimirClavesOrdenadas() {
        Metodos.imprimirClavesOrdenadas("test/PD3/stairway.txt");        
    }

    @Test
    public void testImprimirDeFormaAleatoria() {
        System.out.println("Probar en main");
    }
    
}
