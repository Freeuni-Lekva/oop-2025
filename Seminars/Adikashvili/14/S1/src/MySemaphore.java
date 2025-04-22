import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore {

    private int permits;

    private final Lock lock;

    private final Condition condition;

    public MySemaphore(int permits) {
        this.permits = permits;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void acquire() throws InterruptedException {
        lock.lock();

        while (permits == 0) {
            condition.await();
        }
        permits--;

        lock.unlock();
    }

    public void release() {
        lock.lock();

        permits++;
        condition.signal(); // signalAll

        lock.unlock();
    }

    public static void main(String[] args) {
        MySemaphore semaphore = new MySemaphore(0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " acquire");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " acquire");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " release");
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " release");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
