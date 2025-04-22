import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> implements BlockingQueue<T>{

    private int maxSize;

    private List<T> elements;

    private Lock lock;

    private Condition enqueueCondition;

    private Condition dequeueCondition;

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        this.elements = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.enqueueCondition = this.lock.newCondition();
        this.dequeueCondition = this.lock.newCondition();
    }


    @Override
    public void tryEnqueue(T element, int time) {
        try {
            lock.lock();

            boolean okToEnqueue;

            while (elements.size() == maxSize) {
                okToEnqueue = enqueueCondition.await(time, TimeUnit.MILLISECONDS);

                if (!okToEnqueue) {
                    System.out.println(Thread.currentThread().getName() + " Couldn't enqueue");
                    return;
                }
            }

            elements.add(element);
            System.out.println(Thread.currentThread().getName() + " Enqueued: " + element);
            dequeueCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T tryDequeue(int time) {
        try {
            lock.lock();

            boolean okToDequeue;

            while (elements.isEmpty()) {
                okToDequeue = dequeueCondition.await(time, TimeUnit.MILLISECONDS);

                if (!okToDequeue) {
                    System.out.println(Thread.currentThread().getName() + " Couldn't dequeue");
                    return null;
                }
            }

            T element = elements.remove(0);
            System.out.println(Thread.currentThread().getName() + " Dequeued: " + element);
            enqueueCondition.signal();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
