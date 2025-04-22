import java.util.concurrent.Semaphore;

public class Writer extends Processor {

    public Writer(Semaphore semaphore, Character[] buffer) {
        super(semaphore, buffer);
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            buffer[i] = (char)(i + 'a');
            System.out.println("write: " + buffer[i]);
            semaphore.release();
        }
    }
}
