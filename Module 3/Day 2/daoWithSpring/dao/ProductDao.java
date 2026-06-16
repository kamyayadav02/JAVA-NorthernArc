package dao;

import entity.Product;

import java.util.Collection;

public interface ProductDao {
    public int save(Product product);
    public Product findById(int productId);
    public void deleteById(int productId);


    void updateById(int productId, Product product);

    public void deleteAll();
    public Collection<Product> findAll();
}