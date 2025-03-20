package solid.i.good;

public class HumanWorker implements Workable, Eatable {

    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
