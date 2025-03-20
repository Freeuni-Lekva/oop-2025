package solid.d.bad;

public class BadDatabaseService {

    private BadMySQLDatabase badMySQLDatabase;

    public BadDatabaseService(BadMySQLDatabase badMySQLDatabase) {
        this.badMySQLDatabase = badMySQLDatabase;
    }

    public void saveUser(String user) {
        badMySQLDatabase.saveUser(user);
    }
}
