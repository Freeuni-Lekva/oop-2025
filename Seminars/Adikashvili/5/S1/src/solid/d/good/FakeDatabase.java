package solid.d.good;

public class FakeDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("fake connect");
    }

    @Override
    public void executeQuery() {

    }
}
