package filter;

import table.Student;

public class YearFilter implements Filter {

    private int year;

    public YearFilter(int year) {
        this.year = year;
    }


    @Override
    public boolean filter(Student student) {
        return false;
    }
}
