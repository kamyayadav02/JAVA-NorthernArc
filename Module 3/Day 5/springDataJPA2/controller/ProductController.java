package org.northernarc.springdatajpademo1.controller;

import org.northernarc.springdatajpademo1.model.Product;
import org.northernarc.springdatajpademo1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{pid}")
    public String deleteProduct(@PathVariable Long pid) {
        productService.deleteById(pid);
        return "Product with ID " + pid + " has been deleted.";
    }

    @GetMapping("/brand/{brand}")
    public List<Product> findByBrand(@PathVariable String brand) {
        return productService.getByBrand(brand);
    }

    @GetMapping("/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.getByName(name);
    }

}
