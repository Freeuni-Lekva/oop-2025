package ge.edu.freeuni.finalproj.repository;

import ge.edu.freeuni.finalproj.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudentMail(String email);
}

