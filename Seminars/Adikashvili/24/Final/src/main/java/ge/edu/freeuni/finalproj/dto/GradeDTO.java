package ge.edu.freeuni.finalproj.dto;

import ge.edu.freeuni.finalproj.constants.Criterion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {

    private Criterion criterion;

    private Integer score;

    private String comment;

    private String studentMail;
}
