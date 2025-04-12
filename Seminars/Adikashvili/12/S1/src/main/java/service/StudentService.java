package service;

import dao.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import static util.Converter.toStudentDTO;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO dao) {
        this.studentDAO = dao;
    }

    public StudentDTO getStudentById(int id) {
        Student student = studentDAO.getStudentById(id);
        return toStudentDTO(student);
    }
}
