/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

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
public class TGrafoAerolineaTest {
    
    public TGrafoAerolineaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    TGrafoAerolinea grafoBacon;
    
    @Before
    public void setUp(){
        TVertice bacon1 = new TVertice("Kevin_Bacon");
        TVertice bacon2 = new TVertice("Ayudante1");
        TVertice bacon3 = new TVertice("Ayudante2");
        TVertice bacon4 = new TVertice("Ayudante3");
        TVertice bacon5 = new TVertice("Ayudante4");
        TVertice bacon6 = new TVertice("Ayudante5");
        
        TArista arista1 = new TArista(bacon1.getEtiqueta(), bacon2.getEtiqueta(), 0);
        TArista arista2 = new TArista(bacon2.getEtiqueta(), bacon3.getEtiqueta(), 0);
        TArista arista3 = new TArista(bacon2.getEtiqueta(), bacon4.getEtiqueta(), 0);
        TArista arista4 = new TArista(bacon4.getEtiqueta(), bacon5.getEtiqueta(), 0);
        TArista arista5 = new TArista(bacon5.getEtiqueta(), bacon6.getEtiqueta(), 0);
        TArista arista6 = new TArista(bacon2.getEtiqueta(), bacon6.getEtiqueta(), 0);
        
        LinkedList<TVertice> verticesBacon = new LinkedList<>();
        verticesBacon.add(bacon1);
        verticesBacon.add(bacon2);
        verticesBacon.add(bacon3);
        verticesBacon.add(bacon4);
        verticesBacon.add(bacon5);
        verticesBacon.add(bacon6);
        
        LinkedList<TArista> aristasBacon = new LinkedList<>();
        aristasBacon.add(arista1);
        aristasBacon.add(arista2);
        aristasBacon.add(arista3);
        aristasBacon.add(arista4);
        aristasBacon.add(arista5);
        aristasBacon.add(arista6);
        
        
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

        grafoBacon = new TGrafoAerolinea(verticesBacon, aristasBacon);
    }
    
    @After
    public void tearDown() {
        
        TVertice bacon1 = new TVertice("Kevin_Bacon");
        TVertice bacon2 = new TVertice("Ayudante1");
        TVertice bacon3 = new TVertice("Ayudante2");
        TVertice bacon4 = new TVertice("Ayudante3");
        TVertice bacon5 = new TVertice("Ayudante4");
        TVertice bacon6 = new TVertice("Ayudante5");
        
        TArista arista1 = new TArista(bacon1.getEtiqueta(), bacon2.getEtiqueta(), 0);
        TArista arista2 = new TArista(bacon2.getEtiqueta(), bacon3.getEtiqueta(), 0);
        TArista arista3 = new TArista(bacon2.getEtiqueta(), bacon4.getEtiqueta(), 0);
        TArista arista4 = new TArista(bacon4.getEtiqueta(), bacon5.getEtiqueta(), 0);
        TArista arista5 = new TArista(bacon5.getEtiqueta(), bacon6.getEtiqueta(), 0);
        TArista arista6 = new TArista(bacon2.getEtiqueta(), bacon6.getEtiqueta(), 0);
        
        LinkedList<TVertice> verticesBacon = new LinkedList<>();
        verticesBacon.add(bacon1);
        verticesBacon.add(bacon2);
        verticesBacon.add(bacon3);
        verticesBacon.add(bacon4);
        verticesBacon.add(bacon5);
        verticesBacon.add(bacon6);
        
        LinkedList<TArista> aristasBacon = new LinkedList<>();
        aristasBacon.add(arista1);
        aristasBacon.add(arista2);
        aristasBacon.add(arista3);
        aristasBacon.add(arista4);
        aristasBacon.add(arista5);
        aristasBacon.add(arista6);
        
        grafoBacon = new TGrafoAerolinea(verticesBacon, aristasBacon);
    }

    @Test
    public void testMenosEscalasSeisVertices() {
        //Se adapataron los tests de kevin bacon, siempre deberia dar el camino con menos intermediarios
        //El tamaño de la lista de escalas seria uno mas el numero de kevin bacon, dado que se agrega el inicio
        
        //la lista contiene solo a bacon
        assertEquals(1, grafoBacon.menosEscalas("Kevin_Bacon","Kevin_Bacon").size());
        
        //La lista no contiene nada puesto que no existe origen ni destino
        assertEquals(0, grafoBacon.menosEscalas("Nada","Algo").size());
        
        //La lista contiene a kevin y a ayudante 1.
        assertEquals(2, grafoBacon.menosEscalas("Kevin_Bacon","Ayudante1").size()); 
        
        //La lista contiene a bacon, ayudante uno y dos
        assertEquals(3, grafoBacon.menosEscalas("Kevin_Bacon","Ayudante2").size());
        
        //La lista contiene a bacon, ayudantes uno y tres
        assertEquals(3, grafoBacon.menosEscalas("Kevin_Bacon","Ayudante3").size());
        
        //La lista contiene a bacon, ayudantes 1,3 y 4
        assertEquals(4, grafoBacon.menosEscalas("Kevin_Bacon","Ayudante4").size());
        
        //La lista contiene a bacon, ayudantes 1 y 5
        assertEquals(3, grafoBacon.menosEscalas("Kevin_Bacon","Ayudante5").size());
    }
    
    
    
}
