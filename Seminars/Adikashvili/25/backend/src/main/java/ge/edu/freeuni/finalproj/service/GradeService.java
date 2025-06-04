package ge.edu.freeuni.finalproj.service;

import ge.edu.freeuni.finalproj.dto.GradeDTO;
import ge.edu.freeuni.finalproj.entity.Grade;
import ge.edu.freeuni.finalproj.repository.GradeRepository;
import ge.edu.freeuni.finalproj.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    private GradeRepository repository;

    public List<String> getStudentMails() {
        return repository.findAll().stream().map(Grade::getStudentMail).toList();
    }

    public List<GradeDTO> getStudentGrades(String email) {
        return repository.findAllByStudentMail(email).stream().map(Helper::toGradeDTO).toList();
    }

    public void addGrade(GradeDTO grade) {
        repository.save(Helper.toGrade(grade));
    }
}
