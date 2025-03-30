package solid.s.good;

public class GoodBook {

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

    public boolean hasShortContent() {
        return true;
    }
}
