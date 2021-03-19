
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instanciar autos del ecommerce leyendo del archivo.
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/autos.csv", true);
        int i = 0;
        Automovil[] autos = new Automovil[lineas.length + 1];
        for(String linea : lineas) {
            try {
                Automovil car = new Automovil(linea);
                if (car.isValid()) {
                    autos[i] = car;
                    i += 1;
                    
                    // Agregar el auto a una colección del tipo apropiado.    
                }
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Automovil[] autosValidos = new Automovil[i];
        for (int j = 0; j < i; j++) {
            autosValidos[j] = autos[j];
        }
        System.out.println("Se cargaron " + (i) + " autos");
        
        String[] aEscribir = new String[i - 1];
        TClasificador clasificador = new TClasificador();
        clasificador.ordenarPorHeapSort(autosValidos);
        for (int z = 0; z < autosValidos.length - 1; z++) {
            aEscribir[z] = (autosValidos[z].getMarca() + "," + autosValidos[z].getHp() +","+ autosValidos[z].getPrecio());
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/informe_autos.txt", aEscribir);
        
        
        
    }
}
