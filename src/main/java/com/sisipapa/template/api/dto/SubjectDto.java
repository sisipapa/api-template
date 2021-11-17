package com.sisipapa.template.api.dto;

import com.sisipapa.template.api.cenum.SchoolType;
import com.sisipapa.template.api.entity.Score;
import com.sisipapa.template.api.entity.Student;
import com.sisipapa.template.api.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(builderMethodName = "SubjectDtoBuilder")
public class SubjectDto {

    private Long id;
    private String name;
    private Student student;
    private List<Score> scores;

    public static SubjectDtoBuilder builder(Subject subject) {
        return SubjectDtoBuilder()
                .id(subject.getId())
                .name(subject.getName())
                .student(subject.getStudent())
                .scores(subject.getScores());
    }
}
