import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosophers {

    private static final int NUM_PHILOSOPHERS = 100;

    // inner class
    private static class Philosopher extends Thread {

        private final int id;
        private final Semaphore room;
        private final Lock[] forks;

        public Philosopher(int id, Semaphore room, Lock[] forks) {
            this.id = id;
            this.room = room;
            this.forks = forks;
        }

        private void think() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " is thinking");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " is eating");
            Thread.sleep((long) (Math.random() * 1000));
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    think();

                    room.acquire(); // enters room

                    forks[id].lock();
                    forks[(id + 1) % NUM_PHILOSOPHERS].lock();

                    eat();

                    forks[id].unlock();
                    forks[(id + 1) % NUM_PHILOSOPHERS].unlock();

                    room.release(); // leaves room
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Semaphore room = new Semaphore(NUM_PHILOSOPHERS - 1);
        Lock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, room, forks);
            philosophers[i].start();
        }
    }

}
