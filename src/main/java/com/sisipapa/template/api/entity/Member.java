package com.sisipapa.template.api.entity;

import com.sisipapa.template.api.dto.Address;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DynamicUpdate
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    public void newOrder(Order order) {
        this.orders.add(order);
    }
}
