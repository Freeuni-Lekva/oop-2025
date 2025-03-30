package solid.d.good;

public class PostgresDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("connecting to postgres");
    }

    @Override
    public void executeQuery() {
        System.out.println("executing");
    }
}
