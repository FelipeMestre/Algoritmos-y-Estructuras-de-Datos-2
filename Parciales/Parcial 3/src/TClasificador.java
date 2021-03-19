/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */

/**
 *
 * @author estudiante.fit
 */
public class TClasificador {
    public Comparable[] ordenarPorHeapSort(Comparable[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    private void armaHeap(Comparable[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { //r tiene un hijo solo
                    if (datosParaClasificar[r].compareTo(datosParaClasificar[r * 2]) < 0) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                        r *= 2;
                    } else {
                        r = ultimo;
                    }
                } else { //r tiene 2 hijos
                    int posicionIntercambio;
                    if (datosParaClasificar[2 * r].compareTo(datosParaClasificar[2 * r + 1]) < 0) {
                        posicionIntercambio = 2 * r + 1;
                    } else {
                        posicionIntercambio = 2 * r;
                    }
                    if (datosParaClasificar[r].compareTo(datosParaClasificar[posicionIntercambio]) < 0) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }
    
    private void intercambiar(Comparable[] vector, int pos1, int pos2) {
        Comparable temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }
    
}
