import java.util.ArrayList;
import java.util.List;

public class Store {

    private DisplayListener displayListener;

    private final List<Student> students; // all students

    private Filter filter;

    public Store() {
        this.students = new ArrayList<>();
        this.filter = new AllFilter();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        filterStudents();
    }

    public void addFilter(Filter filter) {
        this.filter = filter;
        filterStudents();
    }

    public void registerDisplayListener(DisplayListener displayListener) {
        this.displayListener = displayListener;
    }

    public void fireStudentsChanged(List<Student> newStudents) {
        this.displayListener.studentsChanged(newStudents);
    }

    public void filterStudents() {

        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : students) {
            if (filter.filter(student)) {
                filteredStudents.add(student);
            }
        }

        fireStudentsChanged(filteredStudents);
    }
}
