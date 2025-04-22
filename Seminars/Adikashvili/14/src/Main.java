import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(0);
        List<Character> buffer = new ArrayList<>();
        for (int i = 0; i < 10; i++) buffer.add(null);

        System.out.println(buffer.size());

        Reader reader = new Reader(buffer, semaphore);
        Writer writer = new Writer(buffer, semaphore);

        reader.start();
        writer.start();
    }
}
