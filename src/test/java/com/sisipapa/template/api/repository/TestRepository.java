package com.sisipapa.template.api.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sisipapa.template.api.entity.Member;
import com.sisipapa.template.api.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
public class TestRepository {

    @Autowired
    private EntityManager em;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    @Transactional
    void test4() {
        Member member = new Member();
        member.setName("member1");
        em.persist(member);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setMember(member);
        em.persist(order);

        member.newOrder(order);
        System.out.println("==================================================");
        member.getOrders().stream().forEach(System.out::println);
        System.out.println("==================================================");
    }
}
