public interface BlockingQueue<T> {

    void tryEnqueue(T elem, int time);

    T tryDequeue(int time);

    int size();
}
