import java.util.concurrent.Semaphore;

public class Reader extends Processor {

    public Reader(Semaphore semaphore, Character[] buffer) {
        super(semaphore, buffer);
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            try {
                semaphore.acquire();
                System.out.println("read: " + buffer[i]);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
