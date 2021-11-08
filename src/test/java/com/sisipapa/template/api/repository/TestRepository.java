package com.sisipapa.template.api.repository;

import com.sisipapa.template.api.cenum.SchoolType;
import com.sisipapa.template.api.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class TestRepository {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void query1(){
        Student student = new Student();
        student.setAge(10);
        student.setName("test1");
        student.setPhoneNumber("010-1111-1111");
        student.setSchoolType(SchoolType.ELEMANTARY);
        em.persist(student);
    }
}
