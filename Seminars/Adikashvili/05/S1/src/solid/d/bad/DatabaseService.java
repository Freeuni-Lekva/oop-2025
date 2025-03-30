package solid.d.bad;

public class DatabaseService {

    private PostgresDatabase postgresDatabase;

    public DatabaseService(PostgresDatabase postgresDatabase) {
        this.postgresDatabase = postgresDatabase;
    }

    public void executeQuery() {
        this.postgresDatabase.executeQuery();
    }
}
