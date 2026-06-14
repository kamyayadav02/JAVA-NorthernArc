package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcCreate {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/northernarc";
        String user="postgres";
        String password="12345";
        try(Connection conn= DriverManager.getConnection(url,user,password)){
            System.out.println("Connected to the PostgreSQL server successfully.");

           String sql="Create table if not exists person(id serial primary key,name varchar(255),email varchar(255))";

            PreparedStatement stmt=conn.prepareStatement(sql);
            System.out.println("Executing query: " + sql);
            stmt.execute();

            System.out.println("Table created successfully.");
        }catch (SQLException e){
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
