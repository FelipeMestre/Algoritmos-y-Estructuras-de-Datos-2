package UT5.TA3;


import java.util.Collection;
import java.util.Map;

public interface IGrafoNoDirigido {

    public Collection <TVertice> bea();
     public Collection <TVertice> bea(Comparable etiquetaOrigen);
    public TGrafoNoDirigido prim();

    public TGrafoNoDirigido kruskal();
}
