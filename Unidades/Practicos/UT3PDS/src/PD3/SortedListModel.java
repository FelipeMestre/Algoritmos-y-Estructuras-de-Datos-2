/*
 * Creado por Felipe Mestre
 * Email: feli13mestre@gmail.com
 * Universidad Catolica del Uruguay, Ingenieria en Informatica
 */
package PD3;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.AbstractListModel;

/**
 *
 * @author estudiante.fit
 */
public class SortedListModel extends AbstractListModel{

    private SortedSet set;
    
    public SortedListModel(){
        this.set = new TreeSet();
    }
    
    @Override
    public int getSize() {
        return set.size();
    }

    @Override
    public Object getElementAt(int index) {
        throw new UnsupportedOperationException("caca");
    }
    
    public void add(Object element){
        set.add(element);
    }
    
    public void addAll(Object[] elements){
        for (Object element : elements) {
            set.add(element);
        }
    }
    
    public void clear(){
        set.clear();
    }
    
    public boolean contains(Object element){
        return set.contains(element);
    }
    
    public Object firstElement(){
        return set.first();
    }
    
    public Object getElement(int position){
        Object[] array = set.toArray();
        int contador = 0;
        for (Object element : array) {
            if (contador == position) {
                return element;
            }
            contador ++;
        }
        return null;
    }
    
    public Iterator iterator(){
        return set.iterator();
    }
    
    public Object lastElement(){
        return set.last();
    }
    
    public boolean remove(Object element){
        if (set.contains(element)) {
            set.remove(element);
            return true;
        } else {
             return false;
        }
    }
    
    
}
