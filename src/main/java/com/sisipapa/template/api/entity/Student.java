package com.sisipapa.template.api.entity;

import com.sisipapa.template.api.cenum.SchoolType;
import com.sisipapa.template.api.dto.StudentDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="student")
@Builder(builderMethodName = "StudentBuilder")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private SchoolType schoolType;

    @Column(nullable = false)
    private String phoneNumber;

    // mappedBy 속성으로 관계의 주인이 누구인지 알 수 있다. FK를 갖고 있는 갖고 있는 엔티티가 관계의 주인이 되는데, Post 엔티티가 주인이다.
    // 즉, mappedBy를 갖고 있지 않은 엔티티가 주인이다.
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    private List<Subject> subjects;

    public static StudentBuilder builder(StudentDto student) {
        return StudentBuilder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .schoolType(student.getSchoolType())
                .phoneNumber(student.getPhoneNumber())
                .scores(student.getScores());
    }

}
