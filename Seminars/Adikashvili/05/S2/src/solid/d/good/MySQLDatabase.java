package solid.d.good;

public class MySQLDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("connecting to my sql");
    }

    @Override
    public void saveUser(String user) {
        System.out.println("saving " + user);
    }
}

