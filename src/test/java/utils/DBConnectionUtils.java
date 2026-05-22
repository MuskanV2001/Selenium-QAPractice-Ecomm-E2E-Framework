package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtils {
    private static Connection connection;

    public static Connection getSQLConnection(){

        try{

            if(connection==null || connection.isClosed()){
                String connectUrl = ConfigPropertiesReader.getConfigProperty("dbConnectUrl");
                String username = ConfigPropertiesReader.getConfigProperty("dbUsername");
                String password = ConfigPropertiesReader.getConfigProperty("dbPassword");

                connection = DriverManager.getConnection(connectUrl, username, password);
            }
        }
        catch(Exception e){
            System.out.println("Error connecting to SQL Database -> " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("MySQL Connection created successfully");
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("MySQL Connection closed successfully");
            }
        }
        catch (SQLException e) {
            System.out.println("Error closing SQL Database connection -> " + e.getMessage());
            e.printStackTrace();
        }
    }
}
