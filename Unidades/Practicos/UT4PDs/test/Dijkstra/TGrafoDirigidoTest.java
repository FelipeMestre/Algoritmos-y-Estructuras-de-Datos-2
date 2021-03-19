/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package Dijkstra;

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

    public TGrafoDirigidoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    TGrafoDirigido grafoDijkstraCincoVertices;
    TGrafoDirigido grafoDijkstraCuatroVertices;
    TGrafoDirigido grafoDijkstraTresVertices;
    TGrafoDirigido grafoDijkstraDosVertices;

    @Before
    public void setUp() {
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");

        TArista a1 = new TArista("a", "b", 1);
        TArista a2 = new TArista("a", "c", 2);
        TArista a3 = new TArista("a", "d", 7);
        TArista a4 = new TArista("b", "a", 7);
        TArista a5 = new TArista("b", "c", 1);
        TArista a6 = new TArista("b", "d", 2);
        TArista a7 = new TArista("c", "d", 3);
        TArista a8 = new TArista("e", "b", 2);
        TArista a9 = new TArista("e", "d", 8);
        TArista a10 = new TArista("d", "a", 6);
        TArista a11 = new TArista("d", "c", 4);
        TArista a12 = new TArista("d", "e", 4);

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

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);

        grafoDijkstraCincoVertices = new TGrafoDirigido(cincoVertices, aristas);
        grafoDijkstraCuatroVertices = new TGrafoDirigido(cuatroVertices, aristas);
        grafoDijkstraTresVertices = new TGrafoDirigido(tresVertices, aristas);
        grafoDijkstraDosVertices = new TGrafoDirigido(dosVertices, aristas);

    }

    @After
    public void tearDown() {
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");

        TArista a1 = new TArista("a", "b", 1);
        TArista a2 = new TArista("a", "c", 2);
        TArista a3 = new TArista("a", "d", 7);
        TArista a4 = new TArista("b", "a", 7);
        TArista a5 = new TArista("b", "c", 1);
        TArista a6 = new TArista("b", "d", 2);
        TArista a7 = new TArista("c", "d", 3);
        TArista a8 = new TArista("e", "b", 2);
        TArista a9 = new TArista("e", "d", 8);
        TArista a10 = new TArista("d", "a", 6);
        TArista a11 = new TArista("d", "c", 4);
        TArista a12 = new TArista("d", "e", 4);

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

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);

        grafoDijkstraCincoVertices = new TGrafoDirigido(cincoVertices, aristas);
        grafoDijkstraCuatroVertices = new TGrafoDirigido(cuatroVertices, aristas);
        grafoDijkstraTresVertices = new TGrafoDirigido(tresVertices, aristas);
        grafoDijkstraDosVertices = new TGrafoDirigido(dosVertices, aristas);
    }

    @Test
    public void dijkstraTestCincoVertices() {
        Double[] dijkstraConA = grafoDijkstraCincoVertices.dijkstra("a");
        Double[] dijkstraConB = grafoDijkstraCincoVertices.dijkstra("b");
        Double[] dijkstraConC = grafoDijkstraCincoVertices.dijkstra("c");
        Double[] dijkstraConD = grafoDijkstraCincoVertices.dijkstra("d");
        Double[] dijkstraConE = grafoDijkstraCincoVertices.dijkstra("e");

        assertEquals(0.0, dijkstraConA[0], 0);
        assertEquals(1.0, dijkstraConA[1], 0);
        assertEquals(2.0, dijkstraConA[2], 0);
        assertEquals(3.0, dijkstraConA[3], 0);
        assertEquals(7.0, dijkstraConA[4], 0);

        assertEquals(7.0, dijkstraConB[0], 0);
        assertEquals(0.0, dijkstraConB[1], 0);
        assertEquals(1.0, dijkstraConB[2], 0);
        assertEquals(2.0, dijkstraConB[3], 0);
        assertEquals(6.0, dijkstraConB[4], 0);

        assertEquals(9.0, dijkstraConC[0], 0);
        assertEquals(9.0, dijkstraConC[1], 0);
        assertEquals(0.0, dijkstraConC[2], 0);
        assertEquals(3.0, dijkstraConC[3], 0);
        assertEquals(7.0, dijkstraConC[4], 0);

        assertEquals(6.0, dijkstraConD[0], 0);
        assertEquals(6.0, dijkstraConD[1], 0);
        assertEquals(4.0, dijkstraConD[2], 0);
        assertEquals(0.0, dijkstraConD[3], 0);
        assertEquals(4.0, dijkstraConD[4], 0);

        assertEquals(9.0, dijkstraConE[0], 0);
        assertEquals(2.0, dijkstraConE[1], 0);
        assertEquals(3.0, dijkstraConE[2], 0);
        assertEquals(4.0, dijkstraConE[3], 0);
        assertEquals(0.0, dijkstraConE[4], 0);
    }

    @Test
    public void dijkstraTestCuatroVertices() {
        Double[] dijkstraConA = grafoDijkstraCuatroVertices.dijkstra("a");
        Double[] dijkstraConB = grafoDijkstraCuatroVertices.dijkstra("b");
        Double[] dijkstraConC = grafoDijkstraCuatroVertices.dijkstra("c");
        Double[] dijkstraConD = grafoDijkstraCuatroVertices.dijkstra("d");

        assertEquals(0.0, dijkstraConA[0], 0);
        assertEquals(1.0, dijkstraConA[1], 0);
        assertEquals(2.0, dijkstraConA[2], 0);
        assertEquals(3.0, dijkstraConA[3], 0);

        assertEquals(7.0, dijkstraConB[0], 0);
        assertEquals(0.0, dijkstraConB[1], 0);
        assertEquals(1.0, dijkstraConB[2], 0);
        assertEquals(2.0, dijkstraConB[3], 0);

        assertEquals(9.0, dijkstraConC[0], 0);
        assertEquals(10.0, dijkstraConC[1], 0);
        assertEquals(0.0, dijkstraConC[2], 0);
        assertEquals(3.0, dijkstraConC[3], 0);

        assertEquals(6.0, dijkstraConD[0], 0);
        assertEquals(7.0, dijkstraConD[1], 0);
        assertEquals(4.0, dijkstraConD[2], 0);
        assertEquals(0.0, dijkstraConD[3], 0);

    }

    @Test
    public void dijkstraTestTresVertices() {
        Double[] dijkstraConA = grafoDijkstraTresVertices.dijkstra("a");
        Double[] dijkstraConB = grafoDijkstraTresVertices.dijkstra("b");
        Double[] dijkstraConC = grafoDijkstraTresVertices.dijkstra("c");

        assertEquals(0.0, dijkstraConA[0], 0);
        assertEquals(1.0, dijkstraConA[1], 0);
        assertEquals(2.0, dijkstraConA[2], 0);

        assertEquals(7.0, dijkstraConB[0], 0);
        assertEquals(0.0, dijkstraConB[1], 0);
        assertEquals(1.0, dijkstraConB[2], 0);

        assertEquals(Double.MAX_VALUE, dijkstraConC[0], 0);
        assertEquals(Double.MAX_VALUE, dijkstraConC[1], 0);
        assertEquals(0.0, dijkstraConC[2], 0);

    }
    
    @Test
    public void dijkstraTestDosVertices() {
        Double[] dijkstraConA = grafoDijkstraDosVertices.dijkstra("a");
        Double[] dijkstraConB = grafoDijkstraDosVertices.dijkstra("b");

        assertEquals(0.0, dijkstraConA[0], 0);
        assertEquals(1.0, dijkstraConA[1], 0);

        assertEquals(7.0, dijkstraConB[0], 0);
        assertEquals(0.0, dijkstraConB[1], 0);

    }

}
