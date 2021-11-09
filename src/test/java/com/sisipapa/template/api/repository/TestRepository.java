package com.sisipapa.template.api.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sisipapa.template.api.cenum.SchoolType;
import com.sisipapa.template.api.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

import static com.sisipapa.template.api.entity.QStudent.student;
import static java.util.stream.Collectors.*;

@SpringBootTest
public class TestRepository {

    @Autowired
    private EntityManager em;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @BeforeEach
    void init(){
        Student student1 = new Student();
        student1.setAge(10);
        student1.setName("초딩1");
        student1.setPhoneNumber("010-1111-1110");
        student1.setSchoolType(SchoolType.ELEMANTARY);
        em.persist(student1);

        Student student2 = new Student();
        student2.setAge(15);
        student2.setName("중딩1");
        student2.setPhoneNumber("010-2222-2220");
        student2.setSchoolType(SchoolType.MIDDLE);
        em.persist(student2);

        Student student4 = new Student();
        student4.setAge(16);
        student4.setName("중딩2");
        student4.setPhoneNumber("010-2222-2221");
        student4.setSchoolType(SchoolType.MIDDLE);
        em.persist(student4);

        Student student3 = new Student();
        student3.setAge(18);
        student3.setName("고딩1");
        student3.setPhoneNumber("010-3333-3330");
        student3.setSchoolType(SchoolType.HIGH);
        em.persist(student3);
    }

    @Test
    @Transactional
    void query1(){
        List<Student> students = jpaQueryFactory
                .selectFrom(student)
                .where(student.age.between(15,20).and(student.name.contains("중딩")))
                .fetch();

        students.forEach(student -> System.out.println(student.getName()));
        
        // 단일필드 그룹화
        Map<SchoolType, List<Student>> result = students.stream()
                .collect(groupingBy(Student::getSchoolType));
        System.out.println(result);
        
        // 다중필드 그룹화
        Map<SchoolType, Map<String, List<Student>>> result2 = students.stream()
                .collect(groupingBy(Student::getSchoolType, groupingBy(Student::getName)));
        System.out.println(result2);

        // 그룹별 카운트
        Map<SchoolType, Long> result3 = students.stream()
                .collect(groupingBy(Student::getSchoolType, counting()));
        System.out.println(result3);

        // 그룹별 평균
        Map<SchoolType, Double> result4 = students.stream()
                .collect(groupingBy(Student::getSchoolType, averagingDouble(Student::getAge)));
        System.out.println(result4);

        // 그룹별 최대값
        Map<SchoolType, Optional<Student>> result5 = students.stream()
                .collect(groupingBy(Student::getSchoolType, maxBy(Comparator.comparingInt(Student::getAge))));
        System.out.println(result5);

        // 그룹화 요약
        Map<SchoolType, IntSummaryStatistics> result6 = students.stream()
                .collect(groupingBy(Student::getSchoolType, summarizingInt(Student::getAge)));
        System.out.println(result6);
    }
}
