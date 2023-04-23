package func_Helpers;
import classes_SQL.*;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;


public class retrieveData {
    private static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/airline";
    static String username = "root";
    static String password = "First5210";


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

    public static void openConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public static Passenger getPassengerData(int currPsgID) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM Passenger WHERE PsgID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, currPsgID);

        ResultSet rs = stmt.executeQuery();
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String password = rs.getString("pwd");
        String gender = rs.getString("gender");
        String DOB = rs.getString("DOB");
        String passport = rs.getString("passport");
        int age = rs.getInt("age");
        String creditCardInfo = rs.getString("creditCardInfo");
        String cellphone = rs.getString("cellphone");

        Passenger returnedPassenger = new Passenger(currPsgID,firstName,lastName,password,gender,DOB, passport, age, creditCardInfo,cellphone);

        rs.close();
        closeConnection();
        return returnedPassenger;
    }


}
