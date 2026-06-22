package org.northernarc.springdatajpademo1.repository;

import org.northernarc.springdatajpademo1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByBrand(String brand);
}
