package filter;

import bean.Student;

public class LastNameFilter implements Filter {

    private final String lastName;

    public LastNameFilter(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean filter(Student student) {
        return student.getLastName().contains(lastName);
    }

    @Override
    public String toString() {
        return "last_name = '" + lastName + "' ";
    }
}
