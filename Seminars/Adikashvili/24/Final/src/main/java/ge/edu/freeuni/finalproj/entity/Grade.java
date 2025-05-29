package ge.edu.freeuni.finalproj.entity;

import ge.edu.freeuni.finalproj.constants.Criterion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Criterion criterion;

    @NonNull
    private Integer score;

    @NonNull
    private String comment;

    @NonNull
    private String studentMail;
}
