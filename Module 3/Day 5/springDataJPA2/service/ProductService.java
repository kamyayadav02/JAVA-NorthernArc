package org.northernarc.springdatajpademo1.service;

import org.northernarc.springdatajpademo1.exceptions.ProductNotFound;
import org.northernarc.springdatajpademo1.model.Product;
import org.northernarc.springdatajpademo1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(Long pid) {
        productRepository.deleteById(pid);
    }


    public List<Product> getByBrand(String brand) {

        List<Product> products = productRepository.findByBrand(brand);

        if (products.isEmpty()) {
            throw new ProductNotFound("No products found for brand: " + brand);
        }

        return products;
    }


    public List<Product> getByName(String name) {
        List<Product> products = productRepository.findByName(name);

        if (products.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No products found for name: " + name
            );
        }

        return products;
    }



}
