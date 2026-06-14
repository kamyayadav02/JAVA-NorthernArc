package jdbcdemo;

import java.sql.*;

public class jdbcUpdate {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/northernarc";
        String user = "postgres";
        String password = "12345";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            String sql = "UPDATE person SET name = kamya, email= kamya.northernarc.com WHERE id = 2 ";
            PreparedStatement stmt = conn.prepareStatement(sql);

            System.out.println("Executing query: " + sql);

            stmt.setString(1, "kamya");
            stmt.setInt(2, 1);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Data Updated Successfully");
            } else {
                System.out.println("No rows updated");
            }

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}