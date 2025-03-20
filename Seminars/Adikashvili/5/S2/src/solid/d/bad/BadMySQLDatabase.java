package solid.d.bad;

public class BadMySQLDatabase {

    public void connect() {
        System.out.println("connecting to my sql");
    }

    public void saveUser(String user) {
        System.out.println("saving " + user);
    }
}
