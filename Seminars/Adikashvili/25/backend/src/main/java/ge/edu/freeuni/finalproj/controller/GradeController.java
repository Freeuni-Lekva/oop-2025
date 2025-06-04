package ge.edu.freeuni.finalproj.controller;

import ge.edu.freeuni.finalproj.dto.GradeDTO;
import ge.edu.freeuni.finalproj.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService service;

    @GetMapping("/mails")
    public List<String> getStudentMails() {
        return service.getStudentMails();
    }

    @GetMapping("/grades/{email}")
    public List<GradeDTO> getGrades(@PathVariable String email) {
        return service.getStudentGrades(email);
    }

    @PostMapping("/add/{email}")
    public ResponseEntity<String> addGrade(@RequestBody GradeDTO grade, @PathVariable String email) {
        if (email.matches(".*[0-9].*")) { // if student
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("student can't add score");
        }
        service.addGrade(grade);
        return ResponseEntity.status(HttpStatus.OK).body("score added");
    }
}
