public class ThreadWorker extends Thread {

    private String name;

    private static final int NUM_ITERATIONS = 1000000;

    public ThreadWorker(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= NUM_ITERATIONS; i++) {
            if (i % 100 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
