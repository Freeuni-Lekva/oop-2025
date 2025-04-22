import java.util.List;
import java.util.concurrent.Semaphore;

public class Writer extends Thread {

    private List<Character> buffer;

    private Semaphore semaphore;

    public Writer(List<Character> buffer, Semaphore semaphore) {
        this.buffer = buffer;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < buffer.size(); i++) {
            buffer.set(i, (char) ('a' + i));
            System.out.println("write: " + (char) ('a' + i));

            semaphore.release();
        }
    }
}
