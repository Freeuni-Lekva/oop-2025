package ge.edu.freeuni.finalproj.util;

import ge.edu.freeuni.finalproj.dto.GradeDTO;
import ge.edu.freeuni.finalproj.entity.Grade;

public class Helper {

    public static Grade toGrade(GradeDTO dto) {
        return new Grade(dto.getCriterion(), dto.getScore(), dto.getComment(), dto.getStudentMail());
    }

    public static GradeDTO toGradeDTO(Grade grade) {
        return new GradeDTO(grade.getCriterion(), grade.getScore(), grade.getComment(), grade.getStudentMail());
    }
}
