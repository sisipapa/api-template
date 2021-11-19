package com.sisipapa.template.api;

import com.sisipapa.template.api.entity.Locker;
import com.sisipapa.template.api.entity.MemberL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * 종 주문 2개
 * * userA
 * 	 * JPA1 BOOK
 * 	 * JPA2 BOOK
 * * userB
 * 	 * SPRING1 BOOK
 * 	 * SPRING2 BOOK
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            MemberL memberL = new MemberL();
            memberL.setUserName("userName1");

            Locker locker = new Locker();
            locker.setName("name");
            memberL.setLocker(locker);

            em.persist(memberL);
        }

    }
}

