package org.northernarc.unittestingdemo.service;

import org.northernarc.unittestingdemo.model.Product;
import org.northernarc.unittestingdemo.repository.ProductRepo;

import java.util.List;

public class ProductService  {

    private final ProductRepo productRepo;

        public ProductService(ProductRepo productRepo) {
            this.productRepo = productRepo;
        }

        // Add Product
        public Product addProduct(Product product) {
            return productRepo.save(product);
        }

        // Get Product By Id
        public Product getProductById(int id) {
            return productRepo.findById(id);
        }

        // Get All Products
        public List<Product> getAllProducts() {
            return productRepo.findAll();
        }


    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

}
