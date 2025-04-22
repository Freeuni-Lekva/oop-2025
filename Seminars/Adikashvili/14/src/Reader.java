import java.util.List;
import java.util.concurrent.Semaphore;

public class Reader extends Thread {

    private List<Character> buffer;

    private Semaphore semaphore;

    public Reader(List<Character> buffer, Semaphore semaphore) {
        this.buffer = buffer;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                semaphore.acquire(); // waits for writer to increase permits

                System.out.println("read: " + buffer.get(i));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
