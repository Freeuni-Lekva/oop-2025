import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImpl<T> implements BlockingQueue<T> {

    private List<T> elements;

    private int maxSize;

    private Lock lock;

    private Condition enqueueCondition;

    private Condition dequeueCondition;

    public BlockingQueueImpl(int maxSize) {
        elements = new ArrayList<>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();
        this.enqueueCondition = this.lock.newCondition();
        this.dequeueCondition = this.lock.newCondition();
    }

    @Override
    public void tryEnqueue(T elem) {
        try {
            lock.lock();

            boolean okToEnqueue = elements.size() < maxSize;

            while (elements.size() == maxSize) {
                okToEnqueue = enqueueCondition.await(3, TimeUnit.SECONDS);
            }

            if (!okToEnqueue) {
                return;
            }

            elements.add(elem);
            dequeueCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T tryDequeue() {
        try {
            lock.lock();

            boolean okToDequeue = !elements.isEmpty();

            while (elements.isEmpty()) {
                okToDequeue = dequeueCondition.await(3, TimeUnit.SECONDS);
            }

            if (!okToDequeue) {
                return null;
            }

            T elem = elements.removeFirst();
            enqueueCondition.signal();
            return elem;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
