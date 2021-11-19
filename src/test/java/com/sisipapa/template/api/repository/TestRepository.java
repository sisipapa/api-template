package com.sisipapa.template.api.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sisipapa.template.api.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
public class TestRepository {

    @Autowired
    private EntityManager em;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LockerRepository lockerRepository;

    @Test
    @Transactional
    void test1() {
        Member member = new Member();
        member.setName("member1");
        em.persist(member);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setMember(member);
        em.persist(order);

        member.newOrder(order);
        System.out.println("==================================================");
        member.getOrders().forEach(System.out::println);
        System.out.println("==================================================");
    }

    @Test
    @Transactional
    void test2(){
        Post post = new Post();
        post.setTitle("게시글 제목");

        Comment comment1 = new Comment();
        comment1.setComment("댓글1");
        post.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setComment("댓글2");
        post.addComment(comment2);

        em.persist(post);
//        Session session = em.unwrap(Session.class);
//        session.save(post);

        System.out.println("persist ###########################");
        post.getComments().forEach(comment -> System.out.println(comment.getId() + " : " + comment.getComment()));

        em.remove(post);

        Comment findCommentT = em.find(Comment.class, 1L);
        if(Objects.nonNull(findCommentT)){
            System.out.println("remove ###########################");
            System.out.println(findCommentT.getId() + " : " + findCommentT.getComment());
        }else{
            System.out.println("DELETED - CascadeType.ALL");
        }
    }

    @Test
    @Transactional
    void test3(){

//        MemberL memberL = new MemberL();
//        memberL.setUserName("userName1");
//
//        Locker locker = new Locker();
//        locker.setName("name");
//        memberL.setLocker(locker);
//
//        em.persist(memberL);

        MemberL memberL = memberRepository.findById(1L).get();
        System.out.println("=====================================================");
        Locker locker = lockerRepository.findById(1L).get();
        System.out.println("=====================================================");
    }
}
