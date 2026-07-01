package org.northernarc.unittestingdemo.repository;

import org.northernarc.unittestingdemo.model.Product;

import java.util.List;

public interface ProductRepo {

    Product save(Product product);

    Product findById(int id);

    List<Product> findAll();

    void deleteById(int id);
}
