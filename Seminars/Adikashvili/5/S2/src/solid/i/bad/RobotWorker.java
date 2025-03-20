package solid.i.bad;

public class RobotWorker implements Worker{
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Can't eat");
    }
}
