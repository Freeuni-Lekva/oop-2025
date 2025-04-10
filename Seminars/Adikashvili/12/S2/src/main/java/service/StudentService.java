package service;

import dao.StudentDAO;
import dto.StudentDTO;

import static util.Converter.toStudentDTO;

public class StudentService {

    private final StudentDAO dao;

    public StudentService(StudentDAO studentDAO) {
        this.dao = studentDAO;
    }

    public StudentDTO getStudentById(int id) {
        return toStudentDTO(dao.getByStudentId(id));
    }
}
