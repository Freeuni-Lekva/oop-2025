public class FirstNameFilter implements Filter {

    private final String firstName;

    public FirstNameFilter(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean filter(Student student) {
        return student.getFirstName().contains(firstName);
    }
}
