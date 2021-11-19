package com.sisipapa.template.api.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cellular_phone")
@Entity
public class CellularPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long id;

    private String phoneNumber;
    private String model;

    @OneToOne(mappedBy = "cellularPhone", fetch = LAZY)
    private User user;
}
