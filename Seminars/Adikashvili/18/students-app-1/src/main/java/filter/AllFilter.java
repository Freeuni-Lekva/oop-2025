package filter;

import bean.Student;

public class AllFilter implements Filter {
    @Override
    public boolean filter(Student student) {
        return true;
    }

    @Override
    public String toString() {
        return "true";
    }
}
