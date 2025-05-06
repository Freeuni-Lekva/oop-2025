package filter;

import bean.Student;

public class FirstNameFilter implements Filter {

    private final String firstName;

    public FirstNameFilter(String fistName) {
        this.firstName = fistName;
    }

    @Override
    public boolean filter(Student student) {
        return student.getFirstName().contains(firstName);
    }

    @Override
    public String toString() {
        return "first_name = '" + firstName + "' ";
    }
}
