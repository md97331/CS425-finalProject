package func_Helpers;
import java.sql.*;



public class retrieveData {
    private static Connection connection;
    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "myuser";
    String password = "mypassword";
    try {
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connection established.");
    } catch (SQLException e) {
        System.err.println("Error connecting to database: " + e.getMessage());
    } finally {
        closeConnection();
    }


    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }

}
