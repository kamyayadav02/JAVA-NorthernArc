package dao;

import connection.dbManager;
import entity.Book;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public int save(Product product) {
        try {
            Connection con = dbManager.getConnection();
            String sql = "INSERT INTO product(name,brand,category) VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getCategory());
            int rows = stmt.executeUpdate();
            dbManager.closeConnection(con);
            return rows;
        } catch (SQLException e) {
            System.out.println("Issue in database connectivity" + e.getMessage());
        }
        return 0;

    }

    @Override
    public Product findById(int productId) {
        try {
            Connection con = dbManager.getConnection();
            String sql = "SELECT * FROM product WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapToProduct(rs);
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity" + e.getMessage());
        }
        return null;
    }

    public Product mapToProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("productId"),
                rs.getString("name"),
                rs.getString("brand"),
                rs.getString("category"));
    }

    @Override
    public void deleteById(int productId) {
        try {
            Connection con = dbManager.getConnection();
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, productId);
            stmt.executeUpdate();
            dbManager.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Issue in db connectivity" + e.getMessage());
        }

    }

    @Override
    public void updateById(int productId) {

    }

    @Override
    public void updateById(int productId, Product product) {
        try {
            Connection con = dbManager.getConnection();
            String sql = "UPDATE product SET name=?, brand=?, category=? WHERE id=";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getBrand());
            stmt.setString(3, product.getCategory());
            stmt.setInt(4, productId);
            stmt.executeUpdate();
            dbManager.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());

        }
    }


        @Override
        public void deleteAll () {
            String sql = "DELETE FROM product";

            try (Connection con = dbManager.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Issue in db connectivity: " + e.getMessage());
            }
        }



    @Override
    public Collection<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try{
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM product";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();{
                while(rs.next()){
                    products.add(mapToProduct(rs));
                }
            }
            dbManager.closeConnection(con);
        }catch (SQLException e){
            System.out.println("Issue in db Connectivity." +e.getMessage());
        }
        return products;
    }

    @Override
    public Collection<Product> findByName(String name) {
        List<Product> products =new ArrayList<>();
        try {
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM product WHERE name=?";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(mapToProduct(rs));
            }
            dbManager.closeConnection(con);

        }catch (SQLException e){
            System.out.println("Issue in db Connectivity" + e.getMessage());
        }
        return products;
    }

    @Override
    public Collection<Product> findByBrand(String brand) {
        List <Product> products= new ArrayList<>();
        try{
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM product WHERE brand=?";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1, brand);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
            dbManager.closeConnection(con);
        }catch(SQLException e){
            System.out.println("Issue in db Connectivity" + e.getMessage());
        }
        return products;
    }

    @Override
    public Collection<Product> findByCategory(String category) {
        List<Product> products=new ArrayList<>();
        try{
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM product WHERE category=?";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1,category);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
            dbManager.closeConnection(con);
        }catch(SQLException e){
            System.out.println("Issue in db Connectivity"+ e.getMessage());
        }
        return products;
    }

    @Override
    public Collection<Product> findSortedByBrandAsc() {
        List<Product> products = new ArrayList<>();
        try{
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM products ORDER BY brand ASC";
            PreparedStatement stmt= con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
            dbManager.closeConnection(con);
        }catch(SQLException e){
            System.out.println("Issue in db Connectivity" + e.getMessage());
        }
        return products;

    }

    @Override
    public Collection<Product> findSortedByCategoryAsc() {
        List<Product> products = new ArrayList<>();
        try{
            Connection con=dbManager.getConnection();
            String sql="SELECT * FROM products ORDER BY category ASC";
            PreparedStatement stmt= con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                products.add(mapToProduct(rs));
            }
            dbManager.closeConnection(con);
        }catch(SQLException e){
            System.out.println("Issue in db Connectivity" + e.getMessage());
        }
        return products;
    }
}
