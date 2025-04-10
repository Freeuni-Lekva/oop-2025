package util;

import dto.StudentDTO;
import entity.Student;

public class Converter {

    public static StudentDTO toStudentDTO(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName());
    }
}
