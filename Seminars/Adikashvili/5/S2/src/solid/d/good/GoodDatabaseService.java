package solid.d.good;

public class GoodDatabaseService {

    private final Database database;

    public GoodDatabaseService(Database database) {
        this.database = database;
    }

    public void saveUser(String user) {
        database.saveUser(user);
    }
}
