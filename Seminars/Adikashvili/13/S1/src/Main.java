
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadWorker worker1 = new ThreadWorker("Thread 1");
        ThreadWorker worker2 = new ThreadWorker("Thread 2");
        ThreadWorker worker3 = new ThreadWorker("Thread 3");

        Thread worker4 = new Thread(new RunnableWorker());

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();

        System.out.println("End");
    }
}
