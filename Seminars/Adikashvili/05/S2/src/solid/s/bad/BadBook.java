package solid.s.bad;

public class BadBook {

    private String name;

    private String content;

    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printContent() {

    }

    public void saveToDatabase() {
        // saves in database
    }
}
