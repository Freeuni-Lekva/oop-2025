public class Main {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(5);

        Thread[] producers = new Thread[10];
        for (int i = 0; i < 10; i++) {
            producers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        blockingQueue.tryEnqueue(i, 1);
                    }
                }
            });
        }

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int element = blockingQueue.tryDequeue(1);
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            producers[i].start();
        }
        consumer.start();
    }
}
