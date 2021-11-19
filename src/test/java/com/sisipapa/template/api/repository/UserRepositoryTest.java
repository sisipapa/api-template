package com.sisipapa.template.api.repository;

import com.google.common.collect.Table;
import com.sisipapa.template.api.entity.CellularPhone;
import com.sisipapa.template.api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CellularPhoneRepository phoneRepository;

    @Test
    @Transactional
    void test1(){
        CellularPhone cellularPhone = CellularPhone.builder()
                .model("android")
                .phoneNumber("010-2342-5234")
                .build();
        phoneRepository.save(cellularPhone);

        User user = User.builder()
                .name("Frank")
                .email("sdf@sdf.com")
                .username("id1234")
                .password("1234")
                .cellularPhone(cellularPhone)
                .build();

        userRepository.save(user);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getName()).isEqualTo("Frank");
        assertThat(users.get(0).getCellularPhone().getPhoneNumber()).isEqualTo("010-2342-5234");

    }

    @Test
    @Transactional
    void test2(){
        CellularPhone cellularPhone = CellularPhone.builder()
                .model("android")
                .phoneNumber("010-2342-5234")
                .build();

        User user = User.builder()
                .name("Frank")
                .email("sdf@sdf.com")
                .username("id1234")
                .password("1234")
                .cellularPhone(cellularPhone)
                .build();

        cellularPhone.setUser(user); //CellularPhone에서 User 객체 설정
        userRepository.save(user);
        phoneRepository.save(cellularPhone);

        List<User> users = userRepository.findAll();
        System.out.println(users.get(0).getCellularPhone().getModel().startsWith("android")); //(1).지연로딩으로 동작한다
//        assertThat(users.get(0).getCellularPhone().getModel()).startsWith("android");

        System.out.println("===========================================================================");

        List<CellularPhone> phones = phoneRepository.findAll(); //(2).User도 같이 조회된다.
    }
}
