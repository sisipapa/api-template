package com.sisipapa.template.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Table(name = "MemberL") // 기존 멤버 Entity가 존재해서 MemberL로 변경
@Entity
public class MemberL {  // 기존 멤버 Entity가 존재해서 MemberL로 변경

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userName;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "locker_id")
    private Locker locker;
}
