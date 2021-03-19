/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package pd1;

/**
 *
 * @author estudiante.fit
 */
public class PD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolGenerico<String> ucu = new TArbolGenerico<>();
        ucu.insertar("Rectoria", "");
        ucu.insertar("Vicerrectoria Administrativa", "Rectoria");
        ucu.insertar("Vicerrectoria Academica", "Rectoria");
        ucu.insertar("Vicerrectoria del medio universitario", "Rectoria");
        
        ucu.insertar("Facultad de psicologia","Vicerrectoria Academica");
        ucu.insertar("Facultad de ingenieria y tecnologias","Vicerrectoria Academica");
        ucu.insertar("Facultad de ciencias humanas","Vicerrectoria Academica");
        ucu.insertar("Facultad de ciencias empresariales","Vicerrectoria Academica");
        
        ucu.insertar("Departamento de matematicas","Facultad de ingenieria y tecnologias");
        ucu.insertar("Departamento de ingenieria electrica","Facultad de ingenieria y tecnologias");
        ucu.insertar("Departamento de informatica y ciencias de la comunicacion","Facultad de ingenieria y tecnologias");
        
        //Busquedas con exito
        System.out.println("Busqueda 1");
        System.out.println(ucu.buscar("Departamento de matematicas").getEtiqueta());
        
        System.out.println("Busqueda 2");
        System.out.println(ucu.buscar("Departamento de informatica y ciencias de la comunicacion").getEtiqueta());
        //Hay más pruebas de busqueda en los test cases.
        
        //Busquedas sin exito
        System.out.println("Busqueda sin exito");
        System.out.println(ucu.buscar("asdf") == null);
        
        ucu.listarIdentado();
    }
}
