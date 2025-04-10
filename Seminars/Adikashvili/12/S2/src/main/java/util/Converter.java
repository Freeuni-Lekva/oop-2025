package util;

import dto.StudentDTO;
import entities.Student;

public class Converter {

    public static StudentDTO toStudentDTO(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName());
    }
}
