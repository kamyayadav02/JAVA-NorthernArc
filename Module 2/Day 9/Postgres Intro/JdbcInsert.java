package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/northernarc";
        String user = "postgres";
        String password = "12345";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            String sql = "Insert into person (name,email) values ('John','john@northernarc.com'),('Riya','riya@northernarc.com')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("Executing query: " + sql);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated);
            System.out.println("Table Created Successfully");

        } catch(SQLException e){
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}