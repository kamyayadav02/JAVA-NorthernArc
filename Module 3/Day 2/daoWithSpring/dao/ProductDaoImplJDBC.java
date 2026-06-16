package dao;

import config.dbManager;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDaoImplJDBC implements ProductDao {

    private dbManager dbManager;

    // Constructor Injection
    public ProductDaoImplJDBC(dbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public int save(Product product) {
        String sql = "INSERT INTO product(name, brand, category) VALUES (?, ?, ?)";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getCategory());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public Product findById(int productId) {
        String sql = "SELECT * FROM product WHERE id=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, productId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToProduct(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return null;
    }


    private Product mapToProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("productId"),
                rs.getString("name"),
                rs.getString("brand"),
                rs.getString("category")
        );
    }


    @Override
    public void deleteById(int productId) {
        String sql = "DELETE FROM product WHERE id=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }


    @Override
    public void updateById(int productId, Product product) {
        String sql = "UPDATE product SET name=?, brand=?, category=? WHERE id=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getCategory());
            stmt.setInt(4, productId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }


    @Override
    public void deleteAll() {
        String sql = "DELETE FROM product";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }


    @Override
    public Collection<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return list;
    }
}