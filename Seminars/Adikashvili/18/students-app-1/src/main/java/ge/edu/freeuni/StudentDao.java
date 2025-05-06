package ge.edu.freeuni;

import bean.Student;
import filter.Filter;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    void removeStudent(Student student);

    List<Student> getAllStudents();

    List<Student> filterStudents(Filter filter);
}
