package org.northernarc.jwtdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class JPAUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String user;
    private String password;
    private String role;
}
