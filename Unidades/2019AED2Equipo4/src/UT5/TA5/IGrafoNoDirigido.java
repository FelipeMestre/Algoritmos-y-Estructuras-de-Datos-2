package UT5.TA5;


import java.util.Collection;
import java.util.Map;

public interface IGrafoNoDirigido {

    public Collection <TVertice> bea();
     public Collection <TVertice> bea(Comparable etiquetaOrigen);
    public numBaconAmplitud Prim();

    public numBaconAmplitud Kruskal();
}
