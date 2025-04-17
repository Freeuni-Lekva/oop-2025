import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Worker w1 = new Worker("Nakadi 1");
        Worker w2 = new Worker("Nakadi 2");
        Worker w3 = new Worker("Nakadi 3");
        Thread w4 = new Thread(new RunnableWorker());
//        w1.setDaemon(true);
//        w2.setDaemon(true);
//        w3.setDaemon(true);
//        w4.setDaemon(true);

        w1.setPriority(Thread.MIN_PRIORITY);
        w4.setPriority(Thread.MAX_PRIORITY);

        w1.start();
        w2.start();
        w3.start();
        w4.start();

        w1.join();
        w2.join();
        w3.join();
        w4.join();

        System.out.println("End");
    }
}
