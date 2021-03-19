package ut10.clasesCatedra;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EjemploTest {
	private int[] vectorPrueba;
	private int tamanio = 30000;
	private IClasificador tc;

	@Before
	public void init() {
		IGeneradorDatos gen = new GeneradorDatosGenericos();
		vectorPrueba = gen.generarDatosAleatorios();
		tc = new TClasificador();
	}


	@Test
	public void testInserDirec() {
		int[] vectorResultado = tc.clasificar(vectorPrueba.clone(),
				IClasificador.METODO_CLASIFICACION_INSERCION);
	
		//Complete el test aquí:
		//
		// 
		//Validar que vectorResultado esta ordenado y en caso contrario hacer fail() del test.
		//
	}

	@Test
	public void testShell() {
		//
		//Complete el test aquí:
		//
	}

	@Test
	public void testBurbuja() {
		//
		//Complete el test aquí:
		//
	}

	@Test
	public void testQuiksort() {
		//
		//Complete el test aquí:
		//
	}

}
