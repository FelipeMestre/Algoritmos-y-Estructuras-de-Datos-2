package UT6.TA2;

public class TClasificador implements IClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;

    public static void main(String args[]) {
        IClasificador clasificador = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

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
        clasificador.clasificar(vectorAleatorio, 1);
        long finInsercionAleatorio300 = System.nanoTime();

        long inicioInsercionAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente, 1);
        long finInsercionAscendente300 = System.nanoTime();

        long inicioInsercionDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente, 1);
        long finInsercionDescendente300 = System.nanoTime();

        System.out.println("Inserción 300 aleatorio " + (finInsercionAleatorio300 - inicioInsercionAleatorio300));
        System.out.println("Inserción 300 ascendente " + (finInsercionAscendente300 - inicioInsercionAscendente300));
        System.out.println("Inserción 300 descendente " + (finInsercionDescendente300 - inicioInsercionDescendente300));

        /*SHELLSORT*/
        System.out.println("SHELLSORT");
        long inicioShellsortAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio, 2);
        long finShellsortAleatorio300 = System.nanoTime();

        long inicioShellsortAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente, 2);
        long finShellsortAscendente300 = System.nanoTime();

        long inicioShellsortDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente, 2);
        long finShellsortDescendente300 = System.nanoTime();

        System.out.println("Shellsort 300 aleatorio " + (finShellsortAleatorio300 - inicioShellsortAleatorio300));
        System.out.println("Shellsort 300 ascendente " + (finShellsortAscendente300 - inicioShellsortAscendente300));
        System.out.println("Shellsort 300 descendente " + (finShellsortDescendente300 - inicioShellsortDescendente300));

        /*BURBUJA*/
        System.out.println("BURBUJA");
        long inicioBurbujaAleatorio300 = System.nanoTime();
        clasificador.clasificar(vectorAleatorio, 3);
        long finBurbujaAleatorio300 = System.nanoTime();

        long inicioBurbujaAscendente300 = System.nanoTime();
        clasificador.clasificar(vectorAscendente, 3);
        long finBurbujaAscendente300 = System.nanoTime();

        long inicioBurbujaDescendente300 = System.nanoTime();
        clasificador.clasificar(vectorDescendente, 3);
        long finBurbujaDescendente300 = System.nanoTime();

        System.out.println("Burbuja 300 aleatorio " + (finBurbujaAleatorio300 - inicioBurbujaAleatorio300));
        System.out.println("Burbuja 300 ascendente " + (finBurbujaAscendente300 - inicioBurbujaAscendente300));
        System.out.println("Burbuja 300 descendente " + (finBurbujaDescendente300 - inicioBurbujaDescendente300));

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
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
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
        // Implementar m�todo aqu�
        return null;
    }

    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
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
            int pivote = posicionPivote;
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
                quicksort(entrada, i, izquierda);
            }
            if (izquierda < j) {
                quicksort(entrada, derecha, j);
            }
        }
    }
    private int encuentraPivote(int izq, int der) {
        if (izq == der) {
            return -1;
        }
        return ((izq + der) / 2);
    }

}
