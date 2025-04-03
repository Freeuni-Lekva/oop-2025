package table;

import filter.AllFilter;
import filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class Store { // in-memory database

    private DisplayListener displayListener;

    private final List<Student> students;

    private Filter filter;

    public Store() {
        this.students = new ArrayList<>();
        this.filter = new AllFilter();
    }

    public void addStudent(Student student) {
        this.students.add(student);
        fireStudentsChanged(this.students);
    }

    public void addFilter(Filter filter) {
        this.filter = filter;
        fireStudentsChanged(this.students);
    }

    public void registerDisplayListener(DisplayListener displayListener) {
        this.displayListener = displayListener;
    }

    public void fireStudentsChanged(List<Student> newStudents) {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : newStudents) {
            if (filter.filter(student)) {
                filteredStudents.add(student);
            }
        }

        System.out.println(filteredStudents);

        this.displayListener.studentsChanged(filteredStudents);
    }

}
