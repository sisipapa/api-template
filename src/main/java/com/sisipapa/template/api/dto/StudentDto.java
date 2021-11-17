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
@Builder(builderMethodName = "StudentDtoBuilder")
public class StudentDto {

    private Long id;
    private String name;
    private Integer age;
    private SchoolType schoolType;
    private String phoneNumber;
    private List<Subject> subjects;

    public static StudentDtoBuilder builder(Student student) {
        return StudentDtoBuilder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .schoolType(student.getSchoolType())
                .phoneNumber(student.getPhoneNumber())
                .subjects(student.getSubjects());
    }
}
