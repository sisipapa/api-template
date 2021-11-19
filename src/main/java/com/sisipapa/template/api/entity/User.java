package com.sisipapa.template.api.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String username;

    private String email;

    private String password;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "phone_id")
    private CellularPhone cellularPhone;
}
