public class Worker extends Thread {

    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
