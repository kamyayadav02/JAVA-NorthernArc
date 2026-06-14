package dao;

import connection.dbManager;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public int save(Book book) {
        try {
            Connection con=dbManager.getConnection();
            String sql="INSERT INTO book (title,author,publisher) VALUES (?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1,book.getTitle());
            stmt.setString(2,book.getAuthor());
            stmt.setString(3,book.getPublisher());
            int rows =stmt.executeUpdate();
            dbManager.closeConnection(con);
            return rows;

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity"+e.getMessage());
        }
        return 0;
    }

    @Override
    public Book findById(int id) {
        try(Connection con =dbManager.getConnection();) { //no need to close connection now as it is in try resource

            String sql="SELECT * FROM book WHERE id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs =stmt.executeQuery();
            if(rs.next()){
                return mapToBook(rs);
            }
        } catch (SQLException e) {
            System.out.println("Issue in db connectivity" +e.getMessage());
        }
        return null;
    }
    public Book mapToBook(ResultSet rs) throws SQLException{
        return new Book(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("publisher"));
    }

    @Override
    public void deleteById(int id) {

        String sql = "DELETE FROM book WHERE id=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }

    }

    @Override
    public void updateById(int id, Book book) {

        String sql = "UPDATE book SET title=?, author=?, publisher=? WHERE id=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }


    }

    @Override
    public void deleteAll() {

        String sql = "DELETE FROM book";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }


    }

    @Override
    public Collection<Book> findAll() {


        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }
        return books;
    }


        @Override
    public Collection<Book> findByAuthor(String Author) {

            List<Book> books = new ArrayList<>();
            String sql = "SELECT * FROM book WHERE author=?";

            try (Connection con = dbManager.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setString(1, Author);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    books.add(mapToBook(rs));
                }

            } catch (SQLException e) {
                System.out.println("Issue in db connectivity: " + e.getMessage());
            }
            return books;

        }

    @Override
    public Collection<Book> findByTitle(String Title) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book WHERE title=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }
        return books;
    }

    @Override
    public Collection<Book> findByPublisher(String Publisher) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book WHERE publisher=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }
        return books;
    }

    @Override
    public Collection<Book> findSortedByTitleAsc() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book order by title ASC";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }
        return books;
    }

    @Override
    public Collection<Book> findSortedByTitleDesc() {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM book order by title DESC";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }
        return books;
    }

    @Override
    public Collection<Book> findByTitleAndPublisher(String title, String publisher) {

        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE title=? AND publisher=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, publisher);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }

        return books;
    }
}
