package dao;

import entity.Product;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDaoImplCollections implements ProductDao {

    private Map<Integer, Product> products = new LinkedHashMap<>();

    @Override
    public int save(Product product) {
        products.put(product.getProductId(), product);
        return 0;
    }

    @Override
    public Product findById(int productId) {
        return products.get(productId);
    }

    @Override
    public void deleteById(int productId) {
        products.remove(productId);
    }

    @Override
    public void updateById(int productId, Product product) {
        Product existing = products.get(productId);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setBrand(product.getBrand());
            existing.setCategory(product.getCategory());
        }
    }

    @Override
    public void deleteAll() {
        products.clear();
    }

    @Override
    public Collection<Product> findAll() {
        return products.values();
    }
}