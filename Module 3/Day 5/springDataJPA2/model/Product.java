package org.northernarc.springdatajpademo1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String name;
    private String brand;
    private String category;
    private Double price;
}
