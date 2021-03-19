package UT6.TA4;;

import UT6.TA2.*;
import java.util.Random;
import java.util.Random;

public class GeneradorDatosGenericos implements IGeneradorDatos{
	private static int TAMANIO_MAX = 300;
        
	public int[] generarDatosAleatorios(int tamanio) {
		Random rnd = new Random();
		int[] datosGenerados = new int[tamanio];
		boolean[] datosUtilizados = new boolean[tamanio];
		for (int i = 0; i < datosGenerados.length; i++) {
			int j = rnd.nextInt(tamanio);
			while(datosUtilizados[j]){
				j = (j + 1) % tamanio;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}
	
	public int[] generarDatosAscendentes(int tamanio) {
		int [] copiaAscendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}
	
	public int[] generarDatosDescendentes(int tamanio) {
		int [] copiaDescendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaDescendente[i] = tamanio - i;
		}
		return copiaDescendente;
	}
	
}
