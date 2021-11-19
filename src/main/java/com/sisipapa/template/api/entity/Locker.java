package com.sisipapa.template.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Table(name = "Locker")
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locker_id")
    private Long id;

    private String name;

    @OneToOne(fetch = LAZY, mappedBy = "locker")
    private MemberL memberL;
}
