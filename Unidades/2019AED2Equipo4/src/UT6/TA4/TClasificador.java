package UT6.TA4;

import java.util.ArrayList;

public class TClasificador implements IClasificador {

    public static final int METODO_CLASIFICACION_INSERCION_DIRECTA = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;
    public static final int METODO_CLASIFICACION_PorSeleccion = 6;

    public static void main(String args[]) {
        IClasificador clasificador = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios(300);
        int[] vectorAscendente = gdg.generarDatosAscendentes(300);
        int[] vectorDescendente = gdg.generarDatosDescendentes(300);

//		int[] resAleatorio = clasificador.clasificar(vectorAleatorio,
//				METODO_CLASIFICACION_INSERCION);
//		for (int i = 0; i < resAleatorio.length; i++) {
//			//System.out.println(resAleatorio[i] + " ");
//		}
//		int[] resAscendente = clasificador.clasificar(vectorAscendente,
//				METODO_CLASIFICACION_INSERCION);
//		for (int i = 0; i < resAscendente.length; i++) {
//			//System.out.println(resAscendente[i] + " ");
//		}
//		int[] resDescendente = clasificador.clasificar(vectorDescendente,
//				METODO_CLASIFICACION_INSERCION);
//		for (int i = 0; i < resDescendente.length; i++) {
//			//System.out.println(resDescendente[i] + " ");
//		}
        /*INSERCION DIRECTA*/
        System.out.println("INSERCION DIRECTA");
        long inicioInsercionAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio.clone(), 1);
        long finInsercionAleatorio300 = System.nanoTime();

