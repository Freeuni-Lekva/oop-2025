import java.util.Collection;

public class MyStack<T> {

    private Object[] elements;

    private int logLen;

    public MyStack() {
        elements = new Object[8];
        logLen = 0;
    }

    public void add(T element) {
        if (logLen == elements.length) {
            grow();
        }
        elements[logLen++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (logLen == 0) {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        return (T) elements[--logLen];
    }

    public void addAll(Collection<T> elements) {
        for (T element : elements) {
            add(element);
        }
    }

    public int size() {
        return logLen;
    }

    private void grow() {
        Object[] newElements = new Object[2 * elements.length];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

}
