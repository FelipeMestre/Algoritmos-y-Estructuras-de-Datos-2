/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

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
public class TClasificadorTest {
    
    public TClasificadorTest() {
    }
    
    
    // Muchos repetidos
    // Ordenado ascendiente
    // Ordenado descendiente
    // Aleatorios
    // Todos Iguales
    // Datos consecutivos desordenados
    // Datos consecutivos ordenados de manera ascendente
    // Datos consecutivos ordenados de manera descendente
    private Comparable[] muchosRepetidos;
    private Comparable[] ordenadoAscendentes;
    private Comparable[] ordenadoDescendentes;
    private Comparable[] datosAleatorios;
    private Comparable[] datosIguales;
    private Comparable[] datosConsecutivos;
    private Comparable[] datosConsecutivosAscendentes;
    private Comparable[] datosConsecutivosDescendentes;
    private TClasificador clasificador;
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Comparable[] muchosRepetidosT = {5, 5, 1, 3, 10, 32, 32, 11, 11, 11, 10, 10, 45, 36};
        Comparable[] ordenadoAscendenteT = {5, 6, 7, 8, 9, 10, 25, 56, 79, 89, 10001, 233330, 45555556, 789455621};
        Comparable[] ordenadoDescendenteT = {789455621, 45555556, 233330, 10001, 89, 79, 56, 25, 10, 9, 8, 7, 6, 5};
        Comparable[] datosAleatoriosT = {892, 766, 822, 432, 472, 242, 200, 58, 739, 456};
        Comparable[] datosIgualesT = {1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899};
        Comparable[] datosConsecutivosT = {0, 3, 9, 5, 4, 1, 2, 7, 6, 8};
        Comparable[] datosConsecutivosAscendentesT = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Comparable[] datosConsecutivosDescendentesT = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        this.datosAleatorios = datosAleatoriosT;
        this.ordenadoAscendentes = ordenadoAscendenteT;
        this.ordenadoDescendentes = ordenadoDescendenteT;
        this.muchosRepetidos = muchosRepetidosT;
        this.datosIguales = datosIgualesT;
        this.datosConsecutivos = datosConsecutivosT;
        this.datosConsecutivosAscendentes = datosConsecutivosAscendentesT;
        this.datosConsecutivosDescendentes = datosConsecutivosDescendentesT;
        
        clasificador = new TClasificador();
    }

    @After
    public void tearDown() {
        Comparable[] muchosRepetidosT = {5, 5, 1, 3, 10, 32, 32, 11, 11, 11, 10, 10, 45, 36};
        Comparable[] ordenadoAscendenteT = {5, 6, 7, 8, 9, 10, 25, 56, 79, 89, 10001, 233330, 45555556, 789455621};
        Comparable[] ordenadoDescendenteT = {789455621, 45555556, 233330, 10001, 89, 79, 56, 25, 10, 9, 8, 7, 6, 5};
        Comparable[] datosAleatoriosT = {892, 766, 822, 432, 472, 242, 200, 58, 739, 456};
        Comparable[] datosIgualesT = {1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899, 1899};
        Comparable[] datosConsecutivosT = {0, 3, 9, 5, 4, 1, 2, 7, 6, 8};
        Comparable[] datosConsecutivosAscendentesT = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Comparable[] datosConsecutivosDescendentesT = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        this.datosAleatorios = datosAleatoriosT;
        this.ordenadoAscendentes = ordenadoAscendenteT;
        this.ordenadoDescendentes = ordenadoDescendenteT;
        this.muchosRepetidos = muchosRepetidosT;
        this.datosIguales = datosIgualesT;
        this.datosConsecutivos = datosConsecutivosT;
        this.datosConsecutivosAscendentes = datosConsecutivosAscendentesT;
        this.datosConsecutivosDescendentes = datosConsecutivosDescendentesT;
        
        clasificador = new TClasificador();
    }

    @Test
    public void testOrdenarPorHeapSortConRepetidos() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(muchosRepetidos);
        assertEquals(1, resultado[0]);
        assertEquals(3, resultado[1]);
        assertEquals(5, resultado[2]);
        assertEquals(5, resultado[3]);
        assertEquals(10, resultado[4]);
        assertEquals(10, resultado[5]);
        assertEquals(10, resultado[6]);
        assertEquals(11, resultado[7]);
        assertEquals(11, resultado[8]);
        assertEquals(11, resultado[9]);
        assertEquals(32, resultado[10]);
        assertEquals(32, resultado[11]);
        assertEquals(36, resultado[12]);
        assertEquals(45, resultado[13]);
    }
    
    @Test
    public void testOrdenarPorHeapSortOrdenadosAscendentes() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(ordenadoAscendentes);
        assertEquals(5, resultado[0]);
        assertEquals(6, resultado[1]);
        assertEquals(7, resultado[2]);
        assertEquals(8, resultado[3]);
        assertEquals(9, resultado[4]);
        assertEquals(10, resultado[5]);
        assertEquals(25, resultado[6]);
        assertEquals(56, resultado[7]);
        assertEquals(79, resultado[8]);
        assertEquals(89, resultado[9]);
        assertEquals(10001, resultado[10]);
        assertEquals(233330, resultado[11]);
        assertEquals(45555556, resultado[12]);
        assertEquals(789455621, resultado[13]);
    }

    @Test
    public void testOrdenarPorHeapSortOrdenadosDescendentes() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(ordenadoDescendentes);
        assertEquals(5, resultado[0]);
        assertEquals(6, resultado[1]);
        assertEquals(7, resultado[2]);
        assertEquals(8, resultado[3]);
        assertEquals(9, resultado[4]);
        assertEquals(10, resultado[5]);
        assertEquals(25, resultado[6]);
        assertEquals(56, resultado[7]);
        assertEquals(79, resultado[8]);
        assertEquals(89, resultado[9]);
        assertEquals(10001, resultado[10]);
        assertEquals(233330, resultado[11]);
        assertEquals(45555556, resultado[12]);
        assertEquals(789455621, resultado[13]);
    }

    @Test
    public void testOrdenarPorHeapSortDatosAleatorios() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(datosAleatorios);
        assertEquals(58, resultado[0]);
        assertEquals(200, resultado[1]);
        assertEquals(242, resultado[2]);
        assertEquals(432, resultado[3]);
        assertEquals(456, resultado[4]);
        assertEquals(472, resultado[5]);
        assertEquals(739, resultado[6]);
        assertEquals(766, resultado[7]);
        assertEquals(822, resultado[8]);
        assertEquals(892, resultado[9]);
    }

    @Test
    public void testOrdenarPorHeapSortDatosIguales() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(datosIguales);
        for (int i = 0; i < resultado.length; i++) {
            assertEquals(1899, resultado[i]);
        }
    }

    @Test
    public void testOrdenarPorHeapSortDatosConsecutivos() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(datosConsecutivos);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, resultado[i]);
        }
    }

    @Test
    public void testOrdenarPorHeapSortDatosConscutivosDescendentes(){
        Comparable[] resultado = clasificador.ordenarPorHeapSort(datosConsecutivosAscendentes);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, resultado[i]);
        }
    }

    @Test
    public void testOrdenarPorHeapSortConscutivosAscendentes() {
        Comparable[] resultado = clasificador.ordenarPorHeapSort(datosConsecutivosDescendentes);
        for (int i = 0; i < 10; i++) {
            assertEquals(i, resultado[i]);
        }
    }
}
