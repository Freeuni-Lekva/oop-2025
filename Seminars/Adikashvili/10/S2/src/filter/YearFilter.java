package filter;

import table.Student;

public class YearFilter implements Filter {

    private final int year;

    public YearFilter(int year) {
        this.year = year;
    }

    @Override
    public boolean filter(Student student) {
        return this.year == student.getYear();
    }
}
