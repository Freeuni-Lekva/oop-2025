public class PairWorker extends Thread {

    private Pair pair;

    public PairWorker(Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            pair.increment();
        }
    }

    public static void main(String[] args) {
        Pair p = new Pair(0, 0);

        PairWorker pairWorker1 = new PairWorker(p);
        PairWorker pairWorker2 = new PairWorker(p);
        PairWorker pairWorker3 = new PairWorker(p);

        pairWorker1.start();
        pairWorker2.start();
        pairWorker3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    p.nonStaticIncrement();
                }
            }
        });
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                Pair.staticIncrement();
            }
        });

        thread4.start();
        thread5.start();

        try {
            pairWorker1.join();
            pairWorker2.join();
            pairWorker3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println(p.getSum()); // 600000
        System.out.println(Pair.staticVariable);
    }
}
