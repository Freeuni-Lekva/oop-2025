public class Pair {

    private int first;

    private int second;

    public static int staticVariable;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public synchronized void increment() {
        this.first++;
        this.second++;
    }

    public synchronized int getSum() {
        return this.first + this.second;
    }

    public void increaseStaticVariable() { // non-static
        synchronized (Pair.class) { // takes Pair class lock not instance lock
            staticVariable++;
        }
    }

    public synchronized static void staticIncrement() { // static
        staticVariable++;
    }
}
