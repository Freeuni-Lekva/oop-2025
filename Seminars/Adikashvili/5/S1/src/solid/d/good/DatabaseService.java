package solid.d.good;

public class DatabaseService {

    private final Database database;

    public DatabaseService(Database database) {
        this.database = database;
    }

    public void executeQuery() {
        this.database.executeQuery();
    }
}
