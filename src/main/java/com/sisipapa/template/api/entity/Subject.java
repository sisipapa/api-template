package com.sisipapa.template.api.entity;

import com.sisipapa.template.api.dto.StudentDto;
import com.sisipapa.template.api.dto.SubjectDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="subject")
@Builder(builderMethodName = "SubjectBuilder")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Score> scores;

    public static SubjectBuilder builder(SubjectDto subject) {
        return SubjectBuilder()
                .id(subject.getId())
                .name(subject.getName())
                .student(subject.getStudent())
                .scores(subject.getScores());
    }
}
