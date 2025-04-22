public interface BlockingQueue<T> {

    void tryEnqueue(T elem);

    T tryDequeue();
}
