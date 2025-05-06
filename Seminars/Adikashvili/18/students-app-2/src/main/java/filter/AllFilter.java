package filter;

import com.example.Student;

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
