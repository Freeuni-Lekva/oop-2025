package ge.edu.freeuni;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    void removeStudent(Student student);

    List<Student> getAllStudents();
}
