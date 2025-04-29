import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class Race {

    private static class Runner extends Thread {

        private final int id;
        private final CountDownLatch startLatch;
        private final CountDownLatch finishLatch;
        private final List<Integer> finishOrder;

        public Runner(int id, CountDownLatch startLatch, CountDownLatch finishLatch, List<Integer> finishOrder) {
            this.id = id;
            this.startLatch = startLatch;
            this.finishLatch = finishLatch;
            this.finishOrder = finishOrder;
        }

        @Override
        public void run() {

            try {
                startLatch.await(); // waits for main thread

                System.out.println("Runner " + id + " started");

                finishOrder.add(id);
                finishLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(n);

        List<Integer> finishOrder = new Vector<>();

        for (int i = 0; i < n; i++) {
            Runner runner = new Runner(i, startLatch, finishLatch, finishOrder);
            runner.start();
        }

        System.out.println("Race started!");
        startLatch.countDown();

        finishLatch.await();

        System.out.println("Race finished \n");
        System.out.println("Top 3");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Top " + i + ": " + finishOrder.get(i - 1));
        }
    }
}
