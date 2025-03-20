package solid.i.bad;

public class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots can't eat");
    }
}
