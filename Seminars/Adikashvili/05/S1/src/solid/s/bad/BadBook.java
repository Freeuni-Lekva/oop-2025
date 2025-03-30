package solid.s.bad;

public class BadBook {

    private String name;

    private int releaseYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void saveToDatabase() {
        System.out.println("...");
    }
}
