package listaarregl;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList<T> implements IList<T>, Iterable<T>{

    protected int nElements;
    private final int tamLista;
    private final T lista[];
    
    public ArrayList(Class<T> tipoDato, int tamLista){
        this.tamLista = tamLista;
        nElements = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
        
    }

    @Override
    public java.util.Iterator<T> Iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private class ListIterator <T> implements Iterator <T>{
    private int actual = 0;

        @Override
        public boolean hasNext() {
return actual < nElements;
        }

        @Override
        public T next() {
return (T)lista[actual++];
        }
    
    }
    
    @Override
    public void append(T elemento) {
        if(nElements>=tamLista){
            throw new ListExcepciom("Lista llena");
        }
        lista[nElements] = elemento;
        nElements++;
    }

    @Override
    public void insert(T elemento, int index) throws ListExcepciom{
    if (nElements >= tamLista){
        throw new ListExcepciom("Lista llena");
    }
    if (index < 0 || index > nElements){
        throw new ListExcepciom("Indice fuera de limite");
    }
    for (int j = nElements;j>index;j--){
        lista [j] = lista [j-1];
    }
    lista [index] = elemento;
    nElements++;
    }

    @Override
    public T remove(int index) throws ListExcepciom {
        T o = get(index);
        for (int j = index; j < nElements -1; j++){
            lista [j] = lista [j+1];
    }
        nElements--;
        return o;
    }

    @Override
    public boolean removeObj(T elemento) throws ListExcepciom {
    for (int i = 0; i < nElements; i++) {
        if (lista[i].equals(elemento)) {
     for (int j = i; j < nElements - 1; j++) {
                lista[j] = lista[j + 1];
            }
            lista[nElements - 1] = null;
            nElements--;
            return true;
         }
    }
        throw new ListExcepciom("El elemento no ha sido encontrado");
    }

    @Override
    public int indexOf(T elemento) {
    for (int i = 0; i < nElements; i++) {
        if (lista[i].equals(elemento)) {
            return i;
        }
    }
    return -1;
}
    
   @Override
public T get(int index) throws ListExcepciom {
    if (empty()) {
        throw new ListExcepciom("Lista Vacia");
    }
    if (index < 0 || index >= nElements) {
        throw new ListExcepciom("Indice fuera de limites");
    }
    return lista[index];
}

    @Override
    public void set(T elemento, int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
          for (int i = 0; i < nElements; i++) {
        lista[i] = null;
    }
    nElements = 0;
}

    @Override
    public boolean empty() {
        return nElements == 0;
    }

    @Override
    public int size() {
        return nElements;
        }


    @Override
    public java.util.Iterator<T> iterator() {
     return new ListIterator();
    }

    @Override
    public String toString(){
        String s = "[";
        for (int i = 0; i < nElements;i++){
            s += lista [i];
            if (i<nElements -1) s+=", ";
    }
    s+="]";
    return s;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
