package ge.edu.freeuni;

import bean.Student;
import filter.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class StudentDaoImpl implements StudentDao {

    List<Student> students;

    public StudentDaoImpl() {
        this.students = new Vector<>();
    }

    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(this.students);
    }

    @Override
    public List<Student> filterStudents(Filter filter) {
        return new ArrayList<>();
    }
}
