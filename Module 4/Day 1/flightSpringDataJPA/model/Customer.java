package org.northernarc.springdatajpademo2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name="Customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phoneno;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
