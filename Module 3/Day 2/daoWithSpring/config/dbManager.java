package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager {
    public  final String db_url;
    public  final String user;
    public  final String password;

    public dbManager(String db_url, String user, String password) {
        this.db_url=db_url;
        this.user=user;
        this.password=password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url,user,password);
    }
    public  void closeConnection(Connection connection){
        if(connection!=null){
            try{
                connection.close();
                connection=null;
            } catch (SQLException e){
                System.out.println(" Error closing connection: "+ e.getMessage());
            }
        }
    }
}
