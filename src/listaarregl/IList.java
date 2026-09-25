package listaarregl;

import java.util.Iterator;

public interface IList <T> {
    public void  append(T elemento) throws ListExcepciom;
    public void insert(T elemento, int index)throws ListExcepciom;
    public T remove(int index)throws ListExcepciom;
    public boolean removeObj(T elemento)throws ListExcepciom;
    public int indexOf(T elemento);
    public T get(int index) throws ListExcepciom;
    public void set(T elemento, int index)throws ListExcepciom;
    public void clear();
    public boolean empty();
    public int size();
    public Iterator<T> Iterator();
}
