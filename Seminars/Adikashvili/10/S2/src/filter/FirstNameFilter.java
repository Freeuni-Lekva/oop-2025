package filter;

import table.Student;

public class FirstNameFilter implements Filter {

    private final String firstName;

    public FirstNameFilter(String fistName) {
        this.firstName = fistName;
    }

    @Override
    public boolean filter(Student student) {
        return student.getFirstName().contains(firstName);
    }
}
