import java.util.List;
import java.util.concurrent.Semaphore;

public abstract class Processor extends Thread {

    protected Semaphore semaphore;

    protected Character[] buffer;

    protected static final int NUM_ITERATIONS = 10;

    public Processor(Semaphore semaphore, Character[] buffer) {
        this.semaphore = semaphore;
        this.buffer = buffer;
    }

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(0);
        Character[] buffer = new Character[NUM_ITERATIONS];

        Reader reader = new Reader(sem, buffer);
        Writer writer = new Writer(sem, buffer);

        reader.start();
        writer.start();
    }
}
