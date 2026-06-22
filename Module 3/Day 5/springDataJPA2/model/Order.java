package org.northernarc.springdatajpademo1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name="orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String name;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

}