        long inicioInsercionAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente.clone(), 1);
        long finInsercionAscendente300 = System.nanoTime();

        long inicioInsercionDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente.clone(), 1);
        long finInsercionDescendente300 = System.nanoTime();

        System.out.println("Inserción 300 aleatorio " + (finInsercionAleatorio300 - inicioInsercionAleatorio300));
        System.out.println("Inserción 300 ascendente " + (finInsercionAscendente300 - inicioInsercionAscendente300));
        System.out.println("Inserción 300 descendente " + (finInsercionDescendente300 - inicioInsercionDescendente300));

        /*SHELLSORT*/
        System.out.println("SHELLSORT");
        long inicioShellsortAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio.clone(), 2);
        long finShellsortAleatorio300 = System.nanoTime();

        long inicioShellsortAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente.clone(), 2);
        long finShellsortAscendente300 = System.nanoTime();

        long inicioShellsortDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente.clone(), 2);
        long finShellsortDescendente300 = System.nanoTime();

        System.out.println("Shellsort 300 aleatorio " + (finShellsortAleatorio300 - inicioShellsortAleatorio300));
        System.out.println("Shellsort 300 ascendente " + (finShellsortAscendente300 - inicioShellsortAscendente300));
        System.out.println("Shellsort 300 descendente " + (finShellsortDescendente300 - inicioShellsortDescendente300));

        /*BURBUJA*/
        System.out.println("BURBUJA");
        long inicioBurbujaAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio.clone(), 3);
        long finBurbujaAleatorio300 = System.nanoTime();

        long inicioBurbujaAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente.clone(), 3);
        long finBurbujaAscendente300 = System.nanoTime();

        long inicioBurbujaDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente.clone(), 3);
        long finBurbujaDescendente300 = System.nanoTime();
        System.out.println("Burbuja 300 aleatorio " + (finBurbujaAleatorio300 - inicioBurbujaAleatorio300));
        System.out.println("Burbuja 300 ascendente " + (finBurbujaAscendente300 - inicioBurbujaAscendente300));
        System.out.println("Burbuja 300 descendente " + (finBurbujaDescendente300 - inicioBurbujaDescendente300));

        /*Heapsort*/
        System.out.println("Heapsort");
        long inicioheapsortAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio.clone(), 5);
        long finheapsortAleatorio300 = System.nanoTime();

        long inicioheasortAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente.clone(), 5);
        long finheapsortAscendente300 = System.nanoTime();

        long inicioheapsortDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente.clone(), 5);
        long finheapsortDescendente300 = System.nanoTime();

        System.out.println("heapsort 300 aleatorio " + (finheapsortAleatorio300 - inicioheapsortAleatorio300));
        System.out.println("heapsort 300 ascendente " + (finheapsortAscendente300 - inicioheasortAscendente300));
        System.out.println("heapsort 300 descendente " + (finheapsortDescendente300 - inicioheapsortDescendente300));

        System.out.println("PorSeleccion");
        long inicioseleccionAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio.clone(), 6);
        long finseleccionAleatorio300 = System.nanoTime();

        long inicioseleccionAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente.clone(), 6);
        long finseleccionAscendente300 = System.nanoTime();

        long inicioseleccionDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente.clone(), 6);
        long finseleccionDescendente300 = System.nanoTime();

        System.out.println("heapsort 300 aleatorio " + (finseleccionAleatorio300 - inicioseleccionAleatorio300));
        System.out.println("heapsort 300 ascendente " + (finseleccionAscendente300 - inicioseleccionAscendente300));
        System.out.println("heapsort 300 descendente " + (finseleccionDescendente300 - inicioseleccionDescendente300));

        for (int i = 0; i < vectorAleatorio.length; i++) {
            System.out.println(vectorAleatorio[i]);
        }

    }

    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_PorSeleccion:
                return ordenarPorSeleccion(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION_DIRECTA:
                if (cascara) {
                    return usarCascara(datosParaClasificar);
                } else {
                    return ordenarPorInsercion(datosParaClasificar);
                }
            case METODO_CLASIFICACION_SHELL:
                if (cascara) {
                    return usarCascara(datosParaClasificar);
                } else {
                    return ordenarPorShell(datosParaClasificar);
                }
            case METODO_CLASIFICACION_BURBUJA:
                if (cascara) {
                    return usarCascara(datosParaClasificar);
                } else {
                    return ordenarPorBurbuja(datosParaClasificar);
                }
            case METODO_CLASIFICACION_QUICKSORT:
                if (cascara) {
                    return usarCascara(datosParaClasificar);
                } else {
                    return ordenarPorQuickSort(datosParaClasificar);
                }
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    protected int[] usarCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    protected int[] ordenarPorInsercionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j
                                + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                            j = j - inc;
                        } else {
                            j = -1;
                        }

                    }
                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        //  datosParaClasificar = null;
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    @Override
    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 0; i <= datosParaClasificar.length - 1; i++) {
                int indiceDelMenor = i;
                int claveMenor = datosParaClasificar[i];
                for (int j = i + 1; j < datosParaClasificar.length; j++) {
                    if (datosParaClasificar[j] < claveMenor) {
                        indiceDelMenor = j;
                        claveMenor = datosParaClasificar[j];
                    }
                }
                intercambiar(datosParaClasificar, i, indiceDelMenor);
            }
        }
        return datosParaClasificar;
    }

    @Override
    public int[] ordenarPorCuenta(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    @Override
    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = encuentraPivote(izquierda, derecha);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                quicksort(entrada, i, derecha);
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j);
            }
        }
    }

    private int encuentraPivote(int izq, int der) {
        if (izq == der) {
            return -1;
        }
        return ((izq + der) / 2);
    }

    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { //r tiene un hijo solo
                    if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                        r = r * 2;

                    } else {
                        r = ultimo;
                    }

                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] > datosParaClasificar[2 * r + 1]) {
                        posicionIntercambio = 2 * r;
                    } else {
                        posicionIntercambio = 2 * r + 1;
                    }
                    if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }
     protected int[] ordenarPorCuenta(int[] datosParaClasificar, int maximo) {
        int[] cuenta = new int[maximo + 1];
        for (int i = 0; i < datosParaClasificar.length; i++) {
            cuenta[datosParaClasificar[i]]++;
        }
        for (int i = 1; i < maximo + 1; i++) {
            cuenta[i] += cuenta[i - 1];
        }
        int[] salida = new int[datosParaClasificar.length];
        for (int i = datosParaClasificar.length - 1; i >= 0; i--) {
            int j = cuenta[datosParaClasificar[i]] - 1;
            salida[j] = datosParaClasificar[i];
            cuenta[datosParaClasificar[i]]--;
        }
        return salida;
    }
    protected int[] ordenarPorBinsort(int[] datosParaClasificar) {
        int max = maximo(datosParaClasificar);
        int cifrasMax = numeroDeCifras(max);
        return binsort(datosParaClasificar, cifrasMax, false);
    }

    private int[] binsort(int[] datosParaClasificar, int cifrasMax, boolean radix) {
        ArrayList<Integer>[] urnas = new ArrayList[10];
        for (int i = 0; i < urnas.length; i++) {
            urnas[i] = new ArrayList<>();
        }
        for (int i = 0; i < datosParaClasificar.length; i++) {
            urnas[digitoEnPosicion(datosParaClasificar[i], cifrasMax)].add(datosParaClasificar[i]);
        }
        int ultimaPosicion = 0;
        for (int i = 0; i < 10; i++) {
            Integer[] urna = urnas[i].toArray(new Integer[urnas[i].size()]);
            int[] urnaOrdenada = new int[urna.length];
            for (int k = 0; k < urna.length; k++) {
                urnaOrdenada[k] = urna[k];
            }
            if (!radix) {
                urnaOrdenada = ordenarPorInsercion(urnaOrdenada);
            }
            urnas[i].clear();
            for (int j = 0; j < urnaOrdenada.length; j++) {
                datosParaClasificar[ultimaPosicion] = urnaOrdenada[j];
                ultimaPosicion++;
            }
        }
        return datosParaClasificar;
    }

    private int digitoEnPosicion(int n, int pos) {
        int a = n % (int) Math.pow(10, pos);
        int x = (int) Math.pow(10, pos - 1);
        if (a < x) {
            return 0;
        }
        while (a >= 10) {
            a = a / 10;
        }
        return a;
    }

    private int maximo(int[] datos) {
        int max = Integer.MIN_VALUE;
        for (int i : datos) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int numeroDeCifras(int i) {
        return (int) (Math.log10(i) + 1);
    }

    protected int[] ordenarPorRadixsort(int[] datosParaClasificar) {
        int max = maximo(datosParaClasificar);
        int cifrasMax = numeroDeCifras(max);
        for (int i = 1; i <= cifrasMax; i++) {
            datosParaClasificar = binsort(datosParaClasificar, i, true);
        }
        return datosParaClasificar;
    }

}
