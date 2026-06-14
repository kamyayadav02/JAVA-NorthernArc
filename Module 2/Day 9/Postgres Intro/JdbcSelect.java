package jdbcdemo;

import java.sql.*;

public class JdbcSelect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/northernarc";
        String user = "postgres";
        String password = "12345";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            String sql = "Select id,name from person order by name ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("Executing query: " + sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+ " "+ rs.getString("name"));
            }
            System.out.println("Data read Successfully");

        } catch(SQLException e){
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}