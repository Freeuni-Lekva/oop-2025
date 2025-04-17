public class RunnableWorker implements Runnable {

    @Override
    public void run() {
        System.out.println("running " + Thread.currentThread().getName());
    }
}
