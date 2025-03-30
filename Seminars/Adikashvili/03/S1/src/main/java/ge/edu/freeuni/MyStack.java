package ge.edu.freeuni;

import java.util.Collection;

public class MyStack<T> {

    private Object[] elems;

    private int logLen;

    public MyStack() {
        elems = new Object[8];
        logLen = 0;
    }

    public void add(T element) {
        if (logLen == elems.length) {
            grow();
        }
        elems[logLen++] = element;
    }

    private void grow() {
        Object[] newElems = new Object[2 * elems.length];
        System.arraycopy(elems, 0, newElems, 0, elems.length);
        elems = newElems;
    }

    public T pop() {
        if (logLen == 0) {
            throw new IndexOutOfBoundsException("Empty stack!");
        }
        logLen--;
        T elem = (T) elems[logLen];
        return elem;
    }

    public void addAll(Collection<T> elements) {
        for (T elem : elements) {
            add(elem);
        }
    }

    public int size() {
        return logLen;
    }
}
