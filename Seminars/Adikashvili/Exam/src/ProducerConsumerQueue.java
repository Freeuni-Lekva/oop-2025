import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerQueue<T> implements BlockingQueue<T> {

    private List<T> elements;

    private Lock lock;

    private Condition enqueueCond;

    private Condition dequeueCond;

    private int capacity;

    public ProducerConsumerQueue(int capacity) {
        this.capacity = capacity;
        lock = new ReentrantLock();
        enqueueCond = lock.newCondition();
        dequeueCond = lock.newCondition();
        elements = new ArrayList<>();
    }

    @Override
    public void put(T elem) throws InterruptedException {
        lock.lock();

        while (capacity == elements.size()) {
            enqueueCond.await();
        }

        elements.add(elem);
        dequeueCond.signal();

        lock.unlock();
    }

    @Override
    public T take() throws InterruptedException {
        try {
            lock.lock();

            while (elements.isEmpty()) {
                dequeueCond.await();
            }

            T elem = elements.removeFirst();
            enqueueCond.signal();

            return elem;
        } finally {
            lock.unlock();
        }
    }
}
