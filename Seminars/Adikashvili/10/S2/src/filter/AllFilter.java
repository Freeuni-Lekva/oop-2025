package filter;

import table.Student;

public class AllFilter implements Filter {
    @Override
    public boolean filter(Student student) {
        return true;
    }
}
